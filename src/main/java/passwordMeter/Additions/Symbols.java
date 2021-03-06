package passwordMeter.Additions;

import passwordMeter.Enums.RequirementLevel;
import passwordMeter.RequirementProperty;

public class Symbols extends RequirementProperty {
    private RequirementLevel reqLevel;
    private  int countSymbol, bonusSymbol;

    public Symbols(String password) {
        super(password);
        calculateCountOfSymbols(password);
        calculateBonusSymbol();
        calculateRequirementLevel();
    }

    public void calculateCountOfSymbols(String password) {
        String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");

        for (String s : arrPwd) {
            if (s.matches("[^a-zA-Z0-9_]")) {
                countSymbol++;
            }
        }
    }

    public void calculateBonusSymbol() {
        if (countSymbol > 0) {
            int multiplierSymbol = 6;
            bonusSymbol = countSymbol * multiplierSymbol;
        }
    }

    public void calculateRequirementLevel() {
        if (countSymbol <= 0 ) {
            reqLevel = RequirementLevel.FAILURE;
        } else if (countSymbol == 1) {
            reqLevel = RequirementLevel.SUFFICIENT;
        } else {
            reqLevel = RequirementLevel.EXCEPTIONAL;
        }
    }

    @Override
    public int getCount() {
        return countSymbol;
    }

    @Override
    public int getBonus() {
        return bonusSymbol;
    }

    @Override
    public RequirementLevel getRequirementLevel() {
        return reqLevel;
    }
}
