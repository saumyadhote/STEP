public class Employee {

    private String empID, empName, department, empType;
    private double baseSalary;
    private double bonus;
    private double hourlyRate;
    private int hoursWorked;
    private double contractAmount;

    private static int totalEmployees = 0;

    // Full-time constructor
    public Employee(String empID, String empName, String department, double baseSalary, double bonus) {
        this.empID = empID;
        this.empName = empName;
        this.department = department;
        this.empType = "Full-Time";
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        totalEmployees++;
    }

    // Part-time constructor
    public Employee(String empID, String empName, String department, double hourlyRate, int hoursWorked) {
        this.empID = empID;
        this.empName = empName;
        this.department = department;
        this.empType = "Part-Time";
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        totalEmployees++;
    }

    // Contract constructor
    public Employee(String empID, String empName, String department, double contractAmount) {
        this.empID = empID;
        this.empName = empName;
        this.department = department;
        this.empType = "Contract";
        this.contractAmount = contractAmount;
        totalEmployees++;
    }

    // Overloaded calculateSalary methods
    public double calculateSalary(double baseSalary, double bonus) {
        return baseSalary + bonus;  // Full-time
    }

    public double calculateSalary(double hourlyRate, int hoursWorked) {
        return hourlyRate * hoursWorked;  // Part-time
    }

    public double calculateSalary(double contractAmount) {
        return contractAmount;  // Contract
    }

    // Overloaded calculateTax methods
    public double calculateTax(double salary, String empType) {
        double taxRate;
        switch (empType) {
            case "Full-Time": taxRate = 0.2; break;   // 20%
            case "Part-Time": taxRate = 0.1; break;   // 10%
            case "Contract": taxRate = 0.15; break;   // 15%
            default: taxRate = 0.0;
        }
        return salary * taxRate;
    }

    // Generate Pay Slip
    public void generatePaySlip() {
        double salary = 0;
        if (empType.equals("Full-Time")) {
            salary = calculateSalary(baseSalary, bonus);
        } else if (empType.equals("Part-Time")) {
            salary = calculateSalary(hourlyRate, hoursWorked);
        } else if (empType.equals("Contract")) {
            salary = calculateSalary(contractAmount);
        }

        double tax = calculateTax(salary, empType);

        System.out.println("\n----- Pay Slip -----");
        System.out.println("Employee ID: " + empID);
        System.out.println("Name: " + empName);
        System.out.println("Department: " + department);
        System.out.println("Type: " + empType);
        System.out.println("Gross Salary: " + salary);
        System.out.println("Tax Deduction: " + tax);
        System.out.println("Net Salary: " + (salary - tax));
        System.out.println("--------------------");
    }

    // Display Employee Info
    public void displayEmployeeInfo() {
        System.out.println(empID + " | " + empName + " | " + department + " | " + empType);
    }

    // Static methods
    public static int getTotalEmployees() {
        return totalEmployees;
    }

    public static void generateCompanyPayrollReport(Employee[] employees) {
        System.out.println("\n===== Company Payroll Report =====");
        for (Employee e : employees) {
            e.generatePaySlip();
        }
        System.out.println("Total Employees: " + getTotalEmployees());
        System.out.println("==================================");
    }

    // Main method for testing
    public static void main(String[] args) {
        Employee e1 = new Employee("E101", "Alice", "IT", 50000, 10000); // Full-time
        Employee e2 = new Employee("E102", "Bob", "HR", 200, 100);       // Part-time
        Employee e3 = new Employee("E103", "Charlie", "Finance", 60000); // Contract

        e1.displayEmployeeInfo();
        e2.displayEmployeeInfo();
        e3.displayEmployeeInfo();

        e1.generatePaySlip();
        e2.generatePaySlip();
        e3.generatePaySlip();

        Employee[] employees = {e1, e2, e3};
        generateCompanyPayrollReport(employees);
    }
}
