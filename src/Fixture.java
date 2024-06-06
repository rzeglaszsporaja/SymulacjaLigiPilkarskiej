public class Fixture {
    private Club team1;
    private Club team2;
    private String team1Key;
    private String team2Key;
    public Fixture(Club team1, Club team2, String team1Key, String team2Key) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Key = team1Key;
        this.team2Key = team2Key;
    }

    public Club getTeam1() {
        return team1;
    }

    public Club getTeam2() {
        return team2;
    }

    public String getTeam1Key() {
        return team1Key;
    }

    public String getTeam2Key() {
        return team2Key;
    }
}
