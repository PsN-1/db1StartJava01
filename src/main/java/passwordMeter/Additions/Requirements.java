package passwordMeter.Additions;

import passwordMeter.Builders.RequirementBuilder;
import passwordMeter.Enums.RequirementLevel;
import passwordMeter.RequirementProperty;

import java.util.ArrayList;

public class Requirements extends RequirementProperty {
    private RequirementLevel reqLevel;
    private int bonusRequirements, countRequirements;

    public Requirements(String password) {
        super(password);
        calculateCountOfRequirements();
        calculateBonusOfRequirements();
        calculateRequirementLevel();
    }

    void calculateCountOfRequirements(){
        var resultsArr = new ArrayList<RequirementProperty>();
        var requirementBuilder = new RequirementBuilder();
        resultsArr = requirementBuilder.getAllCountValues(this.password);
        int minimumLength = 8;

        for (RequirementProperty requirementProperty : resultsArr) {
            int minimumValue = requirementProperty.getClass() == NumberOfCharacters.class ? (minimumLength) : 1;

            if (requirementProperty.getCount() == minimumValue) {
                countRequirements++;
            } else if (requirementProperty.getCount() > minimumValue) {
                countRequirements++;
            }
        }
    }

    void calculateBonusOfRequirements() {
        int multiplier = 2;
        int minimumLength = 8;
        int numberMinimumOfRequiredChars = password.length() >= minimumLength ? 3: 4;

        if (countRequirements > numberMinimumOfRequiredChars) {
            bonusRequirements = countRequirements * multiplier;
        }
    }

    void calculateRequirementLevel() {
        int minimumLength = 8;
        int numberMinimumOfRequiredChars = password.length() >= minimumLength ? 4 : 5;

        if (countRequirements == numberMinimumOfRequiredChars) {
            reqLevel = RequirementLevel.SUFFICIENT;
        } else if (countRequirements > numberMinimumOfRequiredChars) {
            reqLevel = RequirementLevel.EXCEPTIONAL;
        } else {
            reqLevel = RequirementLevel.FAILURE;
        }
    }

    @Override
    public int getCount() {
        return countRequirements;
    }

    @Override
    public int getBonus() {
        return bonusRequirements;
    }

    @Override
    public RequirementLevel getRequirementLevel() {
        return reqLevel;
    }
}
