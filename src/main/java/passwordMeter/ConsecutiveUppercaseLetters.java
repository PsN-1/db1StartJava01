package passwordMeter;

public class ConsecutiveUppercaseLetters extends RequirementProperty {
    private RequirementLevel reqLevel;
    private int countConsecutiveUppercaseLetters, bonusConsecutiveUppercaseLetters;
    private Integer nTmpAlphaUC = null;

    public ConsecutiveUppercaseLetters(String password) {
        super(password);
        calculateCountOfConsecutiveUpperCaseLetters(password);
        calculatecalculateBonusOfConsecutiveUpperCaseLetters();
        calculateRequirementLevel();
    }

    public void calculateCountOfConsecutiveUpperCaseLetters(String password) {
        String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[A-Z]")) {
                if (nTmpAlphaUC != null) {
                    if (nTmpAlphaUC + 1 == i) {
                        countConsecutiveUppercaseLetters++;
                    }
                }
                nTmpAlphaUC = i;
            }
        }
    }

    public void calculatecalculateBonusOfConsecutiveUpperCaseLetters() {
        if (countConsecutiveUppercaseLetters > 0) {
            int multiplierConsecutiveAlphaUC = 2;
            bonusConsecutiveUppercaseLetters = countConsecutiveUppercaseLetters * multiplierConsecutiveAlphaUC;
        }
    }

    public void calculateRequirementLevel() {
        if (countConsecutiveUppercaseLetters > 0) {
            reqLevel = RequirementLevel.WARNING;
        } else {
            reqLevel = RequirementLevel.SUFFICIENT;
        }
    }

    @Override
    int getCount() {
        return countConsecutiveUppercaseLetters;
    }

    @Override
    int getBonus() {
        return bonusConsecutiveUppercaseLetters;
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
