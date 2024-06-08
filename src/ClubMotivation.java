public class ClubMotivation extends Club implements Updates{
    private final double motivation;
    public ClubMotivation(double attack, double defence, double midfield, double form, double motivation) {
        super(attack, defence, midfield, form);
        this.motivation = motivation;
    }

    public double getMotivation() {
        return motivation;
    }

    @Override
    public double updateAttack(int value) {
        if(value == 3)
            return getAttack()*motivation;
        if(value == 4)
            return super.updateAttack(value);
        else
            return getAttack();
    }

    @Override
    public double updateMidfield(int value) {
        if(value == 3)
            return getMidfield()*motivation;
        if(value == 4)
            return super.updateMidfield(value);
        else
            return getMidfield();
    }

    @Override
    public double updateDefence(int value) {
        if(value == 3)
            return getDefence()*motivation;
        if(value == 4)
            return super.updateDefence(value);
        else
            return getDefence();
    }
}
