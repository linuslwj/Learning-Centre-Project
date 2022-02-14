package CompanyStructure;

public class CompanyStructure {
    public static void main(String[] args) {
        TechnicalLead CTO = new TechnicalLead("Satya Nadella");
        SoftwareEngineer seA = new SoftwareEngineer("Kasey");
        SoftwareEngineer seB = new SoftwareEngineer("Breana");
        SoftwareEngineer seC = new SoftwareEngineer("Eric");
        CTO.addReport(seA);
        CTO.addReport(seB);
        CTO.addReport(seC);
        System.out.println(seB.getManager()); //test get Breana's manager
        System.out.println(CTO.getTeamStatus()); //Print Satya Nadella's Team

        TechnicalLead VPofENG = new TechnicalLead("Bill Gates");
        SoftwareEngineer seD = new SoftwareEngineer("Winter");
        SoftwareEngineer seE = new SoftwareEngineer("Libby");
        SoftwareEngineer seF = new SoftwareEngineer("Gizan");
        SoftwareEngineer seG = new SoftwareEngineer("Zaynah");
        VPofENG.addReport(seD);
        VPofENG.addReport(seE);
        VPofENG.addReport(seF);
        VPofENG.addReport(seG);
        System.out.println(seD.getManager()); //test get Winter's manager
        System.out.println(VPofENG.getTeamStatus()); //Print Bill Gates's Team

        BusinessLead CFO = new BusinessLead("Amy Hood");
        Accountant actA = new Accountant("Niky");
        Accountant actB = new Accountant("Andrew");
        CFO.addReport(actA,CTO);
        CFO.addReport(actB,VPofENG);
        System.out.println(CFO.getTeamStatus()); //Print Amy Hood's Team
        seA.checkInCode();
        System.out.println(seA.getSuccessfulCheckIns());
        System.out.println(CTO.getTeamStatus()); //Print updated team stats after seA check ins.
        System.out.println();
        System.out.println(seF.getManager().getAccountant().getName() + "'s Current budget is: "+seF.getManager().getAccountant().getBonusBudget());
        System.out.println(VPofENG.getName() + " requests for a $5000 bonus for " + seF.getName());
        VPofENG.requestBonus(seF, 5000);
        System.out.println(seF.getManager().getAccountant().getName() +"'s Updated budget is: "+seF.getManager().getAccountant().getBonusBudget()+"\n");
        System.out.println(CFO + "'s Current budget is " + CFO.getBonusBudget());
        System.out.println(CFO + " requests for $120000 bonus for " + actA.getName());
        System.out.println(CFO.requestBonus(actA,120000));
    }
}
