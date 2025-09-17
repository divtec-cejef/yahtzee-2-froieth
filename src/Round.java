import java.io.Console;

public class Round {

    private DiceHand diceHand = new DiceHand();
    private ConsoleIO console =  new ConsoleIO();
    private int nombreChoisi;


    public int getNombreChoisi() {
        return nombreChoisi;
    }

    public void setNombreChoisi(int nombreChoisi) {
        this.nombreChoisi = nombreChoisi;
    }

    public void jouerManche(int index) {

        // Initialise la main de l'utilisateur

        diceHand.lancerDes();




        // Affiche les dés
        System.out.println(diceHand);
        System.out.println();




        Scorecard scorecard = new Scorecard(diceHand);
        scorecard.getScoreBoard();
        setNombreChoisi(console.readNextInt());

    }

}
