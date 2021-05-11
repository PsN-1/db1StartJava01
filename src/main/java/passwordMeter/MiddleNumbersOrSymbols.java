package passwordMeter;

public class MiddleNumbersOrSymbols extends RequirementProperty{
    private RequirementLevel reqLevel;
    private int countMidChar, bonusMidChar;

    public MiddleNumbersOrSymbols(String password) {
        super(password);
        calculateCountOfMiddleCharacters(password);
        calculateBonusMiddleCharacters();
        calculateRequirementLevel();
    }

    public void calculateCountOfMiddleCharacters(String password) {
        String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {

            if ((arrPwd[i].matches("[0-9]")) || (arrPwd[i].matches("[^a-zA-Z0-9_]"))) {
                if (i > 0 && i < arrPwd.length - 1) {
                    countMidChar++;
                }
            }
        }
    }

    public void calculateBonusMiddleCharacters() {
        if (countMidChar > 0) {
            int multiplierMidChar = 2;
            bonusMidChar = countMidChar * multiplierMidChar;
        }
    }

    public void calculateRequirementLevel() {
        if (countMidChar <= 0 ) {
            reqLevel = RequirementLevel.FAILURE;
        } else if (countMidChar == 1) {
            reqLevel = RequirementLevel.SUFFICIENT;
        } else {
            reqLevel = RequirementLevel.EXCEPTIONAL;
        }
    }

    @Override
    int getCount() {
        return countMidChar;
    }

    @Override
    int getBonus() {
        return bonusMidChar;
    }

    @Override
    RequirementLevel getRequirementLevel() {
        return reqLevel;
    }
}
