package passwordMeter.Deductions;

import passwordMeter.Builders.DeductionBuilder;
import passwordMeter.Enums.RequirementLevel;
import passwordMeter.RequirementProperty;

import java.util.Map;

public class NumbersOnly extends RequirementProperty {
    private RequirementLevel reqLevel;
    private int countOfNumbersOnly, bonusOfNumbersOnly;

    public NumbersOnly(String password) {
        super(password);
        calculateCountAndBonusOfNumbersOnly(password);
        calculateRequirementLevel();
    }

    public void calculateCountAndBonusOfNumbersOnly(String password){
        Map<String, Integer> resultsArr;
        var deductionBuilder = new DeductionBuilder();
        resultsArr = deductionBuilder.getAllValuesFromDeductionBuilder(password);
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
    public int getCount() {
        return countOfNumbersOnly;
    }

    @Override
    public int getBonus() {
        return bonusOfNumbersOnly;
    }

    @Override
    public RequirementLevel getRequirementLevel() {
        return reqLevel;
    }
}
