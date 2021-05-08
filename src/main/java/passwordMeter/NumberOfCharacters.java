package passwordMeter;

public class NumberOfCharacters extends RequirementProperty {
    private int count;
    private int bonus;
    private RequirementLevel reqLevel;

    public NumberOfCharacters(String password) {
        super(password);
        calculateResult(password);
        calculateRequirementLevel();
    }

    public void calculateResult(String password) {
        int multiplierLength = 4;
        count = password.length();
        bonus = count * multiplierLength;
    }

    void calculateRequirementLevel() {
        int minimumValue = 8;
        int passwordLength = password.length();

        if (passwordLength == minimumValue) {
            reqLevel = RequirementLevel.SUFFICIENT;
        } else if (passwordLength > minimumValue) {
            reqLevel = RequirementLevel.EXCEPTIONAL;
        } else {
            reqLevel = RequirementLevel.FAILURE;
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public int getBonus() {
        return bonus;
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
