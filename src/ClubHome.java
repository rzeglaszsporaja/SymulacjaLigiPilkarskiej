public class ClubHome extends Club{
    private double home;
    public ClubHome(double attack, double defence, double midfield, double form, double home) {
        super(attack, defence, midfield, form);
    }

    public double getHome() {
        return home;
    }
}
