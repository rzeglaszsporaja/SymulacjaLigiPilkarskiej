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
            return super.updateAttack(value)*motivation;
        else
            return super.updateAttack(value);
    }

    @Override
    public double updateMidfield(int value) {
        if(value == 3)
            return super.updateMidfield(value)*motivation;
        else
            return super.updateMidfield(value);
    }

    @Override
    public double updateDefence(int value) {
        if(value == 3)
            return super.updateDefence(value)*motivation;
        else
            return super.updateDefence(value);
    }
}
