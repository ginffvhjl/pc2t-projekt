package project.branch;

import project.ability.TechnicalAbility;

public class TechnicalStudent extends Student implements TechnicalBranch {
    TechnicalAbility technicalAbility = new TechnicalAbility();

    @Override
    public String getBranchName() {
        return "Technic";
    }

    public TechnicalStudent(int id, String surname, String name, int day, int month, int year) {
        super(id, surname, name, day, month, year);
    }

    public boolean isBornInLeapYear() {
        return this.technicalAbility.isLeapYear(this.getYear());
    }
}
