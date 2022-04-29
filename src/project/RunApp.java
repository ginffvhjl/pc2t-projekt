package project;

import java.util.ArrayList;
import java.util.Scanner;

public class RunApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Database studentDatabase = new Database();

        int newID = 1;
        int id;

        String name;
        String surname;

        int day;
        int month;
        int year;

        ArrayList<Integer> grades = new ArrayList<>();
        int grade;
        float gpa;

        boolean run = true;

        while(run) {
            System.out.println("Vyberte požadovanou činnost:\n");
            System.out.println(" 01  přidat studenta");
            System.out.println(" 02  nová známka");
            System.out.println(" 03  odstranit studenta");
            System.out.println(" 04  informace o studentovi");
            System.out.println(" 05  spustit studentovu schopnost");
            System.out.println(" 06  vypsat seznam všech studentů");
            System.out.println(" 07  průměr oborů");
            System.out.println(" 08  množství studentů v oborech");
            System.out.println(" 09  načíst databázi ze souboru");
            System.out.println(" 10  uložit databázi do souboru");
            System.out.println(" 11  smazat databází");
            System.out.println(" 00  ukončit program\n\n");

            int option = Controls.onlyInt(sc);

            switch (option) {
                case 1:
                    System.out.println("Vyberte obor: ");
                    System.out.println(" 1  Technický obor");
                    System.out.println(" 2  Humanitní obor");
                    System.out.println(" 3  Kombinovaný obor");

                    int branch = Controls.onlyInt(sc);

                    System.out.printf(ConsoleColours.YELLOW + "Zadejte příjmení: " + ConsoleColours.RESET);
                    sc.nextLine();
                    surname = sc.nextLine();
                    System.out.printf(ConsoleColours.YELLOW + "Zadejte jméno: " + ConsoleColours.RESET);
                    name = sc.nextLine();
                    System.out.printf(ConsoleColours.YELLOW + "Zadejte datum narození ve formátu DD/MM/YYYY: " +
                            ConsoleColours.RESET);
                    String line = sc.nextLine();
                    String[] array = line.split("/");
                    day = Integer.parseInt(array[0]);
                    month = Integer.parseInt(array[1]);
                    year = Integer.parseInt(array[2]);
                    gpa = 0;
                    switch (branch) {
                        case 1:
                            studentDatabase.setStudent(newID, surname, name, day, month, year, grades, gpa);
                    }

                    // TODO Choose school
                    /*switch (branch) {
                        case 1:

                    }*/
                    newID = newID + 1;
                    break;
                case 2:
                    // TODO First check if ID is valid
                    // TODO FIX: initiation of grade
                    // TODO FIX: All students have same grades
                    System.out.printf(ConsoleColours.YELLOW + "Zadejte ID: " + ConsoleColours.RESET);
                    id = Controls.onlyInt(sc);
                    sc.nextLine();
                    System.out.printf(ConsoleColours.YELLOW + "Zadejte známku: " + ConsoleColours.RESET);
                    grade = Controls.checkGrade(sc);
                    studentDatabase.addGrades(id, grade);
                    break;
                case 4:
                    System.out.printf(ConsoleColours.YELLOW + "Zadejte ID: " + ConsoleColours.RESET);
                    sc.nextLine();
                    id = Controls.onlyInt(sc);
                    System.out.println(studentDatabase.writeStudent(id));
                    break;
                case 11:
                    studentDatabase = new Database();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    run = true;
                    break;

            }
        }
    }
}
