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
        int[] deARelancer = new int[NOMBRE_DES_A_LANCER];
        boolean ressaisir = true;
        do {
            ressaisir = false;

            System.out.print("\nDé à relancer : ");
            String ligne = scanner.nextLine().trim();

            // Vérifie si la ligne est pleine
            if (!ligne.isEmpty()) {
                String[] parties = ligne.split("\\s+");
                int index = 0;

                for (int i = 0; i < parties.length && index < NOMBRE_DES_A_LANCER; i++) {
                    // Vérifie si la saisi est valide
                    try {
                        int valeur = Integer.parseInt(parties[i]);
                        if (valeur >= 1 && valeur <= 5) {
                            deARelancer[index++] = valeur - 1;
                            relancerDes(mesDes, deARelancer);
                        } else {
                            System.out.println("La valeur '" + valeur + "' est hors limite.");
                            ressaisir = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("La valeur '" + parties[i] + "' n'est pas valide.");
                        ressaisir = true;
                    }
                }
            } else {
                finRelance = true;
            }
            if (ressaisir == true) {
                System.out.println("Veuillez recommencer.");
                // Vide le tableau
                for (int i = 0; i < deARelancer.length; i++) {
                    deARelancer[i] = 0;
                }
            }
        } while (ressaisir);
        afficherDes(mesDes);
        nbreBoucle--;
        for (int i = 0; i < deARelancer.length; i++) {
            deARelancer[i] = 0;
        }
        if (nbreBoucle == 0) {
            finRelance = true;
        }
    } while (finRelance == false);
}