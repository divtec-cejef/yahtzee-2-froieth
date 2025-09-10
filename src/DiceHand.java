public class DiceHand {

    final private int nombreDes = 5;
    private int[] mesDes = new int[nombreDes];

    /**
     * Lance les dés
     */
    public void lancerDes() {
        for (int i = 0; i < 5; i++) {
            Die des = new Die();
            des.lancerDe();
            this.mesDes[i] = des.getFaceVisible();
        }
    }

    /**
     * @return La liste des dés de l'utilisateur
     */
    public int[] getMesDes() {
        return mesDes;
    }


}
