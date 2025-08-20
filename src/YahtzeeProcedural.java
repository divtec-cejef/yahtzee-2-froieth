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
     * Demande à l'utilisateur si il veut relancer des dés ou non
     *
     * @return Le résultat de sa réponse
     */
    public static boolean relancer() {
        boolean result = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n\nVoulez vous relancer un dé ? (o/n) : ");
        String lettreSaisie = scanner.next();

        // Vérifie la lettre saisie
        if (lettreSaisie.equals("o") || lettreSaisie.equals("O")) {
            result = true;
        }
        return result;
    }

    /**
     * Permet de relancer certain dé
     *
     * @param mesDes Liste dans laqelle sont stockés les dés
     */
    public static void relancerDes(int[] mesDes) {
        Scanner scanner = new Scanner(System.in);
        if (relancer()) {
            for (int i = 0; i < NOMBRE_RELANCE_MAX; i++) {

                boolean resaisir = true;
                do {
                    System.out.print("\nDé à relancer : ");
                    int nombreSaisi = scanner.nextInt();

                    if (nombreSaisi >= 1 && nombreSaisi <= mesDes.length) {
                        mesDes[nombreSaisi - 1] = lancerDe();
                        System.out.println("\nNouvelle liste : ");
                        resaisir = false;
                        afficherDes(mesDes);
                    } else {
                        System.out.print("\nVeuillez saisir un nombre entre 1 et " + mesDes.length);
                    }
                } while (resaisir);

            }
        }
    }


    public static void main(String[] args) {
        int[] mesDes = new int[NOMBRE_DES_A_LANCER];
        lancerPlusieursDes(mesDes);
        afficherDes(mesDes);
        relancerDes(mesDes);

    }
}

