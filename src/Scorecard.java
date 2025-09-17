public class Scorecard {

    private DiceHand diceHand;
    private ScoreEntry scoreEntry;
    private int nbreChoisi = 1;
    private Round round =  new Round();
    private boolean[] utilisable = {true, true, true, true, true, true, true, true};

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
            if (utilisable[i]) {
                System.out.println(scoreEntry.getCatScore(i));
            }

            if((i+1) == round.getNombreChoisi()) {
                utilisable[i] = false;
            }
        }



        for (int i = 0; i < utilisable.length; i++) {}



    }

}
