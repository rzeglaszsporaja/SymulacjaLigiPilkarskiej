import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {

        // Zmienne potrzebne do wybranych funkcji w programie

        double chances_of_injury = 0.1;
        int number_of_seasons = 1;
        int home = 1;
        int away = 2;
        int motivated= 3;
        int hasForm = 4;
        int end_of_season=0;
        boolean already_done = false;

        // Uworzenie obiektow (klubow pilkarskich)

        ClubAway Rakow_Czestochowa = new ClubAway(0.58, 0.71, 0.59, 1, 0.9);
        ClubHome AS_Roma = new ClubHome(0.78, 0.75, 0.69, 1, 1.25);
        Club FC_Barcelona = new Club(0.92, 0.81, 0.88, 1);
        ClubMotivation Real_Madrid = new ClubMotivation(0.93, 0.89, 0.96, 1, 1.07);
        Club Slask_Wroclaw = new Club(0.61, 0.49, 0.56, 1);
        ClubTiredOfSeason Borussia_Dortmund = new ClubTiredOfSeason(0.81, 0.76, 0.79, 1, 0.97);

        // Uworzenie tablicy potrzebnej do zapisywania wynikow spotkan

        Map<String, Integer>results = new TreeMap<>();
        fillingMaps(results);

        // Utworzenie tablicy potrzebnej do zapisywania ilosci wygranych spotkan

        Map<String, Integer>win_streaks = new TreeMap<>();
        fillingMaps(win_streaks);

        // Utworzenie tablicy potrzebnej do zapisywania ilosci przegranych spotkan

        Map<String, Integer>losing_streaks = new TreeMap<>();
        fillingMaps(losing_streaks);

        //Utworzenie tablicy potrzebnej do zapisywania ilosci zremisowanych spotkac

        Map<String, Integer>draws = new TreeMap<>();
        fillingMaps(draws);

        // Skroty nazw klubow

        String RCZ = "Rakow_Czestochowa";
        String ASR = "AS_Roma";
        String FCB = "FC_Barcelona";
        String RM = "Real_Madrid";
        String SW = "Slask_Wroclaw";
        String BVB = "Borussia_Dortmund";

        // Lista spotkan ktore moga sie odbyc w trakcie sezonu

        List <Fixture> fixtures = new ArrayList<>();

        // Dodanie do listy mozliwych meczow do rozegrania

        fixtures.add(new Fixture(Rakow_Czestochowa, AS_Roma, RCZ, ASR));
        fixtures.add(new Fixture(Rakow_Czestochowa, FC_Barcelona, RCZ, FCB));
        fixtures.add(new Fixture(Rakow_Czestochowa, Real_Madrid, RCZ, RM));
        fixtures.add(new Fixture(Rakow_Czestochowa, Slask_Wroclaw, RCZ, SW));
        fixtures.add(new Fixture(Rakow_Czestochowa, Borussia_Dortmund, RCZ, BVB));

        fixtures.add(new Fixture(AS_Roma, Rakow_Czestochowa, ASR, RCZ));
        fixtures.add(new Fixture(AS_Roma, FC_Barcelona, ASR, FCB));
        fixtures.add(new Fixture(AS_Roma, Real_Madrid, ASR, RM));
        fixtures.add(new Fixture(AS_Roma, Slask_Wroclaw, ASR, SW));
        fixtures.add(new Fixture(AS_Roma, Borussia_Dortmund, ASR, BVB));

        fixtures.add(new Fixture(FC_Barcelona, Rakow_Czestochowa, FCB, RCZ));
        fixtures.add(new Fixture(FC_Barcelona, AS_Roma, FCB, ASR));
        fixtures.add(new Fixture(FC_Barcelona, Real_Madrid, FCB, RM));
        fixtures.add(new Fixture(FC_Barcelona, Slask_Wroclaw, FCB, SW));
        fixtures.add(new Fixture(FC_Barcelona, Borussia_Dortmund, FCB, BVB));

        fixtures.add(new Fixture(Real_Madrid, Rakow_Czestochowa, RM, RCZ));
        fixtures.add(new Fixture(Real_Madrid, AS_Roma, RM, ASR));
        fixtures.add(new Fixture(Real_Madrid, FC_Barcelona, RM, FCB));
        fixtures.add(new Fixture(Real_Madrid, Slask_Wroclaw, RM, SW));
        fixtures.add(new Fixture(Real_Madrid, Borussia_Dortmund, RM, BVB));

        fixtures.add(new Fixture(Slask_Wroclaw, Rakow_Czestochowa, SW, RCZ));
        fixtures.add(new Fixture(Slask_Wroclaw, AS_Roma, SW, ASR));
        fixtures.add(new Fixture(Slask_Wroclaw, FC_Barcelona, SW, FCB));
        fixtures.add(new Fixture(Slask_Wroclaw, Real_Madrid, SW, RM));
        fixtures.add(new Fixture(Slask_Wroclaw, Borussia_Dortmund, SW, BVB));

        fixtures.add(new Fixture(Borussia_Dortmund, Rakow_Czestochowa, BVB, RCZ));
        fixtures.add(new Fixture(Borussia_Dortmund, AS_Roma, BVB, ASR));
        fixtures.add(new Fixture(Borussia_Dortmund, FC_Barcelona, BVB, FCB));
        fixtures.add(new Fixture(Borussia_Dortmund, Real_Madrid, BVB, RM));
        fixtures.add(new Fixture(Borussia_Dortmund, Slask_Wroclaw, BVB, SW));

        // Przeprowadzenie tylu sezonow ile wybral uzytkownik

        Scanner scan = new Scanner(System.in);
        System.out.println("Select number of seasons: ");
        String numberScanner = scan.nextLine();
        number_of_seasons = Integer.valueOf(numberScanner);


        for (int i = 0; i < number_of_seasons; i++) {

            // Lista spotkan zostaje wymieszana aby kolejnosc rozgrywania meczow byla przypadkowa

            Collections.shuffle(fixtures);

            // Petla w ktorej odbeda sie wszystkie mecze w sezonie

            for (Fixture game : fixtures) {

                //Losowanie kontuzji dla pary druzyn ktore beda graly spotkanie

                int[] number_of_injuries = new int[6];
                gettingInjuries(game, chances_of_injury, number_of_injuries);

                // Jesli jest koncowka sezonu to przypisanie cech dla wybranych zespolow

                already_done = uniqueFeaturesMotivation(game, fixtures, end_of_season, motivated, already_done);

                // Zwieszkanie/zmniejszanie wspolczynnikow jesli druzyna gra u siebie/na wyjezdzie

                uniqueFeaturesHomeAway(game, home, away);

                // Sprawdzanie aktualnej formy i przyznawanie odpowiednich wspolczynnikow

                checkingStreaks(game.getTeam1Key(), win_streaks, losing_streaks, draws);
                checkingStreaks(game.getTeam2Key(), win_streaks, losing_streaks, draws);
                hasStreak(game, game.getTeam1Key(), game.getTeam2Key(), win_streaks, losing_streaks, draws);
                formUpdater(game, hasForm);

                // Symulacja meczu miedzy 2 druzynami

                MatchSimulator.simulateMatch(game.getTeam1(), game.getTeam2(), game.getTeam1Key(), game.getTeam2Key(), results, win_streaks, losing_streaks, draws);

                //Resetowanie formy
                formReseter(game, hasForm);

                // Resetowanie wspolczynnikow po meczu u siebie/na wyjezdzie

                resetUniqueFeaturesHomeAway(game, home, away);

                //Resetowanie wspolczynnikow klubow jesli wystapila kontuzja

                recoveringFromInjuries(game, number_of_injuries);

                // Zapisanie do zmiennej ile meczow sie odbylo

                end_of_season++;
            }
        }

        // Wypisanie wynikow
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                                 |");
        System.out.println("|                                        SIMULATION RESULTS:                                      |");
        System.out.println("|                                          (for "+number_of_seasons+" seasons)                                        |");
        System.out.println("|                                                                                                 |");
        System.out.println("|  AS_Roma   Borussia_Dortmund   FC_Barcelona    Rakow_Czestochowa   Real_Madrid   Slask_Wroclaw  |");
        System.out.println("|    "+results.get(ASR)+"             "+results.get(BVB)+"                "+results.get(FCB)+"                 "+results.get(RCZ)+"              "+results.get(RM)+"               "+results.get(SW)+"        |");
        System.out.println("|                                                                                                 |");
        System.out.println("--------------------------------------------------------------------------------------------------");

        //Zapis do pliku
        saveResultsToCSV(results, win_streaks, losing_streaks, draws);
    }

    private static void saveResultsToCSV(Map<String, Integer> results, Map<String, Integer> win_streaks, Map<String, Integer> losing_streaks, Map<String, Integer> draws) {
        String resultsCSV = "simulation_results.csv";
        try (PrintWriter writer = new PrintWriter(new FileWriter(resultsCSV))) {
            writer.println("Team,Results");
            for (String team : results.keySet()) {
                writer.println(team + "," + results.get(team));
            }
            System.out.println("The results have been saved to a file " + resultsCSV);
        } catch (IOException e) {
            System.err.println("Error writing results to file: " + e.getMessage());
        }
    }

    private static int[] gettingInjuries(Fixture game, double chances_of_injury, int[] number_of_injuries){
        if (Math.random() < chances_of_injury) {
            Injury.injuryDefender(game.getTeam1());
            number_of_injuries[0]++;
        }
        if (Math.random() < chances_of_injury) {
            Injury.injuryDefender(game.getTeam2());
            number_of_injuries[1]++;
        }
        if (Math.random() < chances_of_injury) {
            Injury.injuryMidfielder(game.getTeam1());
            number_of_injuries[2]++;
        }
        if (Math.random() < chances_of_injury) {
            Injury.injuryMidfielder(game.getTeam2());
            number_of_injuries[3]++;
        }
        if (Math.random() < chances_of_injury) {
            Injury.injuryStriker(game.getTeam1());
            number_of_injuries[4]++;
        }
        if (Math.random() < chances_of_injury) {
            Injury.injuryStriker(game.getTeam2());
            number_of_injuries[5]++;
        }
        return number_of_injuries;
    }

    private static void recoveringFromInjuries(Fixture game, int[] number_of_injuries){
        if(number_of_injuries[0] == 1)
            Injury.recoveryDefender(game.getTeam1());
        if(number_of_injuries[1] == 1)
            Injury.recoveryDefender(game.getTeam2());
        if(number_of_injuries[2] == 1)
            Injury.recoveryMidfielder(game.getTeam1());
        if(number_of_injuries[3] == 1)
            Injury.recoveryMidfielder(game.getTeam2());
        if(number_of_injuries[4] == 1)
            Injury.recoveryStriker(game.getTeam1());
        if(number_of_injuries[5] == 1)
            Injury.recoveryStriker(game.getTeam2());
    }
    private static void uniqueFeaturesHomeAway(Fixture game, int home, int away){
        game.getTeam1().setAttack(game.getTeam1().updateAttack(home));
        game.getTeam2().setAttack(game.getTeam2().updateAttack(away));
        game.getTeam1().setMidfield(game.getTeam1().updateMidfield(home));
        game.getTeam2().setMidfield(game.getTeam2().updateMidfield(away));
        game.getTeam1().setDefence(game.getTeam1().updateDefence(home));
        game.getTeam2().setDefence(game.getTeam2().updateDefence(away));
    }

    private static void resetUniqueFeaturesHomeAway(Fixture game, int home, int away){
        game.getTeam1().setAttack(game.getTeam1().resetAttack(home));
        game.getTeam2().setAttack(game.getTeam2().resetAttack(away));
        game.getTeam1().setMidfield(game.getTeam1().resetMidfield(home));
        game.getTeam2().setMidfield(game.getTeam2().resetMidfield(away));
        game.getTeam1().setDefence(game.getTeam1().resetDefence(home));
        game.getTeam2().setDefence(game.getTeam2().resetDefence(away));
    }

    private static boolean uniqueFeaturesMotivation(Fixture game, List <Fixture> fixtures, int end_of_season, int motivated, boolean already_done){
        if((end_of_season >= 0.7 * (double)(fixtures.size())) && !already_done){
            already_done = true;
            game.getTeam1().setAttack(game.getTeam1().updateAttack(motivated));
            game.getTeam2().setAttack(game.getTeam2().updateAttack(motivated));
            game.getTeam1().setMidfield(game.getTeam1().updateMidfield(motivated));
            game.getTeam2().setMidfield(game.getTeam2().updateMidfield(motivated));
            game.getTeam1().setDefence(game.getTeam1().updateDefence(motivated));
            game.getTeam2().setDefence(game.getTeam2().updateDefence(motivated));
        }
        return already_done;
    }
    private static void fillingMaps(Map<String, Integer>map){
        map.put("Rakow_Czestochowa", 0);
        map.put("AS_Roma", 0);
        map.put("FC_Barcelona", 0);
        map.put("Real_Madrid", 0);
        map.put("Slask_Wroclaw", 0);
        map.put("Borussia_Dortmund", 0);
    }

    private static void checkingStreaks(String team, Map<String, Integer> map1, Map<String, Integer> map2, Map<String, Integer> map3){
        if(map1.get(team) == 1){
            map2.put(team, 0);
            map3.put(team, 0);
        }
        if(map2.get(team) == 1){
            map1.put(team, 0);
            map3.put(team, 0);
        }
        if(map3.get(team) == 1){
            map2.put(team, 0);
            map1.put(team, 0);
        }
    }
    private static void hasStreak(Fixture game, String team1, String team2, Map<String, Integer> map1, Map<String, Integer> map2, Map<String, Integer> map3){
        if(map1.get(team1) == 2){
            game.getTeam1().setForm(1.1);
            map1.put(team1, 0);
            map2.put(team1, 0);
            map3.put(team1, 0);
        }
        if(map2.get(team1) == 2){
            game.getTeam1().setForm(0.9);
            map1.put(team1, 0);
            map2.put(team1, 0);
            map3.put(team1, 0);
        }
        if(map1.get(team2) == 2){
            game.getTeam2().setForm(1.1);
            map1.put(team1, 0);
            map2.put(team2, 0);
            map3.put(team2, 0);
        }
        if(map2.get(team2) == 2){
            game.getTeam2().setForm(0.9);
            map1.put(team2, 0);
            map2.put(team2, 0);
            map3.put(team2, 0);
        }
    }
    private static void formUpdater(Fixture game, int hasForm){
        game.getTeam1().setAttack(game.getTeam1().updateAttack(hasForm));
        game.getTeam2().setAttack(game.getTeam2().updateAttack(hasForm));
        game.getTeam1().setMidfield(game.getTeam1().updateMidfield(hasForm));
        game.getTeam2().setMidfield(game.getTeam2().updateMidfield(hasForm));
        game.getTeam1().setDefence(game.getTeam1().updateDefence(hasForm));
        game.getTeam2().setDefence(game.getTeam2().updateDefence(hasForm));
    }
    private static void formReseter(Fixture game, int hasForm){
        game.getTeam1().setAttack(game.getTeam1().resetAttack(hasForm));
        game.getTeam2().setAttack(game.getTeam2().resetAttack(hasForm));
        game.getTeam1().setMidfield(game.getTeam1().resetMidfield(hasForm));
        game.getTeam2().setMidfield(game.getTeam2().resetMidfield(hasForm));
        game.getTeam1().setDefence(game.getTeam1().resetDefence(hasForm));
        game.getTeam2().setDefence(game.getTeam2().resetDefence(hasForm));
        game.getTeam1().setForm(1);
        game.getTeam2().setForm(1);
    }
}

