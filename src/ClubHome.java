public class ClubHome extends Club implements Updates{
    private double home;
    public ClubHome(double attack, double defence, double midfield, double form, double home) {
        super(attack, defence, midfield, form);
        this.home = home;
    }

    public double getHome() {
        return home;
    }

    @Override
    public double updateAttack() {
        return super.updateAttack()*home;
    }

    @Override
    public double updateMidfield() {
        return super.updateMidfield()*home;
    }

    @Override
    public double updateDefence() {
        return super.updateDefence()*home;
    }
}
