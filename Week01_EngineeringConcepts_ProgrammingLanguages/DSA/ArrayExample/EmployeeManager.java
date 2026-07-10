public class EmployeeManager {

    private Employee[] employees;
    private int size;       
    private int capacity;   

    public EmployeeManager(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    public boolean addEmployee(Employee emp) {
        if (size >= capacity) {
            System.out.println("Cannot add employee: array is full.");
            return false;
        }
        employees[size] = emp;
        size++;
        System.out.println("Added: " + emp);
        return true;
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null; 
    }

    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
            return;
        }
        System.out.println("--- Employee List ---");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployee(int employeeId) {
        int indexToDelete = -1;

        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Employee with ID " + employeeId + " not found.");
            return false;
        }

        for (int i = indexToDelete; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[size - 1] = null; 
        size--;
        System.out.println("Deleted employee with ID: " + employeeId);
        return true;
    }
}