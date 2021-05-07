package passwordMeter;

abstract class RequirementProperties {
    protected String password;

    public RequirementProperties(String password) {
        this.password = password;
    }

    abstract int getCount();

    abstract int getBonus();

    abstract RequirementLevel getRequirementLevel();

    abstract OperationType getOperationType();


}
