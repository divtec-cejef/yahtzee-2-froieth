public class Scorecard {

    private ConsoleIO console = new ConsoleIO();
    private DiceHand diceHand;
    private ScoreEntry scoreEntry;
    private boolean[] utilisable = {true, true, true, true, true, true, true, true};

    /**
     * Constructeur de la classe Scorecard
     * @param diceHand La main de l'utilisateur
     */
    public Scorecard(DiceHand diceHand) {
        this.diceHand = diceHand;
        this.scoreEntry = new ScoreEntry(diceHand);
    }





    public int pointsScoreBoard() {

        // Affiche les combinaisons encore utilisable
        for (int i = 0; i < scoreEntry.getCats().length; i++) {
            if (utilisable[i]) {
                console.afficherSansEsp(scoreEntry.getCatAfficherNom(i));
                console.afficher(scoreEntry.getCatScore(i));
            }
        }

        int nbreChoisi = console.readNextInt();
        utilisable[nbreChoisi - 1] = false;
        return scoreEntry.getCatScore(nbreChoisi - 1);
    }



}


