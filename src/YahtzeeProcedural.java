import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.Scanner;

public class YahtzeeProcedural {
    public static final int NOMBRE_FACE_DE = 6;
    public static final int NOMBRE_DES_A_LANCER = 5;
    public static final int NOMBRE_RELANCE_MAX = 2;
    public static final int NOMBRE_COMBINAISON_MAX = 8;

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
        System.out.println();
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
    public static void demandeRelancerDes(int[] mesDes, String ligne) {

        // Vérifie si la ligne est pleine
        if (!ligne.isEmpty()) {
            String[] parties = ligne.split("\\s+");
            int[] deARelancer = new int[parties.length];
            System.out.println();

            int index = 0;
            for (String party : parties) {
                int valeur = Integer.parseInt(party);
                deARelancer[index++] = valeur - 1;
            }
            relancerDes(mesDes, deARelancer, index);

            System.out.println("Nouvelle combinaison");
            afficherDes(mesDes);

        }
    }

    /**
     * Caclcule les combinaison possible
     *
     * @param mesDes Liste dans laqelle sont stockés les dés
     */
    public static void calculeCombinaison(int[] mesDes, int[] points, boolean[] combinaisonUtilisable) {
        // Calcule la suite maximum
        // Trie les dés
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

        //System.out.println("Suite max = " + suiteMax);


        // Calcule le nombre d'occurence pour chaque face
        int[] occurence = new int[NOMBRE_FACE_DE];
        for (int i = 1; i <= NOMBRE_FACE_DE; i++) {
            for (int j = 0; j < mesDes.length; j++) {
                if (mesDes[j] == i) {
                    occurence[i - 1]++;
                }
            }
            //System.out.println("Occurence de " + i + " = " + occurence[i - 1]);
        }
        detecterCombinaison(suiteMax, occurence, points, combinaisonUtilisable);
    }

