class Employee {

    int employeeId;
    String name;
    String position;
    double salary;

    // Constructor
    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Display Employee Details
    public void display() {
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Position    : " + position);
        System.out.println("Salary      : ₹" + salary);
        System.out.println("----------------------------");
    }
}

public class EmployeeManagementSystem {

    // Maximum employees
    static Employee[] employees = new Employee[10];
    static int count = 0;

    // Add Employee
    public static void addEmployee(Employee employee) {

        if (count == employees.length) {
            System.out.println("Employee array is full.");
            return;
        }

        employees[count] = employee;
        count++;

        System.out.println("Employee added successfully.");
    }

    // Search Employee
    public static void searchEmployee(int id) {

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {

                System.out.println("\nEmployee Found\n");
                employees[i].display();
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    // Traverse Employees
    public static void traverseEmployees() {

        if (count == 0) {
            System.out.println("No employee records available.");
            return;
        }

        System.out.println("\nEmployee Records\n");

        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    // Delete Employee
    public static void deleteEmployee(int id) {

        int index = -1;

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        // Shift elements to left
        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee deleted successfully.");
    }

    public static void main(String[] args) {

        addEmployee(new Employee(101, "Prateek", "Software Engineer", 65000));
        addEmployee(new Employee(102, "Rahul", "Tester", 45000));
        addEmployee(new Employee(103, "Sneha", "HR", 50000));

        traverseEmployees();

        searchEmployee(102);

        deleteEmployee(101);

        System.out.println("\nAfter Deletion\n");

        traverseEmployees();
    }
}