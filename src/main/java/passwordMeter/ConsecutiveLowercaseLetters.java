package passwordMeter;

public class ConsecutiveLowercaseLetters extends  RequirementProperty{
    private RequirementLevel reqLevel;
    private int countConsecutiveLowercaseLetters, bonusConsecutiveLowercaseLetters;
    private Integer nTmpAlphaLC = null;

    public ConsecutiveLowercaseLetters(String password) {
        super(password);
        calculateCountOfConsecutiveLowerCaseLetters(password);
        calculateBonusOfConsecutiveLowerCaseLetters();
        calculateRequirementLevel();
    }

    public void calculateCountOfConsecutiveLowerCaseLetters(String password) {
        String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[a-z]")) {
                if (nTmpAlphaLC != null) {
                    if (nTmpAlphaLC + 1 == i) {
                        countConsecutiveLowercaseLetters++;
                    }
                }
                nTmpAlphaLC = i;
            }
        }
    }

    public void calculateBonusOfConsecutiveLowerCaseLetters() {
        if (countConsecutiveLowercaseLetters > 0) {
            int multiplierConsecutiveAlphaUC = 2;
            bonusConsecutiveLowercaseLetters = countConsecutiveLowercaseLetters * multiplierConsecutiveAlphaUC;
        }
    }

    public void calculateRequirementLevel() {
        if (countConsecutiveLowercaseLetters > 0) {
            reqLevel = RequirementLevel.WARNING;
        } else {
            reqLevel = RequirementLevel.SUFFICIENT;
        }
    }

    @Override
    int getCount() {
        return countConsecutiveLowercaseLetters;
    }

    @Override
    int getBonus() {
        return bonusConsecutiveLowercaseLetters;
    }

    @Override
    RequirementLevel getRequirementLevel() {
        return reqLevel;
    }

}
