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
            return getAttack()*tired_of_season;
        if(value == 4)
            return super.updateAttack(value);
        else
            return getAttack();
    }

    @Override
    public double updateMidfield(int value) {
        if(value == 3)
            return getMidfield()*tired_of_season;
        if(value == 4)
            return super.updateMidfield(value);
        else
            return getMidfield();
    }

    @Override
    public double updateDefence(int value) {
        if(value == 3)
            return getDefence()*tired_of_season;
        if(value == 4)
            return super.updateDefence(value);
        else
            return getDefence();
    }
}
