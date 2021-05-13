package passwordMeter;

import passwordMeter.Builders.PasswordMeterVariablesBuilder;

import java.util.Map;

public class PasswordMeterV2 {
    private final String password;
    private final String sComplexity;

    private final int score;
    private final int bonusLength, countLength;
    private final int bonusAlphaUpperCase, countAlphaUpperCase;
    private final int bonusAlphaLowerCase, countAlphaLowerCase;
    private final int bonusNumber, countNumber;
    private final int bonusSymbol, countSymbol;
    private final int bonusMidChar, countMidChar;
    private final int bonusRequirements, countRequirements;

    private final int bonusAlphasOnly, countAlphasOnly;
    private final int countNumbersOnly, bonusNumbersOnly;
    private final int countRepChar, bonusRepChar;
    private final int countConsecutiveAlphaUC, bonusConsecutiveAlphaUC;
    private final int countConsecutiveAlphaLC, bonusConsecutiveAlphaLC;
    private final int countConsecutiveNumber, bonusConsecutiveNumber;
    private final int countSeqAlpha, bonusSeqAlpha;
    private final int countSeqNumber, bonusSeqNumber;
    private final int countSeqSymbol, bonusSeqSymbol;

    public PasswordMeterV2(String password) {
        this.password = password;

        Map<String, Integer> resultsCountAndBonusArray;
        var scoreBuilder = new PasswordMeterVariablesBuilder();
        resultsCountAndBonusArray = scoreBuilder.getAllVariables(password);

        // Additions
        countLength = resultsCountAndBonusArray.get("countLength");
        bonusLength = resultsCountAndBonusArray.get("bonusLength");

        countAlphaUpperCase = resultsCountAndBonusArray.get("countAlphaUpperCase");
        bonusAlphaUpperCase = resultsCountAndBonusArray.get("bonusAlphaUpperCase");

        countAlphaLowerCase = resultsCountAndBonusArray.get("countAlphaLowerCase");
        bonusAlphaLowerCase = resultsCountAndBonusArray.get("bonusAlphaLowerCase");

        countNumber = resultsCountAndBonusArray.get("countNumber");
        bonusNumber = resultsCountAndBonusArray.get("bonusNumber");

        countSymbol = resultsCountAndBonusArray.get("countSymbol");
        bonusSymbol = resultsCountAndBonusArray.get("bonusSymbol");

        countMidChar = resultsCountAndBonusArray.get("countMiddleCharacter");
        bonusMidChar = resultsCountAndBonusArray.get("bonusMiddleCharacter");

        countRequirements = resultsCountAndBonusArray.get("countRequirements");
        bonusRequirements = resultsCountAndBonusArray.get("bonusRequirements");

        // Deductions
        countAlphasOnly = resultsCountAndBonusArray.get("countLettersOnly");
        bonusAlphasOnly = resultsCountAndBonusArray.get("bonusLettersOnly");

        countNumbersOnly = resultsCountAndBonusArray.get("countOfNumbersOnly");
        bonusNumbersOnly = resultsCountAndBonusArray.get("bonusOfNumbersOnly");

        countRepChar = resultsCountAndBonusArray.get("countRepeatedCharacter");
        bonusRepChar = resultsCountAndBonusArray.get("bonusRepeatedCharacter");

        countConsecutiveAlphaUC = resultsCountAndBonusArray.get("countConsecutiveUppercaseLetter");
        bonusConsecutiveAlphaUC = resultsCountAndBonusArray.get("bonusConsecutiveUppercaseLetter");

        countConsecutiveAlphaLC = resultsCountAndBonusArray.get("countConsecutiveLowercaseLetter");
        bonusConsecutiveAlphaLC = resultsCountAndBonusArray.get("bonusConsecutiveLowercaseLetter");

        countConsecutiveNumber = resultsCountAndBonusArray.get("countConsecutiveNumber");
        bonusConsecutiveNumber = resultsCountAndBonusArray.get("bonusConsecutiveNumber");

        countSeqAlpha = resultsCountAndBonusArray.get("countSequentialLetters");
        bonusSeqAlpha = resultsCountAndBonusArray.get("bonusSequentialLetters");

        countSeqNumber = resultsCountAndBonusArray.get("countSequentialNumbers");
        bonusSeqNumber = resultsCountAndBonusArray.get("bonusSequentialNumbers");

        countSeqSymbol = resultsCountAndBonusArray.get("countSequentialSymbols");
        bonusSeqSymbol = resultsCountAndBonusArray.get("bonusSequentialSymbols");

        score = new Score(password).getScore();
        sComplexity = new PasswordComplexity(score).calculatePasswordComplexity();
    }

    @Override
    public String toString() {
        return "Password: " + password
                + "\nScore: " + score + ""
                + "\nComplexity: " + sComplexity

                + "\nAddictions"
                + "\n[C: " + countLength + " | B: " + bonusLength + "] Number of Characters"
                + "\n[C: " + countAlphaUpperCase + " | B: " + bonusAlphaUpperCase + "] Uppercase Letters"
                + "\n[C: " + countAlphaLowerCase + " | B: " + bonusAlphaLowerCase + "] Lowercase Letters"
                + "\n[C: " + countNumber + " | B: " + bonusNumber + "] Numbers"
                + "\n[C: " + countSymbol + " | B: " + bonusSymbol + "] Symbols"
                + "\n[C: " + countMidChar + " | B: " + bonusMidChar + "] Middle Numbers or Symbols"
                + "\n[C: " + countRequirements + " | B: " + bonusRequirements + "] Requirements"

                + "\nDeductions"
                + "\n[C: " + countAlphasOnly + " | B: " + bonusAlphasOnly + "] Letters Only"
                + "\n[C: " + countNumbersOnly + " | B: " + bonusNumbersOnly + "] Numbers Only"
                + "\n[C: " + countRepChar + " | B: " + bonusRepChar + "] Repeat Characters (Case Insensitive)"
                + "\n[C: " + countConsecutiveAlphaUC + " | B: " + bonusConsecutiveAlphaUC + "] Consecutive Uppercase Letters"
                + "\n[C: " + countConsecutiveAlphaLC + " | B: " + bonusConsecutiveAlphaLC + "] Consecutive Lowercase Letters"
                + "\n[C: " + countConsecutiveNumber + " | B: " + bonusConsecutiveNumber + "] Consecutive Numbers"
                + "\n[C: " + countSeqAlpha + " | B: " + bonusSeqAlpha + "] Sequential Letters"
                + "\n[C: " + countSeqNumber + " | B: " + bonusSeqNumber + "] Sequential Numbers"
                + "\n[C: " + countSeqSymbol + " | B: " + bonusSeqSymbol + "] Sequential Symbols";
    }
}
