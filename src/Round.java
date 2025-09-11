public class Round {

    private DiceHand diceHand = new DiceHand();


    public void jouerManche() {

        // Initialise la main de l'utilisateur

        diceHand.lancerDes();




        // Affiche les dés
        System.out.println(diceHand);

        System.out.println();

        Scorecard scorecard = new Scorecard(diceHand);
        scorecard.getScoreBoard();


    }

}
