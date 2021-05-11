package passwordMeter.Deductions;

import passwordMeter.Enums.RequirementLevel;
import passwordMeter.RequirementProperty;

public class SequentialSymbols extends RequirementProperty {
    private RequirementLevel reqLevel;
    private int countOfSequentialSymbols, bonusOfSequentialLettersSymbols;

    public SequentialSymbols(String password) {
        super(password);
        calculateCountOfSequentialSymbols(password);
        calculateBonusOfSequentialSymbols();
        calculateRequirementLevel();
    }

    public void calculateCountOfSequentialSymbols(String password) {
        for (int i = 0; i < 8; i++) {
            String SYMBOLS = ")!@#$%^&*()";
            String sFwd = SYMBOLS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (password.toLowerCase().contains(sFwd) || password.toLowerCase().contains(sRev)) {
                countOfSequentialSymbols++;
            }
        }
    }

    public void calculateBonusOfSequentialSymbols() {
        if (countOfSequentialSymbols > 0) {
            int multiplierSeqSymbol = 3;
            bonusOfSequentialLettersSymbols = countOfSequentialSymbols * multiplierSeqSymbol;
        }
    }

    public void calculateRequirementLevel() {
        if (countOfSequentialSymbols > 0) {
            reqLevel = RequirementLevel.WARNING;
        } else {
            reqLevel = RequirementLevel.SUFFICIENT;
        }
    }

    @Override
    public int getCount() {
        return countOfSequentialSymbols;
    }

    @Override
    public int getBonus() {
        return bonusOfSequentialLettersSymbols;
    }

    @Override
    public RequirementLevel getRequirementLevel() {
        return reqLevel;
    }
}
