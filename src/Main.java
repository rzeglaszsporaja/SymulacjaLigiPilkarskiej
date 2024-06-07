import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Zmienne potrzebne do wybranych funkcji w programie

        double chances_of_injury = 0.1;
        int number_of_seasons = 1;
        int home = 1;
        int away = 2;
        int end_of_season=0;
        int motivated_or_tired = 3;
        boolean alredy_done = false;

        // Uworzenie obiektow (klubow pilkarskich)

        ClubAway Rakow_Czestochowa = new ClubAway(0.58, 0.71, 0.59, 1, 0.9);
        ClubHome AS_Roma = new ClubHome(0.78, 0.75, 0.69, 1, 1.25);
        Club FC_Barcelona = new Club(0.92, 0.81, 0.88, 1);
        ClubMotivation Real_Madrid = new ClubMotivation(0.93, 0.89, 0.96, 1, 1.12);
        Club Slask_Wroclaw = new Club(0.61, 0.49, 0.56, 1);
        ClubTiredOfSeason Borussia_Dortmund = new ClubTiredOfSeason(0.81, 0.76, 0.79, 1, 0.88);

        // Uworzenie tablicy potrzebnej do zapisywania wynikow spotkan

        Map<String, Integer>results = new TreeMap<>();
        results.put("Rakow_Czestochowa", 0);
        results.put("AS_Roma", 0);
        results.put("FC_Barcelona", 0);
        results.put("Real_Madrid", 0);
        results.put("Slask_Wroclaw", 0);
        results.put("Borussia_Dortmund", 0);

        // Utworzenie tablicy potrzebnej do zapisywania ilosci wygranych spotkan

        Map<String, Integer>win_streaks = new TreeMap<>();
        results.put("Rakow_Czestochowa", 0);
        results.put("AS_Roma", 0);
        results.put("FC_Barcelona", 0);
        results.put("Real_Madrid", 0);
        results.put("Slask_Wroclaw", 0);
        results.put("Borussia_Dortmund", 0);

        // Utworzenie tablicy potrzebnej do zapisywania ilosci przegranych spotkan

        Map<String, Integer>losing_streaks = new TreeMap<>();
        results.put("Rakow_Czestochowa", 0);
        results.put("AS_Roma", 0);
        results.put("FC_Barcelona", 0);
        results.put("Real_Madrid", 0);
        results.put("Slask_Wroclaw", 0);
        results.put("Borussia_Dortmund", 0);

        // Skroty nazw klubow

        String RCZ = "Rakow_Czestochowa";
        String ASR = "AS_Roma";
        String FCB = "FC_Barcelona";
        String RM = "Real_Madrid";
        String SW = "Slask_Wroclaw";
        String BVB = "Borussia_Dortmund";

        // Lista spotkan ktore moga sie odbyc w trakcie sezonu

        List<Fixture> fixtures = new ArrayList<>();

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

        for (int i = 0; i < number_of_seasons; i++) {

            // Lista spotkan zostaje wymieszana aby kolejnosc rozgrywania meczow byla przypadkowa

            Collections.shuffle(fixtures);

            // Kontuzje wystepujace przypadkowo miedzy meczami

            int was_defender_injured1 = 0;
            int was_defender_injured2 = 0;
            int was_midfielder_injured1 = 0;
            int was_midfielder_injured2 = 0;
            int was_striker_injured1 = 0;
            int was_striker_injured2 = 0;

            // Petla w ktorej odbeda sie wszystkie mecze w sezonie

            for (Fixture game : fixtures) {

                //Losowanie kontuzji dla pary druzyn ktore beda graly spotkanie

                if (Math.random() < chances_of_injury) {
                    Injury.injuryDefender(game.getTeam1());
                    was_defender_injured1++;
                }
                if (Math.random() < chances_of_injury) {
                    Injury.injuryDefender(game.getTeam2());
                    was_defender_injured2++;
                }
                if (Math.random() < chances_of_injury) {
                    Injury.injuryMidfielder(game.getTeam1());
                    was_midfielder_injured1++;
                }
                if (Math.random() < chances_of_injury) {
                    Injury.injuryMidfielder(game.getTeam2());
                    was_midfielder_injured2++;
                }
                if (Math.random() < chances_of_injury) {
                    Injury.injuryStriker(game.getTeam1());
                    was_striker_injured1++;
                }
                if (Math.random() < chances_of_injury) {
                    Injury.injuryStriker(game.getTeam2());
                    was_striker_injured2++;
                }
                // Jesli jest koncowka sezonu to przypisanie cech dla wybranych zespolow

                if((end_of_season >= 0.9 * (double)(fixtures.size()/(results.size()/2)) || !alredy_done)){
                    alredy_done = true;
                    game.getTeam1().setAttack(game.getTeam1().updateAttack(motivated_or_tired));
                    game.getTeam2().setAttack(game.getTeam2().updateAttack(motivated_or_tired));
                    game.getTeam1().setMidfield(game.getTeam1().updateMidfield(motivated_or_tired));
                    game.getTeam2().setMidfield(game.getTeam2().updateMidfield(motivated_or_tired));
                    game.getTeam1().setDefence(game.getTeam1().updateDefence(motivated_or_tired));
                    game.getTeam2().setDefence(game.getTeam2().updateDefence(motivated_or_tired));
                }

                // Zwieszkanie/zmniejszanie wspolczynnikow jesli druzyna gra u siebie/na wyjezdzie

                game.getTeam1().setAttack(game.getTeam1().updateAttack(home));
                game.getTeam2().setAttack(game.getTeam2().updateAttack(away));
                game.getTeam1().setMidfield(game.getTeam1().updateMidfield(home));
                game.getTeam2().setMidfield(game.getTeam2().updateMidfield(away));
                game.getTeam1().setDefence(game.getTeam1().updateDefence(home));
                game.getTeam2().setDefence(game.getTeam2().updateDefence(away));

                // Symulacja meczu miedzy 2 druzynami

                MatchSimulator.simulateMatch(game.getTeam1(), game.getTeam2(), game.getTeam1Key(), game.getTeam2Key(), results, win_streaks, losing_streaks);

                //Resetowanie wspolczynnikow klubow jesli wystapila kontuzja

                if (was_defender_injured1 != 0)
                    Injury.recoveryDefender(game.getTeam1());
                if (was_defender_injured2 != 0)
                    Injury.recoveryDefender(game.getTeam2());
                if (was_midfielder_injured1 != 0)
                    Injury.recoveryMidfielder(game.getTeam1());
                if (was_midfielder_injured2 != 0)
                    Injury.recoveryMidfielder(game.getTeam2());
                if (was_striker_injured1 != 0)
                    Injury.recoveryStriker(game.getTeam1());
                if (was_striker_injured2 != 0)
                    Injury.recoveryStriker(game.getTeam2());

                // Resetowanie wspolczynnikow po meczu u siebie/na wyjezdzie

                game.getTeam1().setAttack(game.getTeam1().resetAttack(home));
                game.getTeam2().setAttack(game.getTeam2().resetAttack(away));
                game.getTeam1().setMidfield(game.getTeam1().resetMidfield(home));
                game.getTeam2().setMidfield(game.getTeam2().resetMidfield(away));
                game.getTeam1().setDefence(game.getTeam1().resetDefence(home));
                game.getTeam2().setDefence(game.getTeam2().resetDefence(away));

                // Zapisanie do zmiennej ile meczow sie odbylo

                end_of_season++;
            }
        }

        // Wypisanie wynikow

        System.out.println(results);
        System.out.println(win_streaks);
        System.out.println(losing_streaks);
    }
}
