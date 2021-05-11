package passwordMeter.Deductions;

import passwordMeter.Enums.RequirementLevel;
import passwordMeter.RequirementProperty;

public class SequentialNumbers extends RequirementProperty {
    private RequirementLevel reqLevel;
    private int countOfSequentialNumbers, bonusOfSequentialNumbers;

    public SequentialNumbers(String password) {
        super(password);
        calculateCountOfSequentialNumbers(password);
        calculateBonusOfSequentialNumbers();
        calculateRequirementLevel();
    }

    public void calculateCountOfSequentialNumbers(String password) {
        for (int i = 0; i < 8; i++) {
            String DIGITS = "01234567890";
            String sFwd = DIGITS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (password.toLowerCase().contains(sFwd) || password.toLowerCase().contains(sRev)) {
                countOfSequentialNumbers++;
            }
        }
    }

    public void calculateBonusOfSequentialNumbers() {
        if (countOfSequentialNumbers > 0) {
            int multiplierSeqNumber = 3;
            bonusOfSequentialNumbers = countOfSequentialNumbers * multiplierSeqNumber;
        }
    }

    public void calculateRequirementLevel() {
        if (countOfSequentialNumbers > 0) {
            reqLevel = RequirementLevel.WARNING;
        } else {
            reqLevel = RequirementLevel.SUFFICIENT;
        }
    }

    @Override
    public int getCount() {
        return countOfSequentialNumbers;
    }

    @Override
    public int getBonus() {
        return bonusOfSequentialNumbers;
    }

    @Override
    public RequirementLevel getRequirementLevel() {
        return reqLevel;
    }
}
