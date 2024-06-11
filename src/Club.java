/**
 * The Club class represents a football club with attributes such as attack, defence, midfield, and form.
 * It implements the Updates interface to allow for updating and resetting of its attributes.
 */
public class Club implements Updates{
    private double attack;
    private double defence;
    private double midfield;
    private double form;

    /**
     * Constructs a Club with the specified attributes.
     *
     * @param attack The attack value of the club
     * @param defence The defence value of the club
     * @param midfield The midfield value of the club
     * @param form The form value of the club
     */
    public Club(double attack, double defence, double midfield, double form){
        this.attack = attack;
        this.defence = defence;
        this.midfield = midfield;
        this.form = form;
    }

    /**
     * Sets the attack value of the club.
     *
     * @param attack The new attack value
     */
    public void setAttack(double attack) {
        this.attack = attack;
    }

    /**
     * Sets the defence value of the club.
     *
     * @param defence The new defence value
     */
    public void setDefence(double defence) {
        this.defence = defence;
    }

    /**
     * Sets the midfield value of the club.
     *
     * @param midfield The new midfield value
     */
    public void setMidfield(double midfield) {
        this.midfield = midfield;
    }

    /**
     * Sets the form value of the club.
     *
     * @param form The new form value
     */
    public void setForm(double form) {
        this.form = form;
    }

    /**
     * Gets the attack value of the club.
     *
     * @return The attack value
     */
    public double getAttack() {
        return attack;
    }

    /**
     * Gets the defence value of the club.
     *
     * @return The defence value
     */
    public double getDefence() {
        return defence;
    }

    /**
     * Gets the midfield value of the club.
     *
     * @return The midfield value
     */
    public double getMidfield() {
        return midfield;
    }

    /**
     * Gets the form value of the club.
     *
     * @return The form value
     */
    public double getForm() {
        return form;
    }

    /**
     * Updates the attack value of the club, considering the current form.
     *
     * @param value Not used in this method
     * @return The updated attack value
     */
    public double updateAttack(int value) {
        return attack*form;
    }

    /**
     * Updates the midfield value of the club, considering the current form.
     *
     * @param value Not used in this method
     * @return The updated midfield value
     */
    public double updateMidfield(int value) {
        return midfield*form;
    }

    /**
     * Updates the defence value of the club, considering the current form.
     *
     * @param value Not used in this method
     * @return The updated defence value
     */
    public double updateDefence(int value) {
        return defence*form;
    }

    /**
     * Resets the attack value of the club, considering the current form.
     *
     * @param value Not used in this method
     * @return The reset attack value
     */
    public double resetAttack(int value) {
        return attack/form;
    }

    /**
     * Resets the midfield value of the club, considering the current form.
     *
     * @param value Not used in this method
     * @return The reset midfield value
     */
    public double resetMidfield(int value) {
        return midfield/form;
    }

    /**
     * Resets the defence value of the club, considering the current form.
     *
     * @param value Not used in this method
     * @return The reset defence value
     */
    public double resetDefence(int value) {
        return defence/form;
    }

}
