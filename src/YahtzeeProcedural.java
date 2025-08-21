import java.util.Scanner;

public class YahtzeeProcedural {
    public static final int NOMBRE_FACE_DE = 6;
    public static final int NOMBRE_DES_A_LANCER = 5;
    public static final int NOMBRE_RELANCE_MAX = 2;

    /**
     * Lance un dé
     *
     * @return un nombre aléatoire compris entre 1 et 6
     */
    public static int lancerDe() {
        return (int) (Math.random() * NOMBRE_FACE_DE + 1);
    }

    /**
     * Lance plusieurs dés
     *
     * @param mesDes Liste dans laqelle sont stockés les dés
     */
    public static void lancerPlusieursDes(int[] mesDes) {
        for (int i = 0; i < mesDes.length; i++) {
            int des = lancerDe();
            mesDes[i] = des;
        }
    }

    /**
     * Affiche les dés contenu dans le tableau
     *
     * @param mesDes Liste dans laqelle sont stockés les dés
     */
    public static void afficherDes(int[] mesDes) {
        for (int i = 0; i < mesDes.length; i++) {
            System.out.print("[" + (i + 1) + "]" + mesDes[i] + "\t");
        }
    }


    /**
     * Relance les certains dés
     *
     * @param mesDes Liste des dés
     */
    public static void relancerDes(int[] mesDes, int[] deARelancer, int nbreDesChoisis) {
        for (int i = 0; i < nbreDesChoisis; i++) {
            mesDes[deARelancer[i]] = lancerDe();
        }
    }


    /**
     * Demande à l'utilisateur les dés qu'il veut relancer et les relances
     *
     * @param mesDes Liste dans laqelle sont stockés les dés
     */
    public static void demandeRelancerDes(int[] mesDes) {
        Scanner scanner = new Scanner(System.in);
        int nbreBoucle = NOMBRE_RELANCE_MAX;
        boolean finRelance = false;
        do {
            // Tableau qui contient les dés à relanceruel
            //int[] deARelancer = new int[NOMBRE_DES_A_LANCER];

            System.out.print("\nDé à relancer : ");
            String ligne = scanner.nextLine().trim();

            // Vérifie si la ligne est pleine
            if (!ligne.isEmpty()) {
                String[] parties = ligne.split("\\s+");
                int[] deARelancer = new int[parties.length];

                int index = 0;
                for (String party : parties) {
                    int valeur = Integer.parseInt(party);
                    deARelancer[index++] = valeur - 1;
                }
                relancerDes(mesDes, deARelancer, index);

            } else {
                finRelance = true;
            }
            afficherDes(mesDes);
            nbreBoucle--;
            //Arrays.fill(deARelancer, 0);
            if (nbreBoucle == 0) {
                finRelance = true;
            }
        } while (!finRelance);
    }


    public static void main(String[] args) {
        int[] mesDes = new int[NOMBRE_DES_A_LANCER];
        lancerPlusieursDes(mesDes);
        afficherDes(mesDes);
        demandeRelancerDes(mesDes);


    }
}

