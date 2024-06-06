public class Injury{
    public static void injuryDefender(Club team){
        team.setDefence(team.getDefence()*0.9);
    }
    public static void injuryMidfielder(Club team){
        team.setMidfield(team.getMidfield()*0.9);
    }
    public static void injuryStriker(Club team){
        team.setAttack(team.getAttack()*0.9);
    }

    public static void recoveryDefender(Club team){
        team.setDefence(team.getDefence()/0.9);
    }
    public static void recoveryMidfielder(Club team){
        team.setMidfield(team.getMidfield()/0.9);
    }
    public static void recoveryStriker(Club team){
        team.setAttack(team.getAttack()/0.9);
    }
}
