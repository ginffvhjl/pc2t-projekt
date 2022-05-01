package project;

import project.ability.ZodiacSign;
import project.branch.*;

import java.util.Scanner;

import static project.Controls.*;

public class RunApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Database studentDatabase = new Database();

        boolean run = true;

        while (run) {
            System.out.println("\nMenu:");
            System.out.println(" 01  Add student");
            System.out.println(" 02  Add new grade");
            System.out.println(" 03  Delete student");
            System.out.println(" 04  Information about student");
            System.out.println(" 05  Student's abilities");
            System.out.println(" 06  List of all students");
            System.out.println(" 07  Average grade of each school branch");
            System.out.println(" 08  Amount of students in each school branch");
            System.out.println(" 09  Load database from file");
            System.out.println(" 10  Save database in file");
            System.out.println(" 11  Delete database");
            System.out.println(" 00  Exit\n");

            int option = onlyInt(sc);
            int id;
            String name;
            String surname;
            int day;
            int month;
            int year;

            switch (option) {
                case 1:

                    System.out.println("\nChoose school branch: ");
                    System.out.println(" 1  Technic branch");
                    System.out.println(" 2  Humane branch");
                    System.out.println(" 3  Combined branch");

                    int branch = onlyInt(sc);

                    System.out.printf(ConsoleColours.CYAN + "Surname: " + ConsoleColours.RESET);
                    sc.nextLine();
                    surname = sc.nextLine();
                    System.out.printf(ConsoleColours.CYAN + "Name: " + ConsoleColours.RESET);
                    name = sc.nextLine();
                    // TODO Add date validation
                    System.out.printf(ConsoleColours.CYAN + "Date in format DD/MM/YYYY: " +
                            ConsoleColours.RESET);
                    String line = checkDateFormate(sc);
                    String[] array = line.split("/");
                    day = Integer.parseInt(array[0]);
                    month = Integer.parseInt(array[1]);
                    year = Integer.parseInt(array[2]);
                    id = studentDatabase.getNextStudentId();

                    Student student = null;
                    switch (branch) {
                        case 1:
                            student = new TechnicalStudent(id, surname, name, day, month, year);
                            break;
                        case 2:
                            student = new HumaneStudent(id, surname, name, day, month, year);
                            break;
                        case 3:
                            student = new CombinedStudent(id, surname, name, day, month, year);
                            break;
                        default:
                            System.out.println("Incorrect input.");
                            break;
                    }
                    if (student != null) {
                        studentDatabase.addStudent(student);
                        System.out.println(student);
                    }
                    break;
                case 2:
                    int grade;
                    System.out.printf(ConsoleColours.CYAN + "Student's ID: " + ConsoleColours.RESET);
                    id = checkId(sc, studentDatabase.database.keySet());
                    sc.nextLine();
                    System.out.printf(ConsoleColours.CYAN + "Grade: " + ConsoleColours.RESET);
                    grade = Controls.checkGrade(sc);
                    student = studentDatabase.getStudent(id);
                    student.addGrade(grade);
                    break;
                case 3:
                    System.out.printf(ConsoleColours.CYAN + "Student's ID: " + ConsoleColours.RESET);
                    sc.nextLine();
                    id = checkId(sc, studentDatabase.database.keySet());
                    studentDatabase.removeStudent(id);
                    break;
                case 4:
                    System.out.printf(ConsoleColours.CYAN + "Student's ID: " + ConsoleColours.RESET);
                    sc.nextLine();
                    id = checkId(sc, studentDatabase.database.keySet());
                    student = studentDatabase.getStudent(id);
                    System.out.println(student);
                    break;
                case 5:
                    System.out.printf(ConsoleColours.CYAN + "Student's ID: " + ConsoleColours.RESET);
                    sc.nextLine();
                    id = checkId(sc, studentDatabase.database.keySet());
                    student = studentDatabase.getStudent(id);
                    if (student instanceof TechnicalBranch) {
                        boolean bornInLeapYear = ((TechnicalBranch) student).isBornInLeapYear();
                        if (bornInLeapYear) {
                            System.out.println("I am born in leap year.");
                        } else {
                            System.out.println("I am not born in leap year");
                        }
                    }
                    if (student instanceof HumaneBranch) {
                        ZodiacSign zodiacSign = ((HumaneBranch) student).getZodiacSign();
                        System.out.println("My zodiac sign is " + zodiacSign);
                    }
                    break;
                case 6:
                    studentDatabase.printAllStudentsByAlphabet();
                    break;
                case 7:
                    System.out.println("Average of humane branch is " + ConsoleColours.CYAN +
                            studentDatabase.getBranchAvg(HumaneStudent.class) + ConsoleColours.RESET);
                    System.out.println("Average of technical branch is " + ConsoleColours.CYAN +
                            studentDatabase.getBranchAvg(TechnicalStudent.class) + ConsoleColours.RESET);
                    System.out.println("Average of combined branch is " + ConsoleColours.CYAN +
                            studentDatabase.getBranchAvg(CombinedStudent.class) + ConsoleColours.RESET);
                    break;
                case 8:
                    System.out.println("Humane branch: " + ConsoleColours.CYAN +
                            studentDatabase.getBranchSize(HumaneStudent.class) + ConsoleColours.RESET);
                    System.out.println("Technical branch: " + ConsoleColours.CYAN +
                            studentDatabase.getBranchSize(TechnicalStudent.class) + ConsoleColours.RESET);
                    System.out.println("Combined branch: " + ConsoleColours.CYAN +
                            studentDatabase.getBranchSize(CombinedStudent.class) + ConsoleColours.RESET);
                    break;
                case 10:
                    try {
                        System.out.println(ConsoleColours.RED + "Existing file will be overwritten." +
                                ConsoleColours.RESET);
                        sc.nextLine();
                        System.out.printf("Enter file name: ");
                        String fileName = sc.nextLine();
                        studentDatabase.saveToFile(fileName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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

