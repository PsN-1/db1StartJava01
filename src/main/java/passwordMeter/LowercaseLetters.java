package passwordMeter;

public class LowercaseLetters extends RequirementProperty{
    private RequirementLevel reqLevel;
    private int countAlphaLowerCase, bonusAlphaLowerCase;
    private final int countLength = password.length();

    public LowercaseLetters(String password) {
        super(password);
        calculateCountOfLowerCaseLetter(password);
        calculateBonusLetterLowerCase();
        calculateRequirementLevel();
    }

    public void calculateCountOfLowerCaseLetter(String password) {
        String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");
        for (String s : arrPwd) {
            if (s.matches("[a-z]")) {
                countAlphaLowerCase++;
            }
        }
    }

    public void calculateBonusLetterLowerCase() {
        if (countAlphaLowerCase > 0 && countAlphaLowerCase < countLength) {
//            score = score + (countLength - countAlphaLowerCase) * 2;
            bonusAlphaLowerCase = (countLength - countAlphaLowerCase) * 2;
        }
    }

    public void calculateRequirementLevel() {
        if (countAlphaLowerCase <= 0 ) {
            reqLevel = RequirementLevel.FAILURE;
        } else if (countAlphaLowerCase == 1) {
            reqLevel = RequirementLevel.SUFFICIENT;
        } else {
            reqLevel = RequirementLevel.EXCEPTIONAL;
        }
    }

    @Override
    int getCount() {
        return countAlphaLowerCase;
    }

    @Override
    int getBonus() {
        return bonusAlphaLowerCase;
    }

    @Override
    RequirementLevel getRequirementLevel() {
        return reqLevel;
    }

    @Override
    OperationType getOperationType() {
        return OperationType.ADDITIONS;
    }
}

