import java.util.Arrays;

public class DiceHand {

    final private int nombreDes = 5;
    Die des = new Die();
    private int[] mesDes = new int[nombreDes];
    private boolean[] combinaison = new boolean[3]; // [0] -> unePaire  |  [1] -> deuxPaires  |  [2] -> fullHouse
    private int[] pointsBrelanEtCarre = new int[2]; // [0] -> points brean  |  [1] -> points carré

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

    /**
     * @param index L'index du dé à retourner
     * @return Le dé de l'utilisateur à l'index donné
     */
    public int getDe(int index) {
        return mesDes[index];
    }

    /**
     * @return vrai si il y a une paire, false sinon
     */
    public boolean getUnePaire() {
        return combinaison[0];
    }

    /**
     * @return vrai si il y a deux paire, false sinon
     */
    public boolean getDeuxPaire() {
        return combinaison[1];
    }

    /**
     * @return vrai si il y a un Full House, false sinon
     */
    public boolean getFullHouse() {
        return combinaison[2];
    }

    /**
     * @return le nombre de points pour le brelan
     */
    public int getPointsBrelan() {
        return pointsBrelanEtCarre[0];
    }

    /**
     * @return le nombre de points pour le carré
     */
    public int getPointsCarre() {
        return pointsBrelanEtCarre[1];
    }

    /**
     * Lance les dés
     */
    public void lancerDes() {
        //mesDes = new int[]{3, 4, 5, 6, 1};
        for (int i = 0; i < 5; i++) {
            des.lancerDe();
            this.mesDes[i] = des.getFaceVisible();
        }
    }

    /**
     * Lance un dés un fonction de l'index donné
     * @param index Index du dé à relancer
     */
    public void relancerDe(int index) {
        des.lancerDe();
        this.mesDes[index] = des.getFaceVisible();
    }

    /**
     * Calcule la suite maximum
     * @return La suite maximum
     */
    public int calculerSuiteMax() {
        Arrays.sort(mesDes);
        int suiteMax = 1;
        int suite = 1;

        for (int i = 1; i < mesDes.length; i++) {
            if (mesDes[i] == mesDes[i - 1] + 1) {
                suite++;
                suiteMax = Math.max(suiteMax, suite);
            } else if (mesDes[i] != mesDes[i - 1]) {
                suite = 1;
            }
        }
        return suiteMax;
    }


    /**
     * Calcule l'occurence maximum
     * @return l'occurence maximum
     */
    public int calculerOccurenceMax() {

        // Remet toutes les valeurs à false
        for (int i = 0; i < combinaison.length; i++) {
            combinaison[i] = false;
        }

        // Remet toutes les valeurs à 0
        for (int i = 0; i < pointsBrelanEtCarre.length; i++) {
            pointsBrelanEtCarre[i] = 0;
        }

        int occurence = 0;
        int occurenceMax = 1;

        for (int i = 1; i <= des.getNombreDeFace(); i++) {
            for (int j = 0; j < mesDes.length; j++) {
                if (mesDes[j] == i) {
                    occurence++;
                    occurenceMax = Math.max(occurenceMax, occurence);

                    if (combinaison[0] && occurence == 2){
                        // deuxPaires
                        combinaison[1] = true;
                    }
                }
                if(occurenceMax == 3 && pointsBrelanEtCarre[0] == 0){
                    pointsBrelanEtCarre[0] = i * 3;
                    combinaison[1] = false;
                } else if(occurenceMax == 4 && pointsBrelanEtCarre[1] == 0){
                    pointsBrelanEtCarre[1] = i * 4;
                }
            }
            if(occurence == 2) {
                // unePaire
                combinaison[0] = true;
            }
            occurence = 0;
        }
            // unePaire
        if (combinaison[0] && occurenceMax == 3) {
            // fullHouse
            combinaison[2] = true;
        }

        return occurenceMax;
    }


}
