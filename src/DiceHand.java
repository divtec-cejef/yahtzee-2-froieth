import java.util.Arrays;

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
     * @param index L'index du dé à retourner
     * @return Le dé de l'utilisateur à l'index donné
     */
    public int getDes(int index) {
        return mesDes[index];
    }

    /**
     * @return un affichage de la liste des dés de l'utilisateur
     */
    @Override
    public String toString() {
        String affichage = "";

        for (int i = 0; i < nombreDes; i++) {
            affichage +=("[" + (i + 1) + "]" + mesDes[i] + "\t");
        }

        return affichage;
    }
}
