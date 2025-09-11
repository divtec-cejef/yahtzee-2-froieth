public class Die {
    final private int nombreDeFace = 6;
    private int faceVisible = 1;

    /**
     * Lance le dé
     */
    public void lancerDe() {
        this.faceVisible = (int) (Math.random() * nombreDeFace + 1);
    }

    /**
     * @return la face visible du dé
     */
    public int getFaceVisible() {
        return faceVisible;
    }

    /**
     * @return le nombre de face du dé
     */
    public int getNombreDeFace() {
        return nombreDeFace;
    }
}
