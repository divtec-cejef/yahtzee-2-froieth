import java.util.Scanner;

public class YahtzeeProcedural {
    public static final int NOMBRE_FACE_DE = 6;
    public static final int NOMBRE_DES_A_LANCER = 5;

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
     * Permet de relancer certain dé
     * @param mesDes Liste dans laqelle sont stockés les dés
     */
    public static void relancerDes(int[] mesDes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nVoulez vous relancer un dé ? (o/n) ");
        String lettreSaisie = scanner.next();

        // Vérifie la lettre saisie
        if (lettreSaisie.equals("o") || lettreSaisie.equals("O")) {
            boolean resaisir = true;
            do {
                System.out.print("\nDé à relancer : ");
                int nombreSaisi = scanner.nextInt();
                resaisir = false;
                if (nombreSaisi <= 0 || nombreSaisi > mesDes.length) {
                    System.out.print("\nVeuillez saisir un nombre entre 1 et " + mesDes.length);
                    resaisir = true;
                } else {
                    mesDes[nombreSaisi - 1] = lancerDe();
                    System.out.println("\nNouvelle liste : ");
                    afficherDes(mesDes);
                }

            } while (resaisir);
        }




    }

    public static void main(String[] args) {
        int[] mesDes = new int[NOMBRE_DES_A_LANCER];
        lancerPlusieursDes(mesDes);
        afficherDes(mesDes);
        relancerDes(mesDes);

    }
}

