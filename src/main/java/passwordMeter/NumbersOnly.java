package passwordMeter;

import java.util.Map;

public class NumbersOnly extends  RequirementProperty implements DeductionBuilder{
    private RequirementLevel reqLevel;
    private int countOfNumbersOnly, bonusOfNumbersOnly;

    public NumbersOnly(String password) {
        super(password);
        calculateCountAndBonusOfNumbersOnly(password);
        calculateRequirementLevel();
    }

    public void calculateCountAndBonusOfNumbersOnly(String password){
        Map<String, Integer> resultsArr;
        resultsArr = getAllValues2(password);
        if( resultsArr.get("countAlphaLowerCase") == 0 && resultsArr.get("countAlphaUpperCase") == 0 && resultsArr.get("countSymbol") == 0 && resultsArr.get("countNumber") > 0) {
            countOfNumbersOnly = resultsArr.get("countLength");
            bonusOfNumbersOnly = resultsArr.get("countLength");
        }
    }

    public void calculateRequirementLevel() {
        if (countOfNumbersOnly > 0) {
            reqLevel = RequirementLevel.WARNING;
        } else {
            reqLevel = RequirementLevel.SUFFICIENT;
        }
    }

    @Override
    int getCount() {
        return countOfNumbersOnly;
    }

    @Override
    int getBonus() {
        return bonusOfNumbersOnly;
    }

    @Override
    RequirementLevel getRequirementLevel() {
        return reqLevel;
    }
}
