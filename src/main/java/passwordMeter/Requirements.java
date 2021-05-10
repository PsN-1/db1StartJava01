package passwordMeter;

import java.util.ArrayList;

// additions
public class Requirements extends RequirementProperty implements RequirementBuilder{
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
        resultsArr = getAllCountValues(this.password);
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
    int getCount() {
        return countRequirements;
    }

    @Override
    int getBonus() {
        return bonusRequirements;
    }

    @Override
    RequirementLevel getRequirementLevel() {
        return reqLevel;
    }
}
