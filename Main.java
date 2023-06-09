package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean isWorking = true;

        System.out.println("Learning Progress Tracker");
        while (isWorking) {
            input = scanner.nextLine();
            if (input.isEmpty() || input.isBlank()) {
                System.out.println("No input.");
            } else if ("exit".equals(input)) {
                isWorking = false;
                System.out.println("Bye!");
            } else {
                System.out.println("Error: unknown command!");
            }
        }
    }
}
