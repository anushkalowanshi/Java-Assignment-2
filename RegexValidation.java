package assi2;

import java.util.Scanner;
import java.util.regex.*;

public class RegexValidation {

    static Scanner sc = new Scanner(System.in);

    static boolean validate(String input, String regex) {
        return Pattern.matches(regex, input);
    }

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("\n1.Mobile\n2.Email\n3.Username\n4.Password\n5.Exit");
            choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter Mobile: ");
                        String mob = sc.nextLine();
                        if (validate(mob, "[6-9][0-9]{9}"))
                            System.out.println("Welcome!");
                        else
                            System.out.println("Invalid Mobile");
                        break;

                    case 2:
                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();
                        if (validate(email, "[a-zA-Z0-9._]+@[a-z]+\\.[a-z]{2,3}"))
                            System.out.println("Welcome!");
                        else
                            System.out.println("Invalid Email");
                        break;

                    case 3:
                        System.out.print("Enter Username: ");
                        String user = sc.nextLine();
                        if (validate(user, "[A-Za-z0-9]{5,10}"))
                            System.out.println("Welcome!");
                        else
                            System.out.println("Invalid Username");
                        break;

                    case 4:
                        System.out.print("Enter Password: ");
                        String pass = sc.nextLine();
                        if (validate(pass, "(?=.*[A-Z])(?=.*[0-9]).{6,}"))
                            System.out.println("Welcome!");
                        else
                            System.out.println("Invalid Password");
                        break;

                }
            } catch (Exception e) {
                System.out.println("Error Occurred");
            }

        } while (choice != 5);
    }
}
