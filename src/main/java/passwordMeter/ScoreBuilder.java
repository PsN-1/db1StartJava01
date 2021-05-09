package passwordMeter;

import java.util.HashMap;
import java.util.Map;

public interface ScoreBuilder {

    default Map<String, Integer> getValuesToCalculateScore(String password) {
        Map<String, Integer> results = new HashMap<>();

        results.put("countLength", new NumberOfCharacters(password).getCount());
        results.put("countAlphaUpperCase", new UppercaseLetters(password).getCount());
        results.put("countAlphaLowerCase", new LowercaseLetters(password).getCount());
        results.put("countNumber", new Numbers(password).getCount());
        results.put("countSymbol", new Symbols(password).getCount());
        results.put("countMiddleCharacter", new MiddleNumbersOrSymbols(password).getCount());
        results.put("countRepeatedCharacter", new RepeatCharacters(password).getCount());
        results.put("countConsecutiveUppercaseLetter", new ConsecutiveUppercaseLetters(password).getCount());
        results.put("countConsecutiveLowercaseLetter", new ConsecutiveLowercaseLetters(password).getCount());
        results.put("countConsecutiveNumber", new ConsecutiveNumbers(password).getCount());
        results.put("countSequentialLetters", new SequentialLetters(password).getCount());
        results.put("countSequentialNumbers", new SequentialNumbers(password).getCount());
        results.put("countSequentialSymbols", new SequentialSymbols(password).getCount());
        results.put("countRequirements", new Requirements(password).getCount());

        results.put("bonusRepeatedCharacter", new RepeatCharacters(password).getBonus());






        return results;
    }
}

