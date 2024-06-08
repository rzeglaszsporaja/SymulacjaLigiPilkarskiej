public class ClubAway extends Club implements Updates{
    private final double away;
    public ClubAway(double attack, double defence, double midfield, double form, double away) {
        super(attack, defence, midfield, form);
        this.away = away;
    }

    public double getAway() {
        return away;
    }

    @Override
    public double updateAttack(int value) {
        if(value == 2)
            return getAttack()*away;
        if(value == 4)
            return super.updateAttack(value);
        else
            return getAttack();
    }
    @Override
    public double updateMidfield(int value) {
        if(value == 2)
            return getMidfield()*away;
        if(value == 4)
            return super.updateMidfield(value);
        else
            return getMidfield();
    }
    @Override
    public double updateDefence(int value) {
        if(value == 2)
            return getDefence()*away;
        if(value == 4)
            return super.updateDefence(value);
        else
            return getDefence();
    }

    @Override
    public double resetAttack(int value){
        if(value == 2)
            return getAttack()/away;
        if(value == 4)
            return super.resetAttack(value);
        else
            return getAttack();
    }
    @Override
    public double resetMidfield(int value){
        if(value == 2)
            return getMidfield()/away;
        if(value == 4)
            return super.resetMidfield(value);
        else
            return getMidfield();
    }
    @Override
    public double resetDefence(int value){
        if(value == 2)
            return getDefence()/away;
        if(value == 4)
            return super.resetDefence(value);
        else
            return getDefence();
    }
}
