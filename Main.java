package tracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final ArrayList<Student> students = new ArrayList<>(10);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Learning Progress Tracker");
        String input;
        boolean isWorking = true;

        while (isWorking) {
            input = scanner.nextLine();

            if ("add students".equals(input)) {
                addStudents();
            } else if ("exit".equals(input)) {
                System.out.println("Bye!");
                isWorking = false;
            } else if (input.isEmpty() || input.isBlank()) {
                System.out.println("No input.");
            } else if ("back".equals(input)) {
                System.out.println("Enter 'exit' to exit the program.");
            } else {
                System.out.println("Unknown command!");
            }
        }
    }



    private static void addStudents() {
        System.out.println("Enter student credentials or 'back' to return:");
        String input = scanner.nextLine();

        while (!"back".equals(input)) {

            if (input.split(" ").length >= 3) {
                String firstName = input.substring(0, input.indexOf(" "));
                String lastName = input.substring(input.indexOf(" ") + 1, input.lastIndexOf(" "));
                String email = input.substring(input.lastIndexOf(" ") + 1);
                System.out.println(result(firstName, lastName, email));
            } else {
                System.out.println("Incorrect credentials.");
            }
            input = scanner.nextLine();
        }

        System.out.printf("Total %d students have been added.\n", students.size());
    }


    public static boolean isEmailCorrect(String email) {
        String emailRegex = "[a-zA-Z0-9!#$%&’r;+-.=?^_`{}½~]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-]+";
        return (email.length() <= 50) && (email.matches(emailRegex));
    }


    public static String result(String firstName, String lastName, String email) {

        boolean isFirstNameCorrect = isNameCorrect(firstName);
        boolean isLastNameCorrect = isNameCorrect(lastName.split(" "));
        boolean isEmailCorrect = isEmailCorrect(email);

        String studentAdded = "The student has been added.";
        String incorrectFirstName = "Incorrect first name.";
        String incorrectLastName = "Incorrect last name.";
        String incorrectEmail = "Incorrect email.";
        String incorrectCredentials = "Incorrect credentials.";

        if (isFirstNameCorrect) {
            if (isLastNameCorrect) {
                if (isEmailCorrect) {
                    students.add(new Student(firstName, lastName, email));
                    return studentAdded;
                } else {
                    return incorrectEmail;
                }
            } else {
                if (isEmailCorrect) {
                    return incorrectLastName;
                } else {
                    return incorrectCredentials;
                }
            }
        } else {
            if (isLastNameCorrect) {
                if (isEmailCorrect) {
                    return incorrectFirstName;
                } else {
                    return incorrectCredentials;
                }
            } else {
                return incorrectCredentials;
            }
        }
    }


    private static boolean isNameCorrect(String ... names) {

        for (String name : names) {
            if (!((name.length() > 1) && (name.matches("[a-zA-Z]+[a-zA-Z'-]*[a-zA-Z]+")) && (!name.matches(".*[-']{2,}.*")))) {
                return false;
            }
        }
        return true;
    }
}
