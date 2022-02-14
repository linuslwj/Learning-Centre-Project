package CompanyStructure;

public class Accountant extends BusinessEmployee {
    public TechnicalLead teamSupported;
    public Accountant(String name) {
        super(name);
        this.setBonusBudget(0);
    }

    public TechnicalLead getTeamSupported() {
        return teamSupported;
    }

    public void supportTeam(TechnicalLead lead) {
        this.teamSupported = lead;
        for (int i = 0; i < lead.team.size(); i++) {
            this.bonusBudget += lead.team.get(i).getBaseSalary()*1.1;
        }
    }

    public boolean approveBonus(double bonus) {
        if (bonus <= getBonusBudget()) {
            return true;
        }
        else {
            System.out.println("Rejected");
            return false;
        }
    }




    public String employeeStatus() {

        return super.toString() + " with a budget of " + getBonusBudget() + " is supporting " + this.getTeamSupported();
    }
}
