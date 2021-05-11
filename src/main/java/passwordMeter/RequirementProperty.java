package passwordMeter;

import passwordMeter.Enums.RequirementLevel;

public abstract class RequirementProperty {
    protected String password;

    public RequirementProperty(String password) {
        this.password = password;
    }

    public abstract int getCount();

    public abstract int getBonus();

    public abstract RequirementLevel getRequirementLevel();
}
