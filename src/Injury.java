/**
 * The Injury class provides methods to simulate injuries and recoveries of players in a football team.
 */
public class Injury{
    /**
     * Reduces the defence value of the team's defenders due to an injury.
     *
     * @param team The team whose defender is injured
     */
    public static void injuryDefender(Club team){
        team.setDefence(team.getDefence()*0.9);
    }

    /**
     * Reduces the midfield value of the team's midfielders due to an injury.
     *
     * @param team The team whose midfielder is injured
     */
    public static void injuryMidfielder(Club team){
        team.setMidfield(team.getMidfield()*0.9);
    }

    /**
     * Reduces the attack value of the team's strikers due to an injury.
     *
     * @param team The team whose striker is injured
     */
    public static void injuryStriker(Club team){
        team.setAttack(team.getAttack()*0.9);
    }

    /**
     * Restores the defence value of the team's defenders after recovery from an injury.
     *
     * @param team The team whose defender has recovered
     */
    public static void recoveryDefender(Club team){
        team.setDefence(team.getDefence()/0.9);
    }

    /**
     * Restores the midfield value of the team's midfielders after recovery from an injury.
     *
     * @param team The team whose midfielder has recovered
     */
    public static void recoveryMidfielder(Club team){
        team.setMidfield(team.getMidfield()/0.9);
    }

    /**
     * Restores the attack value of the team's strikers after recovery from an injury.
     *
     * @param team The team whose striker has recovered
     */
    public static void recoveryStriker(Club team){
        team.setAttack(team.getAttack()/0.9);
    }
}


