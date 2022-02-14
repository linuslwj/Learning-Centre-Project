package CompanyStructure;

import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
    public ArrayList<SoftwareEngineer> team;
    public TechnicalLead(String name) {
        super(name);
        this.baseSalary*=1.3;
        this.headCount=4;
        this.team= new ArrayList<>();
    }

    public boolean hasHeadCount() {
        return team.size() < this.headCount;
    }

    public void addReport(SoftwareEngineer e) {
        if(hasHeadCount()) {
            team.add(e);
            e.setManager(this);
        }
    }

    public boolean approveCheckIn(SoftwareEngineer e) {
        return (team.contains(e)) && (e.getCodeAccess());
    }

    public void requestBonus(Employee e, double bonus) {
        BusinessLead businessLead = (BusinessLead)getAccountant().getManager();
        businessLead.approveBonus(e, bonus);
    }

    public String getTeamStatus() {
        if (team.size() == 0) {
            return this.employeeStatus() + " and no direct reports yet ";
        }
        else {
            StringBuilder teamStatus= new StringBuilder();
            for (int i = 0;i<team.size();i++) {
                teamStatus.append("    ").append(team.get(i).employeeStatus()).append("\n");
            }
            return this.employeeStatus()+" and is managing: \n"+teamStatus;
        }
    }
}
