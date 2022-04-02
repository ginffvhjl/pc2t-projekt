import java.util.ArrayList;

public class Student {

    private String surname;
    private String name;

    private int day;
    private int month;
    private int year;

    ArrayList<Integer> grades = new ArrayList<>();

    private float gpa;

    public String getSurname() {
        return this.surname;
    }

    public String getName() {
        return this.name;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public float getGpa() throws GPAException {
        return this.gpa;
    }

    public Student(String surname, String name, int day, int month, int year, float gpa) {
        this.surname = surname;
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.gpa = gpa;
    }

    public void writeGPA(float gpa) {
        if (grades.size() == 0) {
            System.out.println(ConsoleColours.RED + "Suden nemá žádné známky" + ConsoleColours.RESET);
        }
        else {
            //gpa = grades.stream().mapToFloat(num->num).average().getAsFloat();
            float sum = 0;
            for (Integer num : grades) {
                sum += num;
            }
		gpa = sum / grades.size();
        }
    }
}
