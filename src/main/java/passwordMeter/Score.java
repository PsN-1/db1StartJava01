package passwordMeter;

import java.util.Map;

public class Score implements ScoreBuilder{
    String password;

    private final int countLength;
    private final int countAlphaUC;
    private final int countAlphaLC;
    private final int countNumber;
    private final int countSymbol;
    private final int countMidChar;
    private final int countRepChar, bonusRepChar;
    private final int countConsecutiveAlphaUC;
    private final int countConsecutiveAlphaLC;
    private final int countConsecutiveNumber;
    private final int countSeqAlpha;
    private final int countSeqNumber;
    private final int countSeqSymbol;
    private final int countRequirements;

    public Score(String password) {
        this.password = password;

        Map<String, Integer> resultsCountArray;
        resultsCountArray = getValuesToCalculateScore(password);

        countLength = resultsCountArray.get("countLength");
        countAlphaUC = resultsCountArray.get("countAlphaUpperCase");
        countAlphaLC = resultsCountArray.get("countAlphaLowerCase");
        countNumber = resultsCountArray.get("countNumber");
        countSymbol = resultsCountArray.get("countSymbol");
        countMidChar = resultsCountArray.get("countMiddleCharacter");
        countRepChar = resultsCountArray.get("countRepeatedCharacter");
        countConsecutiveAlphaUC = resultsCountArray.get("countConsecutiveUppercaseLetter");
        countConsecutiveAlphaLC = resultsCountArray.get("countConsecutiveLowercaseLetter");
        countConsecutiveNumber = resultsCountArray.get("countConsecutiveNumber");
        countSeqAlpha = resultsCountArray.get("countSequentialLetters");
        countSeqNumber = resultsCountArray.get("countSequentialNumbers");
        countSeqSymbol = resultsCountArray.get("countSequentialSymbols");
        countRequirements = resultsCountArray.get("countRequirements");

        bonusRepChar = resultsCountArray.get("countSymbol");

        calculateScore();
    }

    public int calculateScore() {
        int multiplierLength = 4;
        int score = countLength * multiplierLength;

        if (countAlphaUC > 0 && countAlphaUC < countLength) {
            score = score + (countLength - countAlphaUC) * 2;
        }
        if (countAlphaLC > 0 && countAlphaLC < countLength) {
            score = score + (countLength - countAlphaLC) * 2;
        }
        if (countNumber > 0 && countNumber < countLength) {
            int multiplierNumber = 4;
            score = score + countNumber * multiplierNumber;
        }
        if (countSymbol > 0) {
            int multiplierSymbol = 6;
            score = score + countSymbol * multiplierSymbol;
        }
        if (countMidChar > 0) {
            int multiplierMidChar = 2;
            score = score + countMidChar * multiplierMidChar;
        }
        if ((countAlphaLC > 0 || countAlphaUC > 0) && countSymbol == 0 && countNumber == 0) {
            score = score - countLength;
        }
        if (countAlphaLC == 0 && countAlphaUC == 0 && countSymbol == 0 && countNumber > 0) {
            score = score - countLength;
        }
        if (countRepChar > 0) {
            score = score - bonusRepChar;
        }
        if (countConsecutiveAlphaUC > 0) {
            int multiplierConsecutiveAlphaUC = 2;
            score = score - countConsecutiveAlphaUC * multiplierConsecutiveAlphaUC;
        }
        if (countConsecutiveAlphaLC > 0) {
            int multiplierConsecutiveAlphaLC = 2;
            score = score - countConsecutiveAlphaLC * multiplierConsecutiveAlphaLC;
        }
        if (countConsecutiveNumber > 0) {
            int multiplierConsecutiveNumber = 2;
            score = score - countConsecutiveNumber * multiplierConsecutiveNumber;
        }
        if (countSeqAlpha > 0) {
            int multiplierSeqAlpha = 3;
            score = score - countSeqAlpha * multiplierSeqAlpha;
        }
        if (countSeqNumber > 0) {
            int multiplierSeqNumber = 3;
            score = score - countSeqNumber * multiplierSeqNumber;
        }
        if (countSeqSymbol > 0) {
            int multiplierSeqSymbol = 3;
            score = score - countSeqSymbol * multiplierSeqSymbol;
        }

        int MINIMUM_LENGTH = 8;
        int nMinReqChars = countLength >= MINIMUM_LENGTH ? 3 : 4;
        if (countRequirements > nMinReqChars) {
            score = score + countRequirements * 2;
        }
        return score;
    }
}
