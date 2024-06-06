public class ClubMotivation extends Club implements Updates{
    private double motivation;
    public ClubMotivation(double attack, double defence, double midfield, double form, double motivation) {
        super(attack, defence, midfield, form);
        this.motivation = motivation;
    }

    public double getMotivation() {
        return motivation;
    }

    @Override
    public double updateAttack() {
        return super.updateAttack()*motivation;
    }

    @Override
    public double updateMidfield() {
        return super.updateMidfield()*motivation;
    }

    @Override
    public double updateDefence() {
        return super.updateDefence()*motivation;
    }
}
