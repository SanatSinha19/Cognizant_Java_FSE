public class EmployeeTest {

    public static void main(String[] args) {

        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee(101, "Alice Sharma", "Software Engineer", 65000));
        manager.addEmployee(new Employee(102, "Rahul Verma", "Product Manager", 85000));
        manager.addEmployee(new Employee(103, "Priya Nair", "QA Engineer", 55000));
        manager.addEmployee(new Employee(104, "John Mathew", "DevOps Engineer", 70000));

        System.out.println();

        manager.traverseEmployees();

        System.out.println();

        System.out.println("--- Searching for employee ID 103 ---");
        Employee found = manager.searchEmployee(103);
        System.out.println(found != null ? "Found: " + found : "Not found.");

        System.out.println();

        System.out.println("--- Deleting employee ID 102 ---");
        manager.deleteEmployee(102);

        System.out.println();

        manager.traverseEmployees();
    }
}