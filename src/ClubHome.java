public class ClubHome extends Club implements Updates{
    private final double home;
    public ClubHome(double attack, double defence, double midfield, double form, double home) {
        super(attack, defence, midfield, form);
        this.home = home;
    }

    public double getHome() {
        return home;
    }

    @Override
    public double updateAttack(int value) {
        if(value == 1)
            return super.updateAttack(value)*home;
        else
            return super.updateAttack(value);
    }
    @Override
    public double updateMidfield(int value) {
        if (value == 1)
            return super.updateMidfield(value)*home;
        else
            return super.updateMidfield(value);
    }
    @Override
    public double updateDefence(int value) {
        if(value == 1)
            return super.updateDefence(value)*home;
        else
            return super.updateDefence(value);
    }

    @Override
    public double resetAttack(int value){
        if(value == 1)
            return super.resetAttack(value)/home;
        else
            return super.resetAttack(value);
    }
    @Override
    public double resetMidfield(int value){
        if(value == 1)
            return super.resetMidfield(value)/home;
        else
            return super.resetMidfield(value);
    }
    @Override
    public double resetDefence(int value){
        if(value == 1)
            return super.resetDefence(value)/home;
        else
            return super.resetDefence(value);
    }
}
