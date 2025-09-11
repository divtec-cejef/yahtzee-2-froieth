public class ScoreEntry {


    private DiceHand diceHand;
    private int jet;
    private Category[] cats = new Category[]{
            Category.UNE_PAIRE,
            Category.DEUX_PAIRE,
            Category.BRELAN,
            Category.CARRE,
            Category.FULL_HOUSE,
            Category.PETITE_SUITE,
            Category.GRANTE_SUITE,
            Category.YAHTZEE
    };

    /**
     * Constructeur de la classe ScoreEntry
     * @param diceHand La main de l'utilisateur
     */
    public ScoreEntry(DiceHand diceHand) {
        this.diceHand = diceHand;
    }

    /**
     * @return la catégorie des combinaisons
     */
    public Category[] getCats() {
        return cats;
    }

    /**
     * @param index Index de la catégorie souhaité
     * @return le score de la catégorie de l'index donné
     */
    public int getCatScore(int index) {
        return cats[index].score(diceHand);
    }

    /**
     * @param index Index de la catégorie souhaité
     * @return la validité de la catégorie de l'index donné
     */
    public boolean getCatUtilisable(int index) {
        return cats[index].utilisable();
    }
}
