import java.util.Arrays;
import java.util.Scanner;

public class YahtzeeProcedural {
    public static final int NOMBRE_FACE_DE = 6;
    public static final int NOMBRE_DES_A_LANCER = 5;
    public static final int NOMBRE_RELANCE_MAX = 3;

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
     * @param mesDes
     */
    public static void relancerDes(int[] mesDes, int[] deARelancer) {
        for (int i = 0; i < NOMBRE_RELANCE_MAX; i++) {
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
        // Tableau qui contient les dés à relanceruel
        int[] deARelancer = new int[NOMBRE_RELANCE_MAX];
        boolean ressaisir =  true;
        do {
            ressaisir = false;

            System.out.print("\nDé à relancer : ");
            String ligne = scanner.nextLine().trim();

            // Vérifie si la ligne est pleine
            if (!ligne.isEmpty()) {
                String[] parties = ligne.split("\\s+");
                int index = 0;

                for (int i = 0; i < parties.length && index < NOMBRE_RELANCE_MAX; i++) {
                    // Vérifie si la saisi est valide
                    try {
                        int valeur = Integer.parseInt(parties[i]);
                        if (valeur >= 1 && valeur <= 5) {
                            deARelancer[index++] = valeur;
                        } else {
                            System.out.println("La valeur '" + valeur + "' n'est est hors limite.");
                            ressaisir = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("La valeur '" + parties[i] + "' n'est pas valide.");
                        ressaisir = true;
                    }
                }
            }
            if (ressaisir == true) {
                System.out.println("Veuillez recommencer.");
                Arrays.fill(deARelancer, 0);

            }
        } while (ressaisir);
        relancerDes(mesDes, deARelancer);
    }


    public static void main(String[] args) {
        int[] mesDes = new int[NOMBRE_DES_A_LANCER];
        lancerPlusieursDes(mesDes);
        afficherDes(mesDes);
        demandeRelancerDes(mesDes);

    }
}

