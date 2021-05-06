package passwordMeter;

public class PasswordMeterV3 {
    public static void main(String[] args) {
        var first = new NumberOfCharacters();
        first.calculateCount();
        first.calculateBonus();
    }
}

abstract class RequirementProperties {
    String requirementsLevel;
    String type;
    int count, bonus;

    public int calculateCount() {
        return count;
    }
    public int calculateBonus() {
        return bonus;
    }
}

// additions
class NumberOfCharacters extends RequirementProperties{
    public String password;

    @Override
    public int calculateCount() {
        return password.length();
    }

    @Override
    public int calculateBonus() {
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



