package passwordMeter;

public class RepeatCharacters extends RequirementProperty implements DeductionBuilder{
    private RequirementLevel reqLevel;
    public int countRepeatedCharacter, bonusRepeatedCharacter;
    private double incrementDeductionOfRepeatedChars;

    public RepeatCharacters(String password) {
        super(password);
        calculateCountOfRepeatedCharacters(password);
        calculateBonusOfRepeatedCharacters();
        calculateRequirementLevel();
    }

    public void calculateCountOfRepeatedCharacters(String password) {
        String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {
            var bCharExists = false;
            for (int j = 0; j < arrPwd.length; j++) {
                if (arrPwd[i].equals(arrPwd[j]) && i != j) {
                    bCharExists = true;
                    incrementDeductionOfRepeatedChars += Math.abs(arrPwd.length / (j - i));
                }
            }
            if (bCharExists) {
                countRepeatedCharacter++;
                int countUniqueCharacters = arrPwd.length - countRepeatedCharacter;
                incrementDeductionOfRepeatedChars = countUniqueCharacters != 0 ?
                        Math.ceil(incrementDeductionOfRepeatedChars / countUniqueCharacters) :
                        Math.ceil(incrementDeductionOfRepeatedChars);
            }
        }
    }

    public void calculateBonusOfRepeatedCharacters() {
        if (countRepeatedCharacter > 0) {
            bonusRepeatedCharacter = (int) incrementDeductionOfRepeatedChars;
        }
    }

    public void calculateRequirementLevel() {
        if (countRepeatedCharacter > 0) {
            reqLevel = RequirementLevel.WARNING;
        } else {
            reqLevel = RequirementLevel.SUFFICIENT;
        }
    }

    @Override
    int getCount() {
        return countRepeatedCharacter;
    }

    @Override
    int getBonus() {
        return bonusRepeatedCharacter;
    }

    @Override
    RequirementLevel getRequirementLevel() {
        return reqLevel;
    }

    @Override
    OperationType getOperationType() {
        return OperationType.DEDUCTIONS;
    }
}
