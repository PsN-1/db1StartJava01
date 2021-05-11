package passwordMeter.Additions;

import passwordMeter.Enums.RequirementLevel;
import passwordMeter.RequirementProperty;

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
    public int getCount() {
        return countAlphaUpperCase;
    }

    @Override
    public int getBonus() {
        return bonusAlphaUpperCase;
    }

    @Override
    public RequirementLevel getRequirementLevel() {
        return reqLevel;
    }
}
