import java.util.Arrays;
import java.util.Scanner;

public class YahtzeeProcedural {
    public static final int NOMBRE_FACE_DE = 6;
    public static final int NOMBRE_DES_A_LANCER = 5;
    public static final int NOMBRE_RELANCE_MAX = 2;
    public static final int NOMBRE_COMBINAISON_MAX = 8;
    public static final int NOMBRE_MANCHE_MAX = 5;

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
     * Relance les dé
     *
     * @param mesDes Liste dans laqelle sont stockés les dés
     */
    public static void relancerDes(int[] mesDes, String ligne) {

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
     * Demande et relance les dés souhaités
     *
     * @param mesDes Liste des dés de l'utilisateur
     */
    public static void demandeRelancerDes(int[] mesDes) {
        boolean finrelance = false;
        int nbreBoucle = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nDé à relancer : ");
            String ligne = scanner.nextLine();
            relancerDes(mesDes, ligne);
            nbreBoucle++;

            if (ligne.isEmpty() || nbreBoucle == NOMBRE_RELANCE_MAX) {
                finrelance = true;
            }
        } while (!finrelance);
    }

    /**
     * Prend les points de la combinaison souhaité
     *
     * @param combinaisonUtilisable Tableau booléen pour savoir si la combinaison est utilisable ou non
     * @param points                Les nombre de points pour chaque combinaison
     * @return le score de la manche
     */
    public static int choisirCombinaison(boolean[] combinaisonUtilisable, int[] points) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nCombinaison choisie : ");
        int saisi = scanner.nextInt();
        // Supprime la combinaison choisie des combinaisons utilisable
        combinaisonUtilisable[saisi - 1] = false;
        int score = points[saisi - 1];

