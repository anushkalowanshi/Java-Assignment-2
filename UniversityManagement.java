package assi2;

import java.util.*;
import java.util.regex.*;

// Interface
interface UniversityOperations {
    void addStud();
    void displayStud();
    void searchStud(int id);
    void removeStud(int id);
}

// Stud class (renamed from Student)
class Stud {
    int id;
    String name;
    String course;
    int marks;

    Stud(int id, String name, String course, int marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public String toString() {
        return id + " | " + name + " | " + course + " | " + marks;
    }
}

// Main class
public class UniversityManagement implements UniversityOperations {

    Scanner sc = new Scanner(System.in);

    // Collections
    ArrayList<Stud> al = new ArrayList<>();
    Vector<Stud> v = new Vector<>();
    Stack<Stud> st = new Stack<>();

    HashMap<Integer, Stud> hm = new HashMap<>();
    Hashtable<Integer, Stud> ht = new Hashtable<>();
    TreeMap<Integer, Stud> tm = new TreeMap<>();

    Set<String> courseSet = new HashSet<>();

    // REGEX validation
    boolean validateName(String name) {
        return Pattern.matches("[A-Za-z ]{3,}", name);
    }

    boolean validateCourse(String course) {
        return Pattern.matches("[A-Za-z]{2,}", course);
    }

    // Add student
    public void addStud() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (hm.containsKey(id))
                throw new Exception("Duplicate Student ID");

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            if (!validateName(name) || !validateCourse(course))
                throw new Exception("Invalid Input Format");

            Stud s = new Stud(id, name, course, marks);

            al.add(s);
            v.add(s);
            st.push(s);
            hm.put(id, s);
            ht.put(id, s);

            courseSet.add(course);

            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine();
        }
    }

    // Display all students
    public void displayStud() {
        System.out.println("\nAll Students:");
        for (Stud s : al)
            System.out.println(s);
    }

    // Search student
    public void searchStud(int id) {
        Stud s = hm.get(id);
        if (s != null)
            System.out.println("Found: " + s);
        else
            System.out.println("Student Not Found");
    }

    // Remove student
    public void removeStud(int id) {
        Stud s = hm.remove(id);
        ht.remove(id);
        tm.remove(id);

        if (s != null) {
            al.remove(s);
            v.remove(s);
            st.remove(s);
            System.out.println("Student Removed");
        } else {
            System.out.println("Student Not Found");
        }
    }

    // Sort by marks
    void sortByMarks() {
        al.sort(Comparator.comparingInt(x -> x.marks));
        System.out.println("Students Sorted by Marks");
        displayStud();
    }

    // Convert HashMap to TreeMap
    void convertMap() {
        tm = new TreeMap<>(hm);
        System.out.println("HashMap converted to TreeMap");
    }

    // Count students course-wise
    void countCourseWise() {
        Map<String, Integer> countMap = new HashMap<>();
        for (Stud s : al)
            countMap.put(s.course, countMap.getOrDefault(s.course, 0) + 1);

        System.out.println("Course-wise Student Count:");
        countMap.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    // Display unique courses
    void displayCourses() {
        System.out.println("Unique Courses:");
        for (String c : courseSet)
            System.out.println(c);
    }

    // Main method with menu
    public static void main(String[] args) {

        UniversityManagement um = new UniversityManagement();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("""
            1.Add Student
            2.Display Students
            3.Search Student
            4.Remove Student
            5.Sort by Marks
            6.Convert HashMap to TreeMap
            7.Count Course-wise
            8.Display Courses
            9.Exit
            """);

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> um.addStud();
                case 2 -> um.displayStud();
                case 3 -> {
                    System.out.print("Enter ID: ");
                    um.searchStud(sc.nextInt());
                }
                case 4 -> {
                    System.out.print("Enter ID: ");
                    um.removeStud(sc.nextInt());
                }
                case 5 -> um.sortByMarks();
                case 6 -> um.convertMap();
                case 7 -> um.countCourseWise();
                case 8 -> um.displayCourses();
            }

        } while (choice != 9);
    }
}
