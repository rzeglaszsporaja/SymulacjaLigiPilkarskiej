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
            return getAttack()*home;
        if(value == 4)
            return super.updateAttack(value);
        else
            return getAttack();
    }
    @Override
    public double updateMidfield(int value) {
        if(value == 1)
            return getMidfield()*home;
        if(value == 4)
            return super.updateMidfield(value);
        else
            return getMidfield();
    }
    @Override
    public double updateDefence(int value) {
        if(value == 1)
            return getDefence()*home;
        if(value == 4)
            return super.updateDefence(value);
        else
            return getDefence();
    }

    @Override
    public double resetAttack(int value){
        if(value == 1)
            return getAttack()/home;
        if(value == 4)
            return super.resetAttack(value);
        else
            return getAttack();
    }
    @Override
    public double resetMidfield(int value){
        if(value == 1)
            return getMidfield()/home;
        if(value == 4)
            return super.resetMidfield(value);
        else
            return getMidfield();
    }
    @Override
    public double resetDefence(int value){
        if(value == 1)
            return getDefence()/home;
        if(value == 4)
            return super.resetDefence(value);
        else
            return getDefence();
    }
}
