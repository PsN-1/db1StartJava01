package passwordMeter.Builders;

import passwordMeter.Additions.*;
import passwordMeter.Deductions.*;

import java.util.HashMap;
import java.util.Map;

public class PasswordMeterVariablesBuilder {

    public Map<String, Integer> getAllVariables(String password) {
        Map<String, Integer> results = new HashMap<>();

        results.put("countLength", new NumberOfCharacters(password).getCount());
        results.put("countAlphaUpperCase", new UppercaseLetters(password).getCount());
        results.put("countAlphaLowerCase", new LowercaseLetters(password).getCount());
        results.put("countNumber", new Numbers(password).getCount());
        results.put("countSymbol", new Symbols(password).getCount());
        results.put("countMiddleCharacter", new MiddleNumbersOrSymbols(password).getCount());
        results.put("countLettersOnly", new LettersOnly(password).getCount());
        results.put("countOfNumbersOnly",new NumbersOnly(password).getCount());
        results.put("countRepeatedCharacter", new RepeatCharacters(password).getCount());
        results.put("countConsecutiveUppercaseLetter", new ConsecutiveUppercaseLetters(password).getCount());
        results.put("countConsecutiveLowercaseLetter", new ConsecutiveLowercaseLetters(password).getCount());
        results.put("countConsecutiveNumber", new ConsecutiveNumbers(password).getCount());
        results.put("countSequentialLetters", new SequentialLetters(password).getCount());
        results.put("countSequentialNumbers", new SequentialNumbers(password).getCount());
        results.put("countSequentialSymbols", new SequentialSymbols(password).getCount());
        results.put("countRequirements", new Requirements(password).getCount());

        results.put("bonusLength", new NumberOfCharacters(password).getBonus());
        results.put("bonusAlphaUpperCase", new UppercaseLetters(password).getBonus());
        results.put("bonusAlphaLowerCase", new LowercaseLetters(password).getBonus());
        results.put("bonusNumber", new Numbers(password).getBonus());
        results.put("bonusSymbol", new Symbols(password).getBonus());
        results.put("bonusMiddleCharacter", new MiddleNumbersOrSymbols(password).getBonus());
        results.put("bonusLettersOnly", new LettersOnly(password).getBonus());
        results.put("bonusOfNumbersOnly",new NumbersOnly(password).getBonus());
        results.put("bonusRepeatedCharacter", new RepeatCharacters(password).getBonus());
        results.put("bonusConsecutiveUppercaseLetter", new ConsecutiveUppercaseLetters(password).getBonus());
        results.put("bonusConsecutiveLowercaseLetter", new ConsecutiveLowercaseLetters(password).getBonus());
        results.put("bonusConsecutiveNumber", new ConsecutiveNumbers(password).getBonus());
        results.put("bonusSequentialLetters", new SequentialLetters(password).getBonus());
        results.put("bonusSequentialNumbers", new SequentialNumbers(password).getBonus());
        results.put("bonusSequentialSymbols", new SequentialSymbols(password).getBonus());
        results.put("bonusRequirements", new Requirements(password).getBonus());

        return results;
    }
}

