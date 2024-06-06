import java.util.Map;

public class MatchSimulator {
    public static void simulateMatch(Club team1, Club team2, String team1Key, String team2Key, Map<String, Integer> results, Map<String, Integer> win_streaks, Map<String, Integer> losing_streaks) {
        int result = Match.match(team1.getAttack(), team2.getAttack(), team1.getMidfield(), team2.getMidfield(), team1.getDefence(), team2.getDefence(), team1.getForm(), team2.getForm());

        if (result == 1) {
            updateMap(results, team1Key, 3);
            updateMap(win_streaks, team1Key, 1);
            updateMap(losing_streaks, team2Key, 1);
        } else if (result == 2) {
            updateMap(results, team2Key, 3);
            updateMap(win_streaks, team2Key, 1);
            updateMap(losing_streaks, team1Key, 1);
        } else {
            updateMap(results, team1Key, 1);
            updateMap(results, team2Key, 1);
        }
    }
    private static void updateMap(Map<String, Integer> map, String key, int value) {
        map.put(key, map.getOrDefault(key, 0) + value);
    }
}
