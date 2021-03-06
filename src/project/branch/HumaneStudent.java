package project.branch;

import project.ability.HumaneAbility;
import project.ability.ZodiacSign;

public class HumaneStudent extends Student implements HumaneBranch {
    HumaneAbility humaneAbility = new HumaneAbility();

    @Override
    public String getBranchName() {
        return "Humane";
    }

    public HumaneStudent(int id, String surname, String name, int day, int month, int year) {
        super(id, surname, name, day, month, year);
    }

    public ZodiacSign getZodiacSign() {
        return this.humaneAbility.getZodiacSign(this.getYear(), this.getMonth(), this.getDay());
    }
}
