public class YhatzeeOOApp  {
    public static void main(String[] args) {


        // Tests
        DiceHand diceHand =  new DiceHand();
        diceHand.lancerDes();

        int[] mesDes = diceHand.getMesDes();

        for(int i =0; i<mesDes.length; i++){
            System.out.print("[" + (i + 1) + "]" + mesDes[i] + "\t");
        }






        
    }
}