package passwordMeter;

public class PasswordMeterV3 {
    String password;
    int score;

    public PasswordMeterV3(String password) {
        this.password = password;
    }

    int calculateScore() {
        return score;
    }

    String calculateComplexityLevel(String password) {
     return "Too Short";
    }
}

class UppercaseLetters {}
class LowercaseLetters {}
class Numbers {}
class Symbols {}
class MiddleNumbersOrSymbols {}
class Requirements {}

// deductions
class LettersOnly {}
class NumbersOnly {}
class RepeatCharacters {}
class ConsecutiveUppercaseLetters {}
class ConsecutiveLowercaseLetters {}
class ConsecutiveNumbers {}
class SequentialLetters {}
class SequentialNumbers {}
class SequentialSymbols {}



