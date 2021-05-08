package passwordMeter;

import java.util.HashMap;
import java.util.Map;


public interface DeductionBuilder {

    default Map<String, Integer> getAllValues(String password) {
        Map<String, Integer> results = new HashMap<>();

        results.put("countLength", new NumberOfCharacters(password).getCount());
        results.put("countAlphaUpperCase", new UppercaseLetters(password).getCount());
        results.put("countAlphaLowerCase", new LowercaseLetters(password).getCount());
        results.put("countNumber", new Numbers(password).getCount());
        results.put("countSymbol", new Symbols(password).getCount());

        return results;
    }
}
