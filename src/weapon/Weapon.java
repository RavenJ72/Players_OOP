package weapon;

public class Weapon implements Arming{

    protected double ability;

    protected Weapon(double ability) {
        setAbility(ability);
    }

    protected void setAbility(double ability) {
        if (ability < 1 | ability > 5) {
            throw new IllegalArgumentException("Incorrect value for ability");
        } else {
            this.ability = ability;
        }
    }


        @Override
    public double getAbility() {
        return ability;
    }
}
