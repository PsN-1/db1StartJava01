package passwordMeter;

public class ConsecutiveNumbers extends RequirementProperty{
    private RequirementLevel reqLevel;
    private int countConsecutiveNumber, bonusConsecutiveNumber;
    private Integer nTmpNumber = null;

    public ConsecutiveNumbers(String password) {
        super(password);
        calculateCountOfConsecutiveNumbers(password);
        calculateBonusOfConsecutiveNumbers();
        calculateRequirementLevel();
    }

    public void calculateCountOfConsecutiveNumbers(String password) {
        String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[0-9]")) {
                if (nTmpNumber != null) {
                    if (nTmpNumber + 1 == i) {
                        countConsecutiveNumber++;
                    }
                }
                nTmpNumber = i;
            }
        }
    }

    public void calculateBonusOfConsecutiveNumbers() {
        if (countConsecutiveNumber > 0) {
            int multiplierConsecutiveNumber = 2;
            bonusConsecutiveNumber = countConsecutiveNumber * multiplierConsecutiveNumber;
        }
    }

    public void calculateRequirementLevel() {
        if (countConsecutiveNumber > 0) {
            reqLevel = RequirementLevel.WARNING;
        } else {
            reqLevel = RequirementLevel.SUFFICIENT;
        }
    }

    @Override
    int getCount() {
        return countConsecutiveNumber;
    }

    @Override
    int getBonus() {
        return bonusConsecutiveNumber;
    }

    @Override
    RequirementLevel getRequirementLevel() {
        return reqLevel;
    }

}
