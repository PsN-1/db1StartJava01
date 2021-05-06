package passwordMeter;

public class PasswordMeterV3 {
    String password;
    int score;

    public PasswordMeterV3(String password) {
        this.password = password;
    }

    int calculateScore() { return score; }
}

abstract class RequirementProperties {
    String requirementsLevel;
    String typeRate;
    String rate;

    abstract int calculateCount(String password);
    abstract int calculateBonus(String password);
}

// additions
class NumberOfCharacters extends RequirementProperties{

    @Override
    public int calculateCount(String password) {
        return password.length();
    }

    @Override
    public int calculateBonus(String password) {
        int multiplierLength = 4;
        return password.length() * multiplierLength;
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



