package passwordMeter.Deductions;

import passwordMeter.Builders.DeductionVariablesBuilder;
import passwordMeter.Enums.RequirementLevel;
import passwordMeter.RequirementProperty;

import java.util.Map;

public class LettersOnly extends RequirementProperty {
    private RequirementLevel reqLevel;
    private int countLettersOnly, bonusLettersOnly;

    public LettersOnly(String password) {
        super(password);
        calculateCountOfLettersOnly(password);
        calculateBonusOfLettersOnly();
        calculateRequirementLevel();
    }

    public void calculateCountOfLettersOnly(String password) {
        Map<String, Integer> resultsArr;
        var deductionBuilder = new DeductionVariablesBuilder();
        resultsArr = deductionBuilder.getAllValuesFromDeductionBuilder(password);
        if ((resultsArr.get("countAlphaLowerCase") > 0 || resultsArr.get("countAlphaUpperCase") > 0) && resultsArr.get("countSymbol") == 0 && resultsArr.get("countNumber") == 0) {
            countLettersOnly = resultsArr.get("countLength");
        }
    }

    public void calculateBonusOfLettersOnly() {
        bonusLettersOnly = countLettersOnly;
    }

    public void calculateRequirementLevel() {
        if (countLettersOnly > 0) {
            reqLevel = RequirementLevel.WARNING;
        } else {
            reqLevel = RequirementLevel.SUFFICIENT;
        }
    }

    @Override
    public int getCount() {
        return countLettersOnly;
    }

    @Override
    public int getBonus() {
        return bonusLettersOnly;
    }

    @Override
    public RequirementLevel getRequirementLevel() {
        return reqLevel;
    }
}
