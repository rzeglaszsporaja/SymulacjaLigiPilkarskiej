public class Match{
    private static int random(int min, int max) {
        int range = (max-min)+1;
        int random = (int)((range*Math.random())+min);
        return random;
    }
    public static int match(double attack1, double attack2, double midfield1, double midfield2, double defence1, double defence2, double form1, double form2)
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
//        System.out.println(goal1);
//        System.out.println(goal2);

        if(goal1>goal2)
            return 1;
        if(goal2>goal1)
            return 2;
        else
            return 3;
    }
}
