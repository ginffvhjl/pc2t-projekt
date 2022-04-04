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

    public float getGpa() {
        if (grades.size() == 0) {
            return 0;
        }
        else {
            //gpa = grades.stream().mapToFloat(num->num).average().getAsFloat();
            float sum = 0;
            for (Integer num : grades) {
                sum += num;
            }
		    gpa = sum / grades.size();
            return gpa;
        }
    }

    public Student(String surname, String name, int day, int month, int year, ArrayList<Integer> grades, float gpa) {
        this.surname = surname;
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.grades = grades;
        this.gpa = gpa;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }
}
