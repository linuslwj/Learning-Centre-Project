package CompanyStructure;

    public abstract class Employee {
        private static int countID;
        public String name;
        public double baseSalary;
        public int EmployeeID;
        Employee manager;
        Accountant accountant;
        public int headCount=0;
        public double bonus;

        public Employee(String name, double baseSalary) {
            this.name = name;
            this.baseSalary = baseSalary;
            countID++;
            this.EmployeeID = countID;
         }

        public void setBaseSalary(double baseSalary) {
            this.baseSalary = baseSalary;
        }

        public double getBaseSalary() {

            return this.baseSalary;
        }

        public String getName() {

            return this.name;
        }

        public int getEmployeeID() {

            return this.EmployeeID;
        }

        public Employee getManager() {
            return manager;
        }

        public void setManager(Employee manager) {
            this.manager = manager;
        }

        public Accountant getAccountant() {
            return accountant;
        }

        public boolean equals(Employee other) {
            return other.getEmployeeID() == this.getEmployeeID();
        }

        public String toString() {
            return this.EmployeeID + " " + this.name;
        }

        public abstract String employeeStatus();
    }

