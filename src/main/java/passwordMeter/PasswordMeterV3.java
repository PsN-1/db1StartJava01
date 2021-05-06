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

abstract class RequirementProperties {
    String requirementLevel;
    String typeRate;
    String rate;

    abstract int calculateCount(String password);
    abstract int calculateBonus(String password);
    abstract String calculateRequirementLevel(String password);


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

    @Override
    String calculateRequirementLevel(String password) {
        int minimumValue = 8;
        int passwordLength = password.length();

        if (passwordLength == minimumValue) {
            requirementLevel = "sufficient";
        } else if (passwordLength > minimumValue) {
            requirementLevel = "exceptional";
        } else {
            requirementLevel = "failure";
        }
        return requirementLevel;
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



