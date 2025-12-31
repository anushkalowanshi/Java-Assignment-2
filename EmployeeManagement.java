package assi2;

import java.util.*;
import java.util.regex.*;

class Employee {
    int empId;
    String name;
    String email;

    Employee(int empId, String name, String email) {
        this.empId = empId;
        this.name = name;
        this.email = email;
    }

    public String toString() {
        return empId + " | " + name + " | " + email;
    }
}


interface EmployeeOperations {
    void addEmployee();
    void displayEmployees();
    void searchEmployee(int id);
    void removeEmployee(int id);
}



public class EmployeeManagement implements EmployeeOperations {

    Scanner sc = new Scanner(System.in);

    // Collections
    HashMap<Integer, Employee> hashMap = new HashMap<>();
    Hashtable<Integer, Employee> hashTable = new Hashtable<>();
    TreeMap<Integer, Employee> treeMap = new TreeMap<>();

    // REGEX validation
    boolean validateName(String name) {
        return Pattern.matches("[A-Za-z ]{3,}", name);
    }

    boolean validateEmail(String email) {
        return Pattern.matches("[a-zA-Z0-9._]+@[a-z]+\\.[a-z]{2,3}", email);
    }

    public void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            if (!validateName(name) || !validateEmail(email))
                throw new Exception("Invalid Input Format");

            Employee emp = new Employee(id, name, email);

            hashMap.put(id, emp);
            hashTable.put(id, emp);
            treeMap.put(id, emp);

            System.out.println("Employee Added Successfully");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine();
        }
    }

    public void displayEmployees() {
        System.out.println("\nHashMap Records:");
        hashMap.forEach((k, v) -> System.out.println(v));

        System.out.println("\nHashtable Records:");
        hashTable.forEach((k, v) -> System.out.println(v));

        System.out.println("\nTreeMap Records (Sorted):");
        treeMap.forEach((k, v) -> System.out.println(v));
    }

    public void searchEmployee(int id) {
        Employee emp = hashMap.get(id);
        if (emp != null)
            System.out.println("Employee Found: " + emp);
        else
            System.out.println("Employee Not Found");
    }

    public void removeEmployee(int id) {
        hashMap.remove(id);
        hashTable.remove(id);
        treeMap.remove(id);
        System.out.println("Employee Removed");
    }

    // Demonstrating null support
    void nullSupportDemo() {
        System.out.println("\nNull Support Demonstration:");

        hashMap.put(null, null); // Allowed
        System.out.println("HashMap allows null key & value");

        try {
            hashTable.put(null, null); // Not Allowed
        } catch (Exception e) {
            System.out.println("Hashtable does NOT allow null key/value");
        }
    }

    public static void main(String[] args) {

        EmployeeManagement em = new EmployeeManagement();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Add\n2.Display\n3.Search\n4.Remove\n5.Null Demo\n6.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> em.addEmployee();
                case 2 -> em.displayEmployees();
                case 3 -> {
                    System.out.print("Enter ID: ");
                    em.searchEmployee(sc.nextInt());
                }
                case 4 -> {
                    System.out.print("Enter ID: ");
                    em.removeEmployee(sc.nextInt());
                }
                case 5 -> em.nullSupportDemo();
            }

        } while (choice != 6);
    }
}