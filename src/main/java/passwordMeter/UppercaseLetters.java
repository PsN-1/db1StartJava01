package passwordMeter;

public class UppercaseLetters extends RequirementProperty {
    private RequirementLevel reqLevel;
    private int countAlphaUpperCase, bonusAlphaUpperCase;
    private int countLength = password.length();
    private int score;

    public UppercaseLetters(String password) {
        super(password);
        calculateCountOfConsecutiveUpperCaseLetter(password);
        calculateBonusLetterUpperCase();
        calculateRequirementLevel();
    }

    public void calculateCountOfConsecutiveUpperCaseLetter(String password) {
        Integer nTmpAlphaUC = null;
        String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[A-Z]")) {
                countAlphaUpperCase++;
            }
        }
    }

    public void calculateBonusLetterUpperCase() {
        if (countAlphaUpperCase > 0 && countAlphaUpperCase < countLength) {
            score = score + (countLength - countAlphaUpperCase) * 2;
            bonusAlphaUpperCase = (countLength - countAlphaUpperCase) * 2;
        }
    }

    public void calculateRequirementLevel() {
        System.out.println(countAlphaUpperCase);
        if (countAlphaUpperCase <= 0 ) {
            reqLevel = RequirementLevel.FAILURE;
        } else if (countAlphaUpperCase == 1) {
            reqLevel = RequirementLevel.SUFFICIENT;
        } else {
            reqLevel = RequirementLevel.EXCEPTIONAL;
        }
    }


    @Override
    int getCount() {
        return countAlphaUpperCase;
    }

    @Override
    int getBonus() {
        return bonusAlphaUpperCase;
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
