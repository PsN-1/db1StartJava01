package passwordMeter;

public class Numbers extends RequirementProperty {
    private RequirementLevel reqLevel;
    private int countLength = password.length();
    private int countNumber, bonusNumber;

    public Numbers(String password) {
        super(password);
        calculateCountOfNumbers(password);
        calculateBonusNumber(password);
        calculateRequirementLevel();
    }

    public void calculateCountOfNumbers(String password) {
        String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");
        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[0-9]")) {
                countNumber++;
            }
        }
    }

    public void calculateBonusNumber(String password) {
        if (countNumber > 0 && countNumber < countLength) {
            int multiplierNumber = 4;
//            score = score + countNumber * multiplierNumber;
            bonusNumber = countNumber * multiplierNumber;
        }
    }

    public void calculateRequirementLevel() {
        if (countNumber <= 0 ) {
            reqLevel = RequirementLevel.FAILURE;
        } else if (countNumber == 1) {
            reqLevel = RequirementLevel.SUFFICIENT;
        } else {
            reqLevel = RequirementLevel.EXCEPTIONAL;
        }
    }

    @Override
    int getCount() {
        return countNumber;
    }

    @Override
    int getBonus() {
        return bonusNumber;
    }

    @Override
    RequirementLevel getRequirementLevel() {
        return reqLevel;
    }

    @Override
    OperationType getOperationType() {
        return OperationType.ADDITTIONS;
    }
}
