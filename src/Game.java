public class Game {

    Round round = new Round();

    public void jouerPartie() {
        for (int i = 0; i < 5; i++) {
            System.out.println("\nManche " + (i + 1) + "\t\t\t" + "Score total : " + 0);
            round.jouerManche();
        }
    }



}
