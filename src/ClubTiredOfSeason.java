public class ClubTiredOfSeason extends Club{
    private double tired_of_season;
    public ClubTiredOfSeason(double attack, double defence, double midfield, double form, double tired_of_season) {
        super(attack, defence, midfield, form);
    }

    public double getTired_of_season() {
        return tired_of_season;
    }
}
