/**
 * The Match class provides methods to simulate a football match between two teams.
 */
public class Match{

    /**
     * Generates a random integer within the specified range.
     *
     * @param min The minimum value (inclusive)
     * @param max The maximum value (inclusive)
     * @return A random integer between min and max (inclusive)
     */
    private static int random(int min, int max) {
        int range = (max-min)+1;
        int random = (int)((range*Math.random())+min);
        return random;
    }

    /**
     * Simulates a match between two teams based on their attack, midfield, and defence statistics.
     *
     * @param attack1    The attack value of the first team
     * @param attack2    The attack value of the second team
     * @param midfield1  The midfield value of the first team
     * @param midfield2  The midfield value of the second team
     * @param defence1   The defence value of the first team
     * @param defence2   The defence value of the second team
     * @return 1 if the first team wins, 2 if the second team wins, 3 if the match is a draw
     */
    public static int match(double attack1, double attack2, double midfield1, double midfield2, double defence1, double defence2)
    {
        int goal1 = 0;
        int goal2 = 0;
        int chances1 = (int)(random(0,20)*midfield1);
        int chances2 = (int)(random(0,20)*midfield2);
        for (int i = 0; i < chances1; i++) {
            double chanceOfScoring = (attack1/defence2)*50;
            if(random(0,100)<chanceOfScoring)
                goal1++;
        }
        for (int i = 0; i < chances2; i++) {
            double chanceOfScoring = (attack2/defence1)*50;
            if(random(0,100)<chanceOfScoring)
                goal2++;
        }
        if(goal1>goal2)
            return 1;
        if(goal2>goal1)
            return 2;
        else
            return 3;
    }
}
