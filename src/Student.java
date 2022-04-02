public class Student {

    private int day;
    private int month;
    private int year;

    private float gpa;

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

    public Student(int day, int month, int year, float gpa) {
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
