package passwordMeter;

public abstract class RequirementProperty {
    protected String password;

    public RequirementProperty(String password) {
        this.password = password;
    }

    abstract int getCount();

    abstract int getBonus();

    abstract RequirementLevel getRequirementLevel();

    abstract OperationType getOperationType();


}
