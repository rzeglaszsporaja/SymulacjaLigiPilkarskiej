public class ClubTiredOfSeason extends Club implements Updates{
    private double tired_of_season;
    public ClubTiredOfSeason(double attack, double defence, double midfield, double form, double tired_of_season) {
        super(attack, defence, midfield, form);
        this.tired_of_season = tired_of_season;
    }

    public double getTired_of_season() {
        return tired_of_season;
    }

    @Override
    public double updateAttack() {
        return super.updateAttack()*tired_of_season;
    }

    @Override
    public double updateMidfield() {
        return super.updateMidfield()*tired_of_season;
    }

    @Override
    public double updateDefence() {
        return super.updateDefence()*tired_of_season;
    }
}
