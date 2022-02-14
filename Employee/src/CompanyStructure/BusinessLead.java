package CompanyStructure;

import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee{
    public ArrayList<Accountant> team;
    public BusinessLead(String name) {
        super(name);
        this.setBaseSalary(getBaseSalary()*2);
        this.headCount=10;
        this.team = new ArrayList<>();
    }
    public boolean hasHeadCount() {
        return (this.team.size() < this.headCount);
    }


    public void addReport(Accountant e, TechnicalLead supportTeam) {
        if (hasHeadCount()) {
            team.add(e);
            e.setManager(this);
            this.bonusBudget+=e.baseSalary*1.1;
            e.supportTeam(supportTeam);
            supportTeam.accountant = e;
        }
    }

    public boolean requestBonus(Employee e, double bonus) {
        if (bonus<=getBonusBudget()) {
            this.bonusBudget-=bonus;
            e.bonus+= bonus;
            return true;
        }
        else {
            return false;
        }
    }

    public void approveBonus(Employee e, double bonus) {
        for (int i=0;i<team.size();i++){
            if((team.get(i).getTeamSupported()).equals(e.manager) && team.get(i).approveBonus(bonus)) {
                e.bonus += bonus;
                team.get(i).bonusBudget -= bonus;
            }
        }
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


