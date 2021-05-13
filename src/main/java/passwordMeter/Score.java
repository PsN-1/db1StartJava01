package passwordMeter;

import passwordMeter.Builders.PasswordMeterVariablesBuilder;

import java.util.Map;

public class Score {
    String password;
    private int score;

    public Score(String password) {
        this.password = password;

        Map<String, Integer> resultsCountAndBonusArray;
        var scoreBuilder = new PasswordMeterVariablesBuilder();
        resultsCountAndBonusArray = scoreBuilder.getAllVariables(password);

        int bonusLength = resultsCountAndBonusArray.get("bonusLength");
        int bonusAlphaUC = resultsCountAndBonusArray.get("bonusAlphaUpperCase");
        int bonusAlphaLC = resultsCountAndBonusArray.get("bonusAlphaLowerCase");
        int bonusNumber = resultsCountAndBonusArray.get("bonusNumber");
        int bonusSymbol = resultsCountAndBonusArray.get("bonusSymbol");
        int bonusMidChar = resultsCountAndBonusArray.get("bonusMiddleCharacter");
        int bonusRepChar = resultsCountAndBonusArray.get("bonusRepeatedCharacter");
        int bonusConsecutiveAlphaUC = resultsCountAndBonusArray.get("bonusConsecutiveUppercaseLetter");
        int bonusConsecutiveAlphaLC = resultsCountAndBonusArray.get("bonusConsecutiveLowercaseLetter");
        int bonusConsecutiveNumber = resultsCountAndBonusArray.get("bonusConsecutiveNumber");
        int bonusSeqAlpha = resultsCountAndBonusArray.get("bonusSequentialLetters");
        int bonusSeqNumber = resultsCountAndBonusArray.get("bonusSequentialNumbers");
        int bonusSeqSymbol = resultsCountAndBonusArray.get("bonusSequentialSymbols");
        int bonusRequirements = resultsCountAndBonusArray.get("bonusRequirements");
        int bonusLetterOnly = resultsCountAndBonusArray.get("bonusLettersOnly");
        int bonusOfNumbersOnly = resultsCountAndBonusArray.get("bonusOfNumbersOnly");

        score = bonusLength;
        score += bonusAlphaUC + bonusAlphaLC + bonusNumber + bonusSymbol + bonusMidChar + bonusRequirements;
        score += - bonusLetterOnly - bonusOfNumbersOnly - bonusRepChar - bonusConsecutiveAlphaUC;
        score += - bonusConsecutiveAlphaLC - bonusConsecutiveNumber - bonusSeqAlpha - bonusSeqNumber - bonusSeqSymbol;

        if (score > 100) {
            score = 100;
        } else if (score < 0 ) {
            score = 0;
        }
    }

    public int getScore() {
        return score;
    }
}
