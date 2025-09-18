public class Game {

    private ConsoleIO console = new ConsoleIO();
    private Round round = new Round();
    private int scoreTotal = 0;

    public void jouerPartie() {
        //round.setScorecard();

        for (int i = 0; i < 5; i++) {

            console.afficher("\nManche " + (i + 1) + "\t\t\t" + "Score total : " + scoreTotal);
            round.jouerManche(i);
            scoreTotal += round.getPointsManche();
        }

        console.afficher("Score final : " +  scoreTotal);
    }



}