    /**
     * Vérifie si il y a deux paire
     *
     * @param occurence Nombre d'occurence pour chaque face du dé
     * @param points    Liste qui stock les résultats des combinaison possible
     */
    public static void avoirDeuxPaire(int[] occurence, int[] points) {
        boolean unePaire = false;
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 2) {
                if (unePaire) {
                    points[1] = 10;
                }
                unePaire = true;
            }
        }
        System.out.println("2) Deux paires  : " + points[1] + " pts");
    }

    /**
     * Vérifie si il y a un carré
     *
     * @param occurence Nombre d'occurence pour chaque face du dé
     * @param points    Liste qui stock les résultats des combinaison possible
     */
    public static void avoirCarre(int[] occurence, int[] points) {
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 4) {
                points[3] = (i + 1) * 4;
            }
        }
        System.out.println("4) Carré        : " + points[3] + " pts");
    }

    /**
     * Vérifie si il y a un Full House
     *
     * @param occurence Nombre d'occurence pour chaque face du dé
     * @param points    Liste qui stock les résultats des combinaison possible
     */
    public static void avoirFullHouse(int[] occurence, int[] points, boolean unePaire, boolean brelan) {
        for (int i = 0; i < occurence.length; i++) {
            if (brelan && unePaire) {
                points[4] = 25;
            }
        }
        System.out.println("5) Full House   : " + points[4] + " pts");
    }

    /**
     * Vérifie si il y a une petite suite
     *
     * @param suiteMax La suite maximum
     * @param points   Liste qui stock les résultats des combinaison possible
     */
    public static void avoirPetiteSuite(int suiteMax, int[] points) {
        if (suiteMax == 4) {
            points[5] = 30;
        }
        System.out.println("6) Petite suite : " + points[5] + " pts");
    }

    /**
     * Vérifie si il y a une grande suite
     *
     * @param suiteMax La suite maximum
     * @param points   Liste qui stock les résultats des combinaison possible
     */
    public static void avoirGrandeSuite(int suiteMax, int[] points) {
        if (suiteMax == 5) {
            points[6] = 40;
        }
        System.out.println("7) Grande suite : " + points[6] + " pts");
    }

    /**
     * Vérifie si il y a un yathzee
     *
     * @param occurence Nombre d'occurence pour chaque face du dé
     * @param points    Liste qui stock les résultats des combinaison possible
     */
    public static void avoirYathzee(int[] occurence, int[] points) {
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 5) {
                points[7] = 50;
            }
        }
        System.out.println("8) Yahtzee      : " + points[7] + " pts");
    }


    /**
     * Détecte les combinaisons possible
     * La fonction est lancé depuis calculerCombinaison
     *
     * @param suiteMax  La suite maximum
     * @param occurence Le nombre d'occurence pour chaque face du dé
     */
    public static void detecterCombinaison(int suiteMax, int[] occurence, int[] points, boolean[] combinaisonUtilisable) {

        boolean unePaire = false;
        boolean brelan = false;

        // Vide le tableau
        Arrays.fill(points, 0);

        // Fais un retour à la ligne
        System.out.println();

        // Vérifie si il y a une paire et si la combinaison est encore utiliasble
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 2) {
                unePaire = true;
            }
        }
        if (combinaisonUtilisable[0]) {
            if (unePaire) {
                points[0] = 5;
            }
            System.out.println("1) Une paire    : " + points[0] + " pts");
        }

        // Vérifie si il y a deux paire et si la combinaison est encore utiliasble
        if (combinaisonUtilisable[1]) {
            avoirDeuxPaire(occurence, points);
        }

        // Vérifie si il y a un brelan et si la combinaison est encore utiliasble
        int pointsBrelan = 0;
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 3) {
                brelan = true;
                pointsBrelan = (i + 1) * 3;
            }
        }
        if (combinaisonUtilisable[2]) {
            if (brelan) {
                points[2] = pointsBrelan;
            }
            System.out.println("3) Brelan       : " + points[2] + " pts");
        }
        // Vérifie si il y a un carré et si la combinaison est encore utiliasble
        if (combinaisonUtilisable[3]) {
            avoirCarre(occurence, points);
        }

        // Vérifie si il y a un Full House et si la combinaison est encore utiliasble
        if (combinaisonUtilisable[4]) {
            avoirFullHouse(occurence, points, unePaire, brelan);
        }

        // Vérifie si il y a une petite suite et si la combinaison est encore utiliasble
        if (combinaisonUtilisable[5]) {
            avoirPetiteSuite(suiteMax, points);
        }

        // Vérifie si il y a une grande suite et si la combinaison est encore utiliasble
        if (combinaisonUtilisable[6]) {
            avoirGrandeSuite(suiteMax, points);
        }

        // Vérifie si il y a un yahtzee et si la combinaison est encore utiliasble
        if (combinaisonUtilisable[7]) {
            avoirYathzee(occurence, points);
        }

    }


    public static void main(String[] args) {
        // Permet de savoir les combinaisons encore utilisable ou non
        boolean[] combinaisonUtilisable = new boolean[NOMBRE_COMBINAISON_MAX];
        Arrays.fill(combinaisonUtilisable, true);


        // Affiche le score total
        int scoreTotal = 0;

        do {
            System.out.println("\nScore : " + scoreTotal + "\n");

            // Lance et affiche les dés
            int[] mesDes = new int[NOMBRE_DES_A_LANCER];
            lancerPlusieursDes(mesDes);
            afficherDes(mesDes);

            // Demande et relance les dés souhaités
            boolean finrelance = false;
            int nbreBoucle = 0;
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.print("\nDé à relancer : ");
                String ligne = scanner.nextLine();
                demandeRelancerDes(mesDes, ligne);
                nbreBoucle++;

                if (ligne.isEmpty() || nbreBoucle == NOMBRE_RELANCE_MAX) {
                    finrelance = true;
                }
            } while (!finrelance);

            int[] points = new int[NOMBRE_COMBINAISON_MAX];
            calculeCombinaison(mesDes, points, combinaisonUtilisable);

            // Demande à l'utilisateur la combinaison qu'il souhaite choisir
            Scanner scanner = new Scanner(System.in);
            System.out.print("Combinaison choisie : ");
            int saisi = scanner.nextInt();
            // Supprime la combinaison choisie des combinaisons utilisable
            combinaisonUtilisable[saisi - 1] = false;
            scoreTotal += points[saisi - 1];

        } while (true);

    }
}
