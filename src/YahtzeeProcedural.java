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



    public static void relancerDes(int[] mesDes) {
        mesDes[/*remplacer 2 par le nomreSaisi*/2 - 1] = lancerDe();
    }

    /**
     * Permet de relancer certain dé
     *
     * @param mesDes Liste dans laqelle sont stockés les dés
     */
    public static void demandeRelancerDes(int[] mesDes) {
        Scanner scanner = new Scanner(System.in);
        boolean resaisir = true;
        do {
            System.out.print("\nDé à relancer : ");
            // TODO : faire pour que les nombres saisi s'inscrivent dans une liste
            int nombreSaisi1 = scanner.nextInt();
            int nombreSaisi2 = scanner.nextInt();
            int nombreSaisi3 = scanner.nextInt();

            // Vérifie la saisi
            if (nombreSaisi1 >=1 && nombreSaisi1 <= mesDes.length || nombreSaisi2 >=1 && nombreSaisi2 <= mesDes.length || nombreSaisi3 >=1 && nombreSaisi3 <= mesDes.length) {

            } else {
                System.out.println("Certain nombre saisi ne sont pas conforme.\nVeuillez recommencé.\n");
            }



        } while (resaisir);


    }


    public static void main(String[] args) {
        int[] mesDes = new int[NOMBRE_DES_A_LANCER];
        lancerPlusieursDes(mesDes);
        afficherDes(mesDes);
        demandeRelancerDes(mesDes);

    }
}

