package project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controls {

    public static int onlyInt(Scanner sc) {
        int number;

        try {
            number = sc.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println(ConsoleColours.RED + "\nNezadali jste celé číslo" + ConsoleColours.RESET);
            System.out.println("Zadejte znovu volbu: ");
            sc.nextLine();
            number = onlyInt(sc);
        }
        return number;
    }

    public static int checkGrade(Scanner sc) {
        int grade = onlyInt(sc);

        while (true) {
            if (grade < 1 && grade > 5) {
                System.out.println(ConsoleColours.RED + "\nZadejte známku v rozsahu <1,5>: " + ConsoleColours.RESET);
                sc.nextLine();
                grade = onlyInt(sc);
            }
            else {
                break;
            }
        }
        return grade;
    }

    // TODO Non existing user exception
}
