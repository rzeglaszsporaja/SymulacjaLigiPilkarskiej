/**
 * The ClubTiredOfSeason class extends the Club class and implements the Updates interface.
 * It represents a football club that experiences a decrease in performance due to tiredness
 * as the season progresses.
 */
public class ClubTiredOfSeason extends Club implements Updates{
    private final double tired_of_season;

    /**
     * Constructs a ClubTiredOfSeason with the specified attributes.
     *
     * @param attack The attack value of the club
     * @param defence The defence value of the club
     * @param midfield The midfield value of the club
     * @param form The form value of the club
     * @param tired_of_season The factor by which the club's performance is reduced due to tiredness
     */
    public ClubTiredOfSeason(double attack, double defence, double midfield, double form, double tired_of_season) {
        super(attack, defence, midfield, form);
        this.tired_of_season = tired_of_season;
    }

    /**
     * Gets the tired_of_season factor.
     *
     * @return The tired_of_season factor
     */
    public double getTired_of_season() {
        return tired_of_season;
    }

    /**
     * Updates the attack value based on the given parameter, considering the tired_of_season factor.
     *
     * @param value The value used to update the attack attribute
     * @return The updated attack value
     */
    @Override
    public double updateAttack(int value) {
        if(value == 2 || value == 1)
            return getAttack()*tired_of_season;
        if(value == 4)
            return super.updateAttack(value);
        else
            return getAttack();
    }

    /**
     * Updates the midfield value based on the given parameter, considering the tired_of_season factor.
     *
     * @param value The value used to update the midfield attribute
     * @return The updated midfield value
     */
    @Override
    public double updateMidfield(int value) {
        if(value == 2 || value == 1)
            return getMidfield()*tired_of_season;
        if(value == 4)
            return super.updateMidfield(value);
        else
            return getMidfield();
    }

    /**
     * Updates the defence value based on the given parameter, considering the tired_of_season factor.
     *
     * @param value The value used to update the defence attribute
     * @return The updated defence value
     */
    @Override
    public double updateDefence(int value) {
        if(value == 2 || value == 1)
            return getDefence()*tired_of_season;
        if(value == 4)
            return super.updateDefence(value);
        else
            return getDefence();
    }
}
