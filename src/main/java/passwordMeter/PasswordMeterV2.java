package passwordMeter;

import java.util.Map;

public class PasswordMeterV2 implements scoreBuilder {
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

        // Additions
        Map<String, Integer> resultsCountArray;
        resultsCountArray = getAllVariables(password);

        countLength = resultsCountArray.get("countLength");
        bonusLength = resultsCountArray.get("bonusLength");

        countAlphaUpperCase = resultsCountArray.get("countAlphaUpperCase");
        bonusAlphaUpperCase = resultsCountArray.get("bonusAlphaUpperCase");

        countAlphaLowerCase = resultsCountArray.get("countAlphaLowerCase");
        bonusAlphaLowerCase = resultsCountArray.get("bonusAlphaLowerCase");

        countNumber = resultsCountArray.get("countNumber");
        bonusNumber = resultsCountArray.get("bonusNumber");

        countSymbol = resultsCountArray.get("countSymbol");
        bonusSymbol = resultsCountArray.get("bonusSymbol");

        countMidChar = resultsCountArray.get("countMiddleCharacter");
        bonusMidChar = resultsCountArray.get("bonusMiddleCharacter");

        countRequirements = resultsCountArray.get("countRequirements");
        bonusRequirements = resultsCountArray.get("bonusRequirements");

        // Deductions
        countAlphasOnly = resultsCountArray.get("countLettersOnly");
        bonusAlphasOnly = resultsCountArray.get("bonusLettersOnly");

        countNumbersOnly = resultsCountArray.get("countOfNumbersOnly");
        bonusNumbersOnly = resultsCountArray.get("bonusOfNumbersOnly");

        countRepChar = resultsCountArray.get("countRepeatedCharacter");
        bonusRepChar = resultsCountArray.get("bonusRepeatedCharacter");

        countConsecutiveAlphaUC = resultsCountArray.get("countConsecutiveUppercaseLetter");
        bonusConsecutiveAlphaUC = resultsCountArray.get("bonusConsecutiveUppercaseLetter");

        countConsecutiveAlphaLC = resultsCountArray.get("countConsecutiveLowercaseLetter");
        bonusConsecutiveAlphaLC = resultsCountArray.get("bonusConsecutiveLowercaseLetter");

        countConsecutiveNumber = resultsCountArray.get("countConsecutiveNumber");
        bonusConsecutiveNumber = resultsCountArray.get("bonusConsecutiveNumber");

        countSeqAlpha = resultsCountArray.get("countSequentialLetters");
        bonusSeqAlpha = resultsCountArray.get("bonusSequentialLetters");

        countSeqNumber = resultsCountArray.get("countSequentialNumbers");
        bonusSeqNumber = resultsCountArray.get("bonusSequentialNumbers");

        countSeqSymbol = resultsCountArray.get("countSequentialSymbols");
        bonusSeqSymbol = resultsCountArray.get("bonusSequentialSymbols");

        score = new Score(password).calculateScore();
        sComplexity = new Complexity(score).calculatePasswordComplexity();
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
