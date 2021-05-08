package passwordMeter;

import java.util.HashMap;
import java.util.Map;

public class LettersOnly extends RequirementProperty implements DeductionBuilder{
    private RequirementLevel reqLevel;
    private int countLettersOnly, bonusLettersOnly;

    public LettersOnly(String password) {
        super(password);
        calculateCountAndBonusOfLettersOnly(password);
        calculateRequirementLevel();
    }

    public void calculateCountAndBonusOfLettersOnly(String password) {
        Map<String, Integer> resultsArr = new HashMap<String, Integer>();
        resultsArr = getAllValues(password);
        if ((resultsArr.get("countAlphaLowerCase") > 0 || resultsArr.get("countAlphaUpperCase") > 0) && resultsArr.get("countSymbol") == 0 && resultsArr.get("countNumber") == 0) {
            countLettersOnly = resultsArr.get("countLength");
            bonusLettersOnly = resultsArr.get("countLength");
        }
    }

    public void calculateRequirementLevel() {
        if (countLettersOnly > 0) {
            reqLevel = RequirementLevel.WARNING;
        } else {
            reqLevel = RequirementLevel.SUFFICIENT;
        }
    }

    @Override
    int getCount() {
        return countLettersOnly;
    }

    @Override
    int getBonus() {
        return bonusLettersOnly;
    }

    @Override
    RequirementLevel getRequirementLevel() {
        return null;
    }

    @Override
    OperationType getOperationType() {
        return OperationType.DEDUCTIONS;
    }
}
