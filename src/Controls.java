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
}
