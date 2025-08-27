import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
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
    public static void calculeCombinaison(int[] mesDes) {
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
        detecterCombinaison(suiteMax, occurence);
    }


    /**
     * Vérifie si il y a une paire
     *
     * @param occurence      Nombre d'occurence pour chaque face du dé
     * @param pointsUnePaire le nombre de points obtenu pour une paire
     */
    public static boolean avoirUnePaire(int[] occurence, int pointsUnePaire) {
        boolean unePaire = false;
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 2) {
                unePaire = true;
                pointsUnePaire = 5;
            }
        }
        System.out.println("1) Une paire    : " + pointsUnePaire + " pts");
        return unePaire;
    }

    /**
     * Vérifie si il y a deux paire
     *
     * @param occurence        Nombre d'occurence pour chaque face du dé
     * @param pointsDeuxPaires le nombre de points obtenu pour deux paire
     */
    public static void avoirDeuxPaire(int[] occurence, int pointsDeuxPaires) {
        boolean unePaire = false;
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 2) {
                if (unePaire) {
                    pointsDeuxPaires = 10;
                }
                unePaire = true;
            }
        }
        System.out.println("2) Deux paires  : " + pointsDeuxPaires + " pts");
    }

    /**
     * Vérifie si il y a un brelan
     *
     * @param occurence    Nombre d'occurence pour chaque face du dé
     * @param pointsBrelan le nombre de points obtenu pour un brelan
     */
    public static boolean avoirBrelan(int[] occurence, int pointsBrelan) {
        boolean brelan = false;
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 3) {
                brelan = true;
                pointsBrelan = (i + 1) * 3;
            }
        }
        System.out.println("3) Brelan       : " + pointsBrelan + " pts");
        return brelan;
    }

    /**
     * Vérifie si il y a un carré
     *
     * @param occurence   Nombre d'occurence pour chaque face du dé
     * @param pointsCarre le nombre de points obtenu pour un brelan
     */
    public static void avoirCarre(int[] occurence, int pointsCarre) {
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 4) {
                pointsCarre = (i + 1) * 4;
            }
        }
        System.out.println("4) Carré        : " + pointsCarre + " pts");
    }

    /**
     * Vérifie si il y a un Full House
     *
     * @param occurence       Nombre d'occurence pour chaque face du dé
     * @param pointsFullHouse le nombre de points obtenu pour un brelan
     */
    public static void avoirFullHouse(int[] occurence, int pointsFullHouse, boolean unePaire, boolean brelan) {
        for (int i = 0; i < occurence.length; i++) {
            if (brelan && unePaire) {
                pointsFullHouse = 25;
            }
        }
        System.out.println("5) Full House   : " + pointsFullHouse + " pts");
    }

    /**
     * Vérifie si il y a une petite suite
     *
     * @param suiteMax          La suite maximum
     * @param pointsPetiteSuite le nombre de points obtenu pour un brelan
     */
    public static void avoirPetiteSuite(int suiteMax, int pointsPetiteSuite) {
        if (suiteMax == 4) {
            pointsPetiteSuite = 30;
        }
        System.out.println("6) Petite suite : " + pointsPetiteSuite + " pts");
    }

    /**
     * Vérifie si il y a une grande suite
     *
     * @param suiteMax          La suite maximum
     * @param pointsGrandeSuite le nombre de points obtenu pour un brelan
     */
    public static void avoirGrandeSuite(int suiteMax, int pointsGrandeSuite) {
        if (suiteMax == 5) {
            pointsGrandeSuite = 40;
        }
        System.out.println("7) Grande suite : " + pointsGrandeSuite + " pts");
    }

    /**
     * Vérifie si il y a un yathzee
     *
     * @param occurence     Nombre d'occurence pour chaque face du dé
     * @param pointsYahtzee le nombre de points obtenu pour un brelan
     */
    public static void avoirYathzee(int[] occurence, int pointsYahtzee) {
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 5) {
                pointsYahtzee = 50;
            }
        }
        System.out.println("8) Yahtzee      : " + pointsYahtzee + " pts");
    }


    /**
     * Détecte les combinaisons possible
     *
     * @param suiteMax  La suite maximum
     * @param occurence Le nombre d'occurence pour chaque face du dé
     */
    public static void detecterCombinaison(int suiteMax, int[] occurence) {

        // Vérifie les combinaison des occurence
        int pointsUnePaire = 0;
        int pointsDeuxPaires = 0;
        int pointsBrelan = 0;
        int pointsCarre = 0;
        int pointsFullHouse = 0;
        int pointsPetiteSuite = 0;
        int pointsGrandeSuite = 0;
        int pointsYahtzee = 0;

        // Fais un retour à la ligne
        System.out.println();

        // Vérifie si il y a une paire
        boolean unePaire = avoirUnePaire(occurence, pointsUnePaire);

        // Vérifie si il y a deux paire
        avoirDeuxPaire(occurence, pointsDeuxPaires);

        // Vérifie si il y a un brelan
        boolean brelan = avoirBrelan(occurence, pointsBrelan);

        // Vérifie si il y a un carré
        avoirCarre(occurence, pointsCarre);

        // Vérifie si il y a un Full House
        avoirFullHouse(occurence, pointsFullHouse, unePaire, brelan);

        // Vérifie si il y a une petite suite
        avoirPetiteSuite(suiteMax, pointsPetiteSuite);

        // Vérifie si il y a une grande suite
        avoirGrandeSuite(suiteMax, pointsGrandeSuite);

        // Vérifie si il y a un yahtzee
        avoirYathzee(occurence, pointsYahtzee);

    }


    public static void main(String[] args) {
        int[] mesDes = new int[NOMBRE_DES_A_LANCER];
        lancerPlusieursDes(mesDes);
        afficherDes(mesDes);

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

        calculeCombinaison(mesDes);
    }
}



