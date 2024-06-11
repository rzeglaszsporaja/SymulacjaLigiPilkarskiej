/**
 * The ClubMotivation class extends the Club class and implements the Updates interface.
 * It represents a football club whose performance is affected by motivation.
 */
public class ClubMotivation extends Club implements Updates{
    private final double motivation;

    /**
     * Constructs a ClubMotivation with the specified attributes.
     *
     * @param attack The attack value of the club
     * @param defence The defence value of the club
     * @param midfield The midfield value of the club
     * @param form The form value of the club
     * @param motivation The factor by which the club's performance is affected by motivation
     */
    public ClubMotivation(double attack, double defence, double midfield, double form, double motivation) {
        super(attack, defence, midfield, form);
        this.motivation = motivation;
    }

    /**
     * Gets the motivation factor.
     *
     * @return The motivation factor
     */
    public double getMotivation() {
        return motivation;
    }

    /**
     * Updates the attack value based on the given parameter, considering the motivation factor.
     *
     * @param value The value used to update the attack attribute
     * @return The updated attack value
     */
    @Override
    public double updateAttack(int value) {
        if(value == 3)
            return getAttack()*motivation;
        if(value == 4)
            return super.updateAttack(value);
        else
            return getAttack();
    }

    /**
     * Updates the midfield value based on the given parameter, considering the motivation factor.
     *
     * @param value The value used to update the midfield attribute
     * @return The updated midfield value
     */
    @Override
    public double updateMidfield(int value) {
        if(value == 3)
            return getMidfield()*motivation;
        if(value == 4)
            return super.updateMidfield(value);
        else
            return getMidfield();
    }

    /**
     * Updates the defence value based on the given parameter, considering the motivation factor.
     *
     * @param value The value used to update the defence attribute
     * @return The updated defence value
     */
    @Override
    public double updateDefence(int value) {
        if(value == 3)
            return getDefence()*motivation;
        if(value == 4)
            return super.updateDefence(value);
        else
            return getDefence();
    }
}
