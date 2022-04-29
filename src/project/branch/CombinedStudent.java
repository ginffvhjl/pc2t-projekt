package project.branch;

import project.ability.HumaneAbility;
import project.ability.TechnicalAbility;
import project.ability.ZodiacSign;

public class CombinedStudent extends Student implements TechnicalBranch, HumaneBranch {
    HumaneAbility humaneAbility = new HumaneAbility();
    TechnicalAbility technicalAbility = new TechnicalAbility();

    public CombinedStudent(int id, String surname, String name, int day, int month, int year) {
        super(id, surname, name, day, month, year);
    }

    public ZodiacSign getZodiacSign() {
        return this.humaneAbility.getZodiacSign(this.getYear(), this.getMonth(), this.getDay());
    }

    public boolean isBornInLeapYear() {
        return this.technicalAbility.isLeapYear(this.getYear());
    }
}
