package passwordMeter;

public class PasswordMeterV3 {
    String password;
    int score;

    public PasswordMeterV3(String password) {
        this.password = password;
    }

    public static void main(String[] args){
        var test = new NumberOfCharacters("12345");
        var test2 = test.getCount();
    }

    int calculateScore() {
        return score;
    }

    String calculateComplexityLevel(String password) {
     return "Too Short";
    }
}

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


