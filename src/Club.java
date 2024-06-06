public class Club {
    private double attack;
    private double defence;
    private double midfield;
    private double form;

    public Club(double attack, double defence, double midfield, double form){
        this.attack = attack;
        this.defence = defence;
        this.midfield = midfield;
        this.form = form;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public void setDefence(double defence) {
        this.defence = defence;
    }

    public void setMidfield(double midfield) {
        this.midfield = midfield;
    }

    public void setForm(double form) {
        this.form = form;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefence() {
        return defence;
    }

    public double getMidfield() {
        return midfield;
    }

    public double getForm() {
        return form;
    }
}
