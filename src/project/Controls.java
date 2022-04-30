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
            System.out.println(ConsoleColours.RED + "Nezadali jste celé číslo" + ConsoleColours.RESET);
            System.out.println("Zadejte znovu volbu: ");
            sc.nextLine();
            number = onlyInt(sc);
        }
        return number;
    }

    public static int checkGrade(Scanner sc) {
        int grade = onlyInt(sc);

        while (true) {
            if (grade <= 1 || grade >= 5) {
                System.out.printf(ConsoleColours.RED + "Zadejte známku v rozsahu <1,5>: " + ConsoleColours.RESET);
                sc.nextLine();
                grade = checkGrade(sc);
            }
            break;
        }
        return grade;
    }

    public static int checkId(Scanner sc, Set<Integer> idsList) {
        int id = onlyInt(sc);

        while (true) {
            for (int i : idsList) {
                if (id == i) {
                    continue;
                } else {
                    System.out.printf(ConsoleColours.RED + "Student neexistuje, zadejte existujícíh studenta: " +
                            ConsoleColours.RESET);
                    sc.nextLine();
                    id = checkId(sc, idsList);
                }
            }
            break;
        }
        return id;
    }

    // TODO Date control
}
