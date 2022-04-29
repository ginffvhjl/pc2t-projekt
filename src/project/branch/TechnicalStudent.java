package project.branch;

import project.ability.TechnicalAbility;
import project.branch.Student;
import project.branch.TechnicalBranch;

public class TechnicalStudent extends Student implements TechnicalBranch {
    TechnicalAbility technicalAbility = new TechnicalAbility();

    public TechnicalStudent(String surname, String name, int day, int month, int year) {
        super(surname, name, day, month, year);
    }

    public boolean isBornInLeapYear() {
        return this.technicalAbility.isLeapYear(this.getYear());
    }
}