        System.out.println("\n+ " + score + " points");
        return score;
    }

    /**
     * Caclcule la suite maximum
     *
     * @param mesDes Liste dans laqelle sont stockés les dés
     */
    public static int calculeSuiteMax(int[] mesDes) {
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
        return suiteMax;
    }

    /**
     * Caclcule les occurences
     *
     * @param mesDes Liste dans laqelle sont stockés les dés
     */
    public static int[] calculeOccurence(int[] mesDes) {


        // Calcule le nombre d'occurence pour chaque face
        int[] occurence = new int[NOMBRE_FACE_DE];
        for (int i = 1; i <= NOMBRE_FACE_DE; i++) {
            for (int j = 0; j < mesDes.length; j++) {
                if (mesDes[j] == i) {
                    occurence[i - 1]++;
                }
            }
        }
        return occurence;
    }

    /**
     * Vérifie si il y a une paire
     *
     * @param occurence Nombre d'occurence pour chaque face du dé
     */
    public static boolean avoirUnePaire(int[] occurence) {
        boolean unePaire = false;
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 2) {
                unePaire = true;
            }
        }
        return unePaire;
    }

    /**
     * Vérifie si il y a deux paire
     *
     * @param occurence Nombre d'occurence pour chaque face du dé
     */
    public static boolean avoirDeuxPaire(int[] occurence) {
        boolean unePaire = false;
        boolean deuxPaire = false;
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 2) {
                if (unePaire) {
                    deuxPaire = true;
                }
                unePaire = true;
            }
        }
        return deuxPaire;
    }

    /**
     * Vérifie si il y a un brelan
     *
     * @param occurence Nombre d'occurence pour chaque face du dé
     */
    public static int avoirBrelan(int[] occurence) {
        int pointsBrelan = 0;
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 3) {
                pointsBrelan = (i + 1) * 3;
            }
        }
        return pointsBrelan;
    }

    /**
     * Vérifie si il y a un carré
     *
     * @param occurence Nombre d'occurence pour chaque face du dé
     */
    public static int avoirCarre(int[] occurence) {
        int pointsCarre = 0;
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 4) {
                pointsCarre = (i + 1) * 4;
            }
        }
        return pointsCarre;
    }

    /**
     * Vérifie si il y a un Full House
     *
     * @param occurence Nombre d'occurence pour chaque face du dé
     */
    public static boolean avoirFullHouse(int[] occurence) {
        boolean unePaire = false;
        boolean brelan = false;
        boolean fullHouse = false;
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 2) {
                unePaire = true;
            }
        }

        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 3) {
                brelan = true;
            }
        }

        if (unePaire && brelan) {
            fullHouse = true;
        }

        return fullHouse;
    }

    /**
     * Vérifie si il y a une petite suite
     *
     * @param suiteMax La suite maximum
     */
    public static boolean avoirPetiteSuite(int suiteMax) {
        boolean petiteSuite = false;
        if (suiteMax == 4) {
            petiteSuite = true;
        }
        return petiteSuite;
    }

    /**
     * Vérifie si il y a une grande suite
     *
     * @param suiteMax La suite maximum
     */
    public static boolean avoirGrandeSuite(int suiteMax) {
        boolean grandeSuite = false;
        if (suiteMax == 5) {
            grandeSuite = true;
        }
        return grandeSuite;
    }

    /**
     * Vérifie si il y a un yathzee
     *
     * @param occurence Nombre d'occurence pour chaque face du dé
     */
    public static boolean avoirYahtzee(int[] occurence) {
        boolean yathzee = false;
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] == 5) {
                yathzee = true;
            }
        }
        return yathzee;
    }

    /**
     * Calcule les points possible pour chaque combinaison
     *
     * @param cats      Les catégories
     * @param occurence Nombre d'occurence pour chaque face du dé
     * @param suiteMax  La suite maximum
     * @return les points associé à la combinaison
     */
    public static int pointsCombinaison(String cats, int[] occurence, int suiteMax) {

        int brelan = avoirBrelan(occurence);
        int carre = avoirCarre(occurence);

        switch (cats) {
            case "Une paire":
                return avoirUnePaire(occurence) ? 5 : 0;
            case "Deux paire":
                return avoirDeuxPaire(occurence) ? 10 : 0;
            case "Brelan":
                return brelan == 0 ? 0 : brelan;
            case "Carré":
                return carre == 0 ? 0 : carre;
            case "Full House":
                return avoirFullHouse(occurence) ? 25 : 0;
            case "Petite suite":
                return avoirPetiteSuite(suiteMax) ? 30 : 0;
            case "Grande suite":
                return avoirGrandeSuite(suiteMax) ? 40 : 0;
            case "Yahtzee":
                return avoirYahtzee(occurence) ? 50 : 0;
            default:
                return 0;
        }

    }

    /**
     * Affiche les combinaison encore possible
     *
     * @param mesDes                Dés du joueur
     * @param cats                  Les catégories des combinaison
     * @param combinaisonUtilisable Tableau booléen pour savoir si la combinaison est utilisable ou non
     * @param points                Les nombre de points pour chaque combinaison
     * @param occurence             Le nombre d'occurence de chaque face
     */
    public static void afficherCombinaison(int[] mesDes, String[] cats, boolean[] combinaisonUtilisable, int[] points, int[] occurence) {
        int suiteMax = calculeSuiteMax(mesDes);

        for (int j = 0; j < cats.length; j++) {
            if (combinaisonUtilisable[j]) {
                String cat = cats[j];
                points[j] = pointsCombinaison(cat, occurence, suiteMax);
                System.out.println((j + 1) + ") " + cat + " : " + points[j]);
            }
        }
    }

    public static void main(String[] args) {
        // Catégorie
        String[] cats = {"Une paire", "Deux paire", "Brelan", "Carré", "Full House", "Petite suite", "Grande suite", "Yahtzee"};

        // Permet de savoir les combinaisons encore utilisable ou non
        boolean[] combinaisonUtilisable = new boolean[NOMBRE_COMBINAISON_MAX];
        Arrays.fill(combinaisonUtilisable, true);

        // Affiche le score total
        int scoreTotal = 0;

        // Permet de faire plusieurs manches
        for (int i = 0; i < NOMBRE_MANCHE_MAX; i++) {

            System.out.println("\nManche " + (i + 1) + "\t\t\t" + "Score total : " + scoreTotal);

            // Lance et affiche les dés
            int[] mesDes = new int[NOMBRE_DES_A_LANCER];
            lancerPlusieursDes(mesDes);
            afficherDes(mesDes);

            demandeRelancerDes(mesDes);

            int[] points = new int[NOMBRE_COMBINAISON_MAX];
            int[] occurence = calculeOccurence(mesDes);

            afficherCombinaison(mesDes, cats, combinaisonUtilisable, points, occurence);

            scoreTotal += choisirCombinaison(combinaisonUtilisable, points);

        }
        System.out.println("\nScore final :  " + scoreTotal);

    }

}
