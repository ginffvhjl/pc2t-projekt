public class Student {

    private String surname;
    private String name;

    private int day;
    private int month;
    private int year;

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
        if (this.gpa == 0) {
            throw new GPAException();
        }
        else {
            return this.gpa;
        }
    }

    public Student(String surname, String name, int day, int month, int year, float gpa) {
        this.surname = surname;
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.gpa = gpa;
    }

    public void writeGPA(float gpa) throws GPAException {
        if (gpa >= 1 && gpa <= 5) {
            this.gpa = gpa;
        }
        else {
            throw new GPAException(gpa);
        }
    }
}
