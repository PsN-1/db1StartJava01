package passwordMeter;

public class PasswordMeterV3 {
    String password;
    String sComplexity;

    int score;
    int bonusLength, countLength;
    int bonusAlphaUpperCase, countAlphaUpperCase;
    int bonusAlphaLowerCase, countAlphaLowerCase;
    int bonusNumber, countNumber;
    int bonusSymbol, countSymbol;
    int bonusMidChar, countMidChar;
    int bonusRequirements, countRequirements;

    int bonusAlphasOnly, countAlphasOnly;
    int countNumbersOnly, bonusNumbersOnly;
    int countRepChar, bonusRepChar;
    int countConsecutiveAlphaUC, bonusConsecutiveAlphaUC;
    int countConsecutiveAlphaLC, bonusConsecutiveAlphaLC;
    int countConsecutiveNumber, bonusConsecutiveNumber;
    int countSeqAlpha, bonusSeqAlpha;
    int countSeqNumber, bonusSeqNumber;
    int countSeqSymbol, bonusSeqSymbol;

    public PasswordMeterV3(String password) {
        this.password = password;

        // Additions
        countLength = new NumberOfCharacters(password).getCount();
        bonusLength = new NumberOfCharacters(password).getBonus();

        countAlphaUpperCase = new UppercaseLetters(password).getCount();
        bonusAlphaUpperCase = new UppercaseLetters(password).getBonus();

        countAlphaLowerCase = new LowercaseLetters(password).getCount();
        bonusAlphaLowerCase = new LowercaseLetters(password).getBonus();

        countNumber = new Numbers(password).getCount();
        bonusNumber = new Numbers(password).getBonus();

        countSymbol = new Symbols(password).getCount();
        bonusSymbol = new Symbols(password).getBonus();

        countMidChar = new MiddleNumbersOrSymbols(password).getCount();
        bonusMidChar = new MiddleNumbersOrSymbols(password).getBonus();

        countRequirements = new Requirements(password).getCount();
        bonusRequirements = new Requirements(password).getBonus();

        // Deductions
        countAlphasOnly = new LettersOnly(password).getCount();
        bonusAlphasOnly = new LettersOnly(password).getBonus();

        countNumbersOnly = new NumbersOnly(password).getCount();
        bonusNumbersOnly = new NumbersOnly(password).getBonus();

        countRepChar = new RepeatCharacters(password).getCount();
        bonusRepChar = new RepeatCharacters(password).getBonus();

        countConsecutiveAlphaUC = new ConsecutiveUppercaseLetters(password).getCount();
        bonusConsecutiveAlphaUC = new ConsecutiveUppercaseLetters(password).getBonus();

        countConsecutiveAlphaLC = new ConsecutiveLowercaseLetters(password).getCount();
        bonusConsecutiveAlphaLC = new ConsecutiveLowercaseLetters(password).getBonus();

        countConsecutiveNumber = new ConsecutiveNumbers(password).getCount();
        bonusConsecutiveNumber = new ConsecutiveNumbers(password).getBonus();

        countSeqAlpha = new SequentialLetters(password).getCount();
        bonusSeqAlpha = new SequentialLetters(password).getBonus();

        countSeqNumber = new SequentialNumbers(password).getCount();
        bonusSeqNumber = new SequentialNumbers(password).getBonus();

        countSeqSymbol = new SequentialSymbols(password).getCount();
        bonusSeqSymbol = new SequentialSymbols(password).getBonus();

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

