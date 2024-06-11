/**
 * The ClubAway class extends the Club class and implements the Updates interface.
 * It represents a football club whose performance is affected when playing away games.
 */
public class ClubAway extends Club implements Updates{
    private final double away;

    /**
     * Constructs a ClubAway with the specified attributes.
     *
     * @param attack The attack value of the club
     * @param defence The defence value of the club
     * @param midfield The midfield value of the club
     * @param form The form value of the club
     * @param away The factor by which the club's performance is affected when playing away games
     */
    public ClubAway(double attack, double defence, double midfield, double form, double away) {
        super(attack, defence, midfield, form);
        this.away = away;
    }

    /**
     * Gets the away factor.
     *
     * @return The away factor
     */
    public double getAway() {
        return away;
    }

    /**
     * Updates the attack value based on the given parameter, considering the away factor.
     *
     * @param value The value used to update the attack attribute
     * @return The updated attack value
     */
    @Override
    public double updateAttack(int value) {
        if(value == 2)
            return getAttack()*away;
        if(value == 4)
            return super.updateAttack(value);
        else
            return getAttack();
    }

    /**
     * Updates the midfield value based on the given parameter, considering the away factor.
     *
     * @param value The value used to update the midfield attribute
     * @return The updated midfield value
     */
    @Override
    public double updateMidfield(int value) {
        if(value == 2)
            return getMidfield()*away;
        if(value == 4)
            return super.updateMidfield(value);
        else
            return getMidfield();
    }

    /**
     * Updates the defence value based on the given parameter, considering the away factor.
     *
     * @param value The value used to update the defence attribute
     * @return The updated defence value
     */
    @Override
    public double updateDefence(int value) {
        if(value == 2)
            return getDefence()*away;
        if(value == 4)
            return super.updateDefence(value);
        else
            return getDefence();
    }

    /**
     * Resets the attack value based on the given parameter, considering the away factor.
     *
     * @param value The value used to reset the attack attribute
     * @return The reset attack value
     */
    @Override
    public double resetAttack(int value){
        if(value == 2)
            return getAttack()/away;
        if(value == 4)
            return super.resetAttack(value);
        else
            return getAttack();
    }

    /**
     * Resets the midfield value based on the given parameter, considering the away factor.
     *
     * @param value The value used to reset the midfield attribute
     * @return The reset midfield value
     */
    @Override
    public double resetMidfield(int value){
        if(value == 2)
            return getMidfield()/away;
        if(value == 4)
            return super.resetMidfield(value);
        else
            return getMidfield();
    }

    /**
     * Resets the defence value based on the given parameter, considering the away factor.
     *
     * @param value The value used to reset the defence attribute
     * @return The reset defence value
     */
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
