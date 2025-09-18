public class Player {

    private String nom;
    private DiceHand diceHand = new DiceHand();
    private Scorecard scorecard =  new Scorecard(diceHand);

    public Scorecard getScorecard() {
        return scorecard;
    }

    public DiceHand getDiceHand() {
        return diceHand;
    }
}
