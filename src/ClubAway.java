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
            return super.updateAttack(value)*away;
        else
            return super.updateAttack(value);
    }
    @Override
    public double updateMidfield(int value) {
        if(value == 2)
            return super.updateMidfield(value)*away;
        else
            return super.updateAttack(value);
    }
    @Override
    public double updateDefence(int value) {
        if(value == 2)
            return super.updateDefence(value)*away;
        else
            return super.updateAttack(value);
    }

    @Override
    public double resetAttack(int value){
        if(value == 2)
            return super.resetAttack(value)/away;
        else
            return super.resetAttack(value);
    }
    @Override
    public double resetMidfield(int value){
        if(value == 2)
            return super.resetMidfield(value)/away;
        else
            return super.resetMidfield(value);
    }
    @Override
    public double resetDefence(int value){
        if(value == 2)
            return super.resetDefence(value)/away;
        else
            return super.resetDefence(value);
    }
}
