import java.util.HashMap;
import java.util.Map;

public class Database {

    public Database() {
        database = new HashMap<>();
    }

    public Map<Integer, Student> database;

    public void setStudent(int id, String surname, String name, int day, int month, int year, float gpa) {
        database.put(id, new Student(surname, name, day, month, year, gpa));
    }

    public void setGPA(int id, float gpa) throws GPAException {
        if (database.containsKey(id)) {
            database.get(id).writeGPA(gpa);
        }
        else {
            System.out.println(ConsoleColours.RED + "Student s ID " + id + " neexistuje");
        }
    }
    // TODO Write school
    // TODO Check if there must be RESET of colour
    public Boolean getStudent(int id) throws GPAException {
        if (database.containsKey(id)) {
            try {
                System.out.println(" ID:  " + id);
                System.out.println(" Jméno:  " + database.get(id).getSurname() + " " + database.get(id).getName());
                System.out.println(" Datum narození:  " + database.get(id).getDay() + ". " +
                        database.get(id).getMonth() + ". " + database.get(id).getYear());
                System.out.println(" Průměr:  " + database.get(id).getGpa());
            }
            catch (GPAException e) {
                System.out.println(" ID:  " + id);
                System.out.println(" Jméno:  " + database.get(id).getSurname() + " " + database.get(id).getName());
                System.out.println(" Datum narození:  " + database.get(id).getDay() + ". " +
                        database.get(id).getMonth() + ". " + database.get(id).getYear());
                System.out.println(" Průměr:  " + ConsoleColours.RED + "NEZADÁN");
            }
            return true;
        }
        else {
            System.out.println(ConsoleColours.RED + "Student neexistuje");
            return false;
        }
    }
}
