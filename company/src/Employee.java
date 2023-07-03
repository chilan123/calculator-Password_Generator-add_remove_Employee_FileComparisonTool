import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String employeeId;
    private String name;
    private String address;
    private double basicSalary;
    private double overtimeRate;
    private double deductions;

    public Employee(String employeeId, String name, String address, double basicSalary, double overtimeRate, double deductions) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
        this.basicSalary = basicSalary;
        this.overtimeRate = overtimeRate;
        this.deductions = deductions;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double calculateNetSalary(double overtimeHours) {
        double overtimePayment = overtimeHours * overtimeRate;
        double netSalary = basicSalary + overtimePayment - deductions;
        return netSalary;
    }
}

class EmployeeManagementSystem {
    private List<Employee> employees;
    private Scanner scanner;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Deductions");
            System.out.println("4. Calculate Net Salary");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        viewEmployees();
                        break;
                    case 3:
                        updateDeductions();
                        break;
                    case 4:
                        calculateNetSalary();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        System.out.println("Thank you for using the Employee Management System!");
        scanner.close();
    }

    private void addEmployee() {
        System.out.print("\nEnter employee ID: ");
        String employeeId = scanner.nextLine();

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee address: ");
        String address = scanner.nextLine();

        try {
            System.out.print("Enter employee basic salary: ");
            double basicSalary = scanner.nextDouble();

            System.out.print("Enter overtime rate per hour: ");
            double overtimeRate = scanner.nextDouble();

            System.out.print("Enter employee deductions: ");
            double deductions = scanner.nextDouble();

            Employee employee = new Employee(employeeId, name, address, basicSalary, overtimeRate, deductions);
            employees.add(employee);

            System.out.println("Employee added successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input! Failed to add employee.");
            scanner.nextLine(); // Clear the input buffer
        }
    }

    private void viewEmployees() {
        System.out.println("\n--- Employee List ---");
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                System.out.println("Employee ID: " + employee.getEmployeeId());
                System.out.println("Name: " + employee.getName());
                System.out.println("Address: " + employee.getAddress());
                System.out.println("Basic Salary: " + employee.getBasicSalary());
                System.out.println("Deductions: " + employee.getDeductions());
                System.out.println("--------------------");
            }
        }
    }

    private void updateDeductions() {
        viewEmployees();

        if (employees.isEmpty()) {
            return;
        }

        System.out.print("Enter the employee ID to update deductions: ");
        String employeeId = scanner.nextLine();

        Employee employeeToUpdate = null;
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                employeeToUpdate = employee;
                break;
            }
        }

        if (employeeToUpdate != null) {
            try {
                System.out.print("Enter the new deductions: ");
                double newDeductions = scanner.nextDouble();
                employeeToUpdate.setDeductions(newDeductions);
                System.out.println("Deductions updated successfully!");
            } catch (Exception e) {
                System.out.println("Invalid input! Failed to update deductions.");
                scanner.nextLine(); // Clear the input buffer
            }
        } else {
            System.out.println("Invalid employee ID! Please try again.");
        }
    }

    private void calculateNetSalary() {
        viewEmployees();

        if (employees.isEmpty()) {
            return;
        }

        System.out.print("Enter the employee ID to calculate net salary: ");
        String employeeId = scanner.nextLine();

        Employee employeeToCalculate = null;
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                employeeToCalculate = employee;
                break;
            }
        }

        if (employeeToCalculate != null) {
            try {
                System.out.print("Enter the overtime hours: ");
                double overtimeHours = scanner.nextDouble();
                double netSalary = employeeToCalculate.calculateNetSalary(overtimeHours);
                System.out.println("Net Salary: " + netSalary);
            } catch (Exception e) {
                System.out.println("Invalid input! Failed to calculate net salary.");
                scanner.nextLine(); // Clear the input buffer
            }
        } else {
            System.out.println("Invalid employee ID! Please try again.");
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.start();
    }
}
