/**
 * The Fixture class represents a match fixture between two football clubs.
 * It holds references to the two participating clubs and their corresponding keys.
 */
public class Fixture {
    private Club team1;
    private Club team2;
    private String team1Key;
    private String team2Key;

    /**
     * Constructs a Fixture with the specified teams and their keys.
     *
     * @param team1 The first team participating in the fixture
     * @param team2 The second team participating in the fixture
     * @param team1Key The key associated with the first team
     * @param team2Key The key associated with the second team
     */
    public Fixture(Club team1, Club team2, String team1Key, String team2Key) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Key = team1Key;
        this.team2Key = team2Key;
    }

    /**
     * Returns the first team participating in the fixture.
     *
     * @return The first team
     */
    public Club getTeam1() {
        return team1;
    }

    /**
     * Returns the second team participating in the fixture.
     *
     * @return The second team
     */
    public Club getTeam2() {
        return team2;
    }

    /**
     * Returns the key associated with the first team.
     *
     * @return The key of the first team
     */
    public String getTeam1Key() {
        return team1Key;
    }

    /**
     * Returns the key associated with the second team.
     *
     * @return The key of the second team
     */
    public String getTeam2Key() {
        return team2Key;
    }
}

