public class Round {

    private final int NOMBRE_RELANCE_MAX = 3;
    private ConsoleIO console =  new ConsoleIO();
    private Player player = new Player();
    private int pointsManche = 0;

    public Scorecard getScorecard() {
        return player.getScorecard();
    }

    public int getPointsManche() {
        return pointsManche;
    }

    public void jouerManche(int index) {

        // Remet les points de la manche à zero
        pointsManche = 0;

        // Initialise la main de l'utilisateur
        player.getDiceHand().lancerDes();

        // Affiche les dés
        console.afficher(player.getDiceHand());
        console.afficherRetourLigne();

        for (int i = 0; i < NOMBRE_RELANCE_MAX; i++) {
            // Demande les dé à relancer
            console.afficherSansEsp("Dés à relancer : ");
            String saisi = console.readNextLine();
            // Vérifie si la saisi contient qqc
            if (!saisi.isEmpty()) {
                player.getDiceHand().relancerDes(saisi);

                // Affiche la nouvelle combinaison
                console.afficher("Nouvelle combinaison : ");
                console.afficher(player.getDiceHand());
            } else {
                i = NOMBRE_RELANCE_MAX;
            }
            console.afficherRetourLigne();
        }
        // Affiche le score board
        pointsManche += player.getScorecard().pointsScoreBoard();
        console.afficher(" + " + pointsManche + " points");

    }

}
