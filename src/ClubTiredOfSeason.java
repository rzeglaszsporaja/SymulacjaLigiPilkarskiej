public class ClubTiredOfSeason extends Club implements Updates{
    private final double tired_of_season;
    public ClubTiredOfSeason(double attack, double defence, double midfield, double form, double tired_of_season) {
        super(attack, defence, midfield, form);
        this.tired_of_season = tired_of_season;
    }

    public double getTired_of_season() {
        return tired_of_season;
    }

    @Override
    public double updateAttack(int value) {
        if(value == 3)
            return super.updateAttack(value)*tired_of_season;
        else
            return super.updateAttack(value);
    }

    @Override
    public double updateMidfield(int value) {
        if(value == 3)
            return super.updateMidfield(value)*tired_of_season;
        else
            return super.updateMidfield(value);
    }

    @Override
    public double updateDefence(int value) {
        if(value == 3)
            return super.updateDefence(value)*tired_of_season;
        else
            return super.updateDefence(value);
    }
}
