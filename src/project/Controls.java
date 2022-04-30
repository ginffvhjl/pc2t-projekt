package project;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Controls {

    public static int onlyInt(Scanner sc) {
        int number;

        try {
            number = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(ConsoleColours.RED + "The number must be whole number." + ConsoleColours.RESET);
            System.out.println("Enter again: ");
            sc.nextLine();
            number = onlyInt(sc);
        }
        return number;
    }

    public static int checkGrade(Scanner sc) {
        int grade = onlyInt(sc);

        while (true) {
            if (grade < 1 || grade > 5) {
                System.out.printf(ConsoleColours.RED + "Enter grade <1,5>: " + ConsoleColours.RESET);
                sc.nextLine();
                grade = checkGrade(sc);
            }
            break;
        }
        return grade;
    }

    public static int checkId(Scanner sc, Set<Integer> idsList) {
        int id = onlyInt(sc);

        if (!idsList.contains(id)) {
            System.out.println("Student does not exist.");
            System.out.printf("Enter valid student: ");
            id = checkId(sc, idsList);
        }
        return id;
    }

    public static boolean checkIdBoolean(Scanner sc, Set<Integer> idsList) {
        int id = onlyInt(sc);

        if (!idsList.contains(id)) {
            System.out.println("Student does not exist.");
            return false;
        }
        return true;
    }

    // TODO Date control
}
