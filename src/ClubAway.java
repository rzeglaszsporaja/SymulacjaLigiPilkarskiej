public class ClubAway extends Club implements Updates{
    private double away;
    public ClubAway(double attack, double defence, double midfield, double form, double away) {
        super(attack, defence, midfield, form);
        this.away = away;
    }

    public double getAway() {
        return away;
    }

    @Override
    public double updateAttack() {
        return super.updateAttack()*away;
    }

    @Override
    public double updateMidfield() {
        return super.updateMidfield()*away;
    }

    @Override
    public double updateDefence() {
        return super.updateDefence()*away;
    }
}
