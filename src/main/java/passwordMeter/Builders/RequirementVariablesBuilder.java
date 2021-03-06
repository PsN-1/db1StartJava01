package passwordMeter.Builders;

import passwordMeter.*;
import passwordMeter.Additions.*;

import java.util.ArrayList;

public class RequirementVariablesBuilder {
    public ArrayList<RequirementProperty> getAllCountValues(String password) {
        ArrayList<RequirementProperty> results = new ArrayList<>();

        results.add(new NumberOfCharacters(password));
        results.add(new UppercaseLetters(password));
        results.add(new LowercaseLetters(password));
        results.add(new Numbers(password));
        results.add(new Symbols(password));

        return results;
    }
}
