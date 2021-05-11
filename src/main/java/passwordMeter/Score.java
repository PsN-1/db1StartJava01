package passwordMeter;

import java.util.Map;

public class Score implements scoreBuilder {
    String password;
    private int score;

    public Score(String password) {
        this.password = password;

        Map<String, Integer> resultsCountArray;
        resultsCountArray = getAllVariables(password);

        int bonusLength = resultsCountArray.get("bonusLength");
        int bonusAlphaUC = resultsCountArray.get("bonusAlphaUpperCase");
        int bonusAlphaLC = resultsCountArray.get("bonusAlphaLowerCase");
        int bonusNumber = resultsCountArray.get("bonusNumber");
        int bonusSymbol = resultsCountArray.get("bonusSymbol");
        int bonusMidChar = resultsCountArray.get("bonusMiddleCharacter");
        int bonusRepChar = resultsCountArray.get("bonusRepeatedCharacter");
        int bonusConsecutiveAlphaUC = resultsCountArray.get("bonusConsecutiveUppercaseLetter");
        int bonusConsecutiveAlphaLC = resultsCountArray.get("bonusConsecutiveLowercaseLetter");
        int bonusConsecutiveNumber = resultsCountArray.get("bonusConsecutiveNumber");
        int bonusSeqAlpha = resultsCountArray.get("bonusSequentialLetters");
        int bonusSeqNumber = resultsCountArray.get("bonusSequentialNumbers");
        int bonusSeqSymbol = resultsCountArray.get("bonusSequentialSymbols");
        int bonusRequirements = resultsCountArray.get("bonusRequirements");
        int bonusLetterOnly = resultsCountArray.get("bonusLettersOnly");
        int bonusOfNumbersOnly = resultsCountArray.get("bonusOfNumbersOnly");

        score = bonusLength;
        score += bonusAlphaUC + bonusAlphaLC + bonusNumber + bonusSymbol + bonusMidChar + bonusRequirements;
        score += - bonusLetterOnly - bonusOfNumbersOnly - bonusRepChar - bonusConsecutiveAlphaUC - bonusConsecutiveAlphaLC - bonusConsecutiveNumber - bonusSeqAlpha - bonusSeqNumber - bonusSeqSymbol;

        if (score > 100) {
            score = 100;
        } else if (score < 0 ) {
            score = 0;
        }

        calculateScore();
    }

    public int calculateScore() {
        return score;
    }
}
