package passwordMeter;

public class Numbers extends RequirementProperty {
    private RequirementLevel reqLevel;
    private final int countLength = password.length();
    private int countNumber, bonusNumber;

    public Numbers(String password) {
        super(password);
        calculateCountOfNumbers(password);
        calculateBonusNumber();
        calculateRequirementLevel();
    }

    public void calculateCountOfNumbers(String password) {
        String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");
        for (String s : arrPwd) {
            if (s.matches("[0-9]")) {
                countNumber++;
            }
        }
    }

    public void calculateBonusNumber() {
        if (countNumber > 0 && countNumber < countLength) {
            int multiplierNumber = 4;
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
}
