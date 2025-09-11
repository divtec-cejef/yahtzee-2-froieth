public class Round {






    public void jouerManche() {

        // Initialise la main de l'utilisateur
        DiceHand diceHand = new DiceHand();
        diceHand.lancerDes();

        // Affiche les dés
        System.out.println(diceHand);

        System.out.println();

        System.out.println("Suite max : " + diceHand.calculerSuiteMax());
        System.out.println("Occurence max : " + diceHand.calculerOccurenceMax());

    }

}
