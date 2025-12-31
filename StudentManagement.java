package assi2;

import java.util.*;
import java.util.regex.*;

interface StudentOps {
    void addStudent();
    void display();
    void search(int roll);
    void remove(int roll);
}

class Student {
    int roll;
    String name;

    Student(int r, String n) {
        roll = r;
        name = n;
    }
}

public class StudentManagement implements StudentOps {

    List<Student> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Roll: ");
        int r = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String n = sc.nextLine();
        list.add(new Student(r, n));
    }

    public void display() {
        for (Student s : list)
            System.out.println(s.roll + " " + s.name);
    }

    public void search(int roll) {
        for (Student s : list)
            if (s.roll == roll)
                System.out.println("Found: " + s.name);
    }

    public void remove(int roll) {
        list.removeIf(s -> s.roll == roll);
    }

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        sm.addStudent();
        sm.display();
        sm.search(1);
        sm.remove(1);
    }
}
