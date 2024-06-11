import java.util.Map;

/**
 * The MatchSimulator class provides functionality to simulate a football match between two teams
 * and update their respective statistics based on the match outcome.
 */
public class MatchSimulator {
    /**
     * Simulates a match between two teams and updates their respective statistics.
     *
     * @param team1          The first team
     * @param team2          The second team
     * @param team1Key       The key identifying the first team in the maps
     * @param team2Key       The key identifying the second team in the maps
     * @param results        Map containing the total points for each team
     * @param win_streaks    Map containing the win streaks for each team
     * @param losing_streaks Map containing the losing streaks for each team
     * @param draws          Map containing the draw streaks for each team
     */
    public static void simulateMatch(Club team1, Club team2, String team1Key, String team2Key, Map<String, Integer> results, Map<String, Integer> win_streaks, Map<String, Integer> losing_streaks, Map<String, Integer> draws){
        int result = Match.match(team1.getAttack(), team2.getAttack(), team1.getMidfield(), team2.getMidfield(), team1.getDefence(), team2.getDefence());

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
            updateMap(draws, team1Key, 1);
            updateMap(draws, team2Key, 1);
        }
    }

    /**
     * Updates the given map by incrementing the value associated with the specified key.
     * If the key does not exist, it initializes it with the specified value.
     *
     * @param map   The map to update
     * @param key   The key in the map
     * @param value The value to add to the existing value associated with the key
     */
    private static void updateMap(Map<String, Integer> map, String key, int value) {
        map.put(key, map.getOrDefault(key, 0) + value);
    }
}
