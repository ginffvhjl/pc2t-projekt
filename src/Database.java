import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {

    public Database() {
        database = new HashMap<>();
    }

    public Map<Integer, Student> database;

    public void setStudent(int id, String surname, String name, int day, int month, int year, ArrayList<Integer> grades, float gpa) {
        database.put(id, new Student(surname, name, day, month, year, grades, gpa));
    }

    public void addGrades(int id, int grade) {
        if (database.containsKey(id)) {
            database.get(id).addGrade(grade);
        }
        else {
            System.out.println(ConsoleColours.RED + "Student s ID " + id + " neexistuje" + ConsoleColours.RESET);
        }
    }

    // TODO Write school
    public boolean writeStudent(int id) {
        if (database.containsKey(id)) {
            if (database.get(id).getGpa() == 0) {
                System.out.println(" ID:  " + id);
                System.out.println(" Jméno:  " + database.get(id).getSurname() + " " + database.get(id).getName());
                System.out.println(" Datum narození:  " + database.get(id).getDay() + ". " +
                        database.get(id).getMonth() + ". " + database.get(id).getYear());
                System.out.println(" Průměr:  " + ConsoleColours.RED + "NEZADÁN" + ConsoleColours.RESET);
            }
            else {
                System.out.println(" ID:  " + id);
                System.out.println(" Jméno:  " + database.get(id).getSurname() + " " + database.get(id).getName());
                System.out.println(" Datum narození:  " + database.get(id).getDay() + ". " +
                        database.get(id).getMonth() + ". " + database.get(id).getYear());
                System.out.println(" Průměr:  " + database.get(id).getGpa());
            }
            return true;
        }
        else {
            System.out.println(ConsoleColours.RED + "Student neexistuje" + ConsoleColours.RESET);
            return false;
        }
    }
}
