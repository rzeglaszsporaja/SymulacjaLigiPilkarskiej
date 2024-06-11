/**
 * The Updates interface defines methods for updating and resetting the performance metrics
 * of a football club's different attributes such as attack, midfield, and defence.
 */
public interface Updates {
    /**
     * Updates the attack value based on the given parameter.
     *
     * @param value The value used to update the attack attribute
     * @return The updated attack value
     */
    public double updateAttack(int value);

    /**
     * Updates the midfield value based on the given parameter.
     *
     * @param value The value used to update the midfield attribute
     * @return The updated midfield value
     */
    public double updateMidfield(int value);

    /**
     * Updates the defence value based on the given parameter.
     *
     * @param value The value used to update the defence attribute
     * @return The updated defence value
     */
    public double updateDefence(int value);

    /**
     * Resets the attack value based on the given parameter.
     *
     * @param value The value used to reset the attack attribute
     * @return The reset attack value
     */
    public double resetAttack(int value);

    /**
     * Resets the midfield value based on the given parameter.
     *
     * @param value The value used to reset the midfield attribute
     * @return The reset midfield value
     */
    public double resetMidfield(int value);

    /**
     * Resets the defence value based on the given parameter.
     *
     * @param value The value used to reset the defence attribute
     * @return The reset defence value
     */
    public double resetDefence(int value);
}
