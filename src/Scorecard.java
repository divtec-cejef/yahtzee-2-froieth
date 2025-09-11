public class Scorecard {

    private DiceHand diceHand;
    private ScoreEntry scoreEntry;

    /**
     * Constructeur de la classe Scorecard
     * @param diceHand La main de l'utilisateur
     */
    public Scorecard(DiceHand diceHand) {
        this.diceHand = diceHand;
        this.scoreEntry = new ScoreEntry(diceHand);
    }





    public void getScoreBoard() {


        // Affiche les combinaisons encore utilisable
        for (int i = 0; i < scoreEntry.getCats().length; i++) {
            if (scoreEntry.getCatUtilisable(i)) {
                System.out.println(scoreEntry.getCatScore(i));
            }
        }



    }

}
