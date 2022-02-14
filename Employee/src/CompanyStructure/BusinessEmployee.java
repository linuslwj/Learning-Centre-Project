package CompanyStructure;

public class BusinessEmployee extends Employee {
    public double bonusBudget;
    public BusinessEmployee(String name) {
        super(name, 50000);
    }

    public double getBonusBudget() {
        return bonusBudget;
    }

    public void setBonusBudget(double bonusBudget) {
        this.bonusBudget = bonusBudget;
    }

    public String employeeStatus() {
        return super.toString() + " with a budget of " + bonusBudget;
    }
}
