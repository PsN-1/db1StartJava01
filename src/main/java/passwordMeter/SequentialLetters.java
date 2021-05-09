package passwordMeter;

public class SequentialLetters extends  RequirementProperty{
    private RequirementLevel reqLevel;
    private int countOfSequentialLetters, bonusOfSequentialLetters;

    public SequentialLetters(String password) {
        super(password);
        calculateCountOfSequentialLetters(password);
        calculateBonusOfSequentialLetters();
        calculateRequirementLevel();
    }

    public void calculateCountOfSequentialLetters(String password) {
        for (int i = 0; i < 23; i++) {
            String ALPHAS = "abcdefghijklmnopqrstuvwxyz";
            String sFwd = ALPHAS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (password.toLowerCase().contains(sFwd) || password.toLowerCase().contains(sRev)) {
                countOfSequentialLetters++;
            }
        }
    }

    public void calculateBonusOfSequentialLetters() {
        if (countOfSequentialLetters > 0) {
            int multiplierSeqAlpha = 3;
            bonusOfSequentialLetters = countOfSequentialLetters * multiplierSeqAlpha;
        }
    }

    public void calculateRequirementLevel() {
        if (countOfSequentialLetters > 0) {
            reqLevel = RequirementLevel.WARNING;
        } else {
            reqLevel = RequirementLevel.SUFFICIENT;
        }
    }

    @Override
    int getCount() {
        return countOfSequentialLetters;
    }

    @Override
    int getBonus() {
        return bonusOfSequentialLetters;
    }

    @Override
    RequirementLevel getRequirementLevel() {
        return reqLevel;
    }

    @Override
    OperationType getOperationType() {
        return OperationType.DEDUCTIONS;
    }
}
