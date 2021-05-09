package passwordMeter;

public class UppercaseLetters extends RequirementProperty {
    private RequirementLevel reqLevel;
    private int countAlphaUpperCase, bonusAlphaUpperCase;
    private final int countLength = password.length();

    public UppercaseLetters(String password) {
        super(password);
        calculateCountOfUpperCaseLetter(password);
        calculateBonusLetterUpperCase();
        calculateRequirementLevel();
    }

    public void calculateCountOfUpperCaseLetter(String password) {
        String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");

        for (String s : arrPwd) {
            if (s.matches("[A-Z]")) {
                countAlphaUpperCase++;
            }
        }
    }

    public void calculateBonusLetterUpperCase() {
        if (countAlphaUpperCase > 0 && countAlphaUpperCase < countLength) {
//            score = score + (countLength - countAlphaUpperCase) * 2;
            bonusAlphaUpperCase = (countLength - countAlphaUpperCase) * 2;
        }
    }

    public void calculateRequirementLevel() {
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
        return OperationType.ADDITIONS;
    }
}
