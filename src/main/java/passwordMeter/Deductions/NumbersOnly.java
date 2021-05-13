package passwordMeter.Deductions;

import passwordMeter.Builders.DeductionVariablesBuilder;
import passwordMeter.Enums.RequirementLevel;
import passwordMeter.RequirementProperty;

import java.util.Map;

public class NumbersOnly extends RequirementProperty {
    private RequirementLevel reqLevel;
    private int countOfNumbersOnly, bonusOfNumbersOnly;

    public NumbersOnly(String password) {
        super(password);
        calculateCountOfNumbersOnly(password);
        calculateBonusOfNumbersOnly();
        calculateRequirementLevel();
    }

    public void calculateCountOfNumbersOnly(String password){
        Map<String, Integer> resultsArr;
        var deductionBuilder = new DeductionVariablesBuilder();
        resultsArr = deductionBuilder.getAllValuesFromDeductionBuilder(password);
        if( resultsArr.get("countAlphaLowerCase") == 0 && resultsArr.get("countAlphaUpperCase") == 0 && resultsArr.get("countSymbol") == 0 && resultsArr.get("countNumber") > 0) {
            countOfNumbersOnly = resultsArr.get("countLength");
        }
    }

    public void calculateBonusOfNumbersOnly() {
        bonusOfNumbersOnly = countOfNumbersOnly;
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
