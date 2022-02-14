package CompanyStructure;

public class TechnicalEmployee extends Employee {
    public int checkIns;
    public TechnicalEmployee(String name){
        super(name, 7500);
        checkIns=0;
    }
    public String employeeStatus () {
        return super.toString() + " has " + this.checkIns + " successful check ins";
    }

}
