public enum Category {

    //TODO : faire la fonction si la variable est encore utilisable
    UNE_PAIRE{
        public int score(DiceHand diceHand) {
            return diceHand.calculerOccurenceMax() == 2 || diceHand.getFullHouse() ? 5 : 0;
        }

        public String afficherNom() {
            return "1) Une paire    : ";
        }
    },

    DEUX_PAIRE{
        public int score(DiceHand diceHand) {
            return diceHand.getDeuxPaire() ? 10 : 0;
        }

        public String afficherNom() {
            return "2) Deux paire   : ";
        }
    },

    BRELAN{
        public int score(DiceHand diceHand) {
            return diceHand.calculerOccurenceMax() == 3 ? diceHand.getPointsBrelan() : 0;
        }

        public String afficherNom() {
            return "3) Brelan       : ";
        }
    },

    CARRE{
        public int score(DiceHand diceHand) {
            return diceHand.calculerOccurenceMax() == 4 ? diceHand.getPointsCarre() : 0;
        }

        public String afficherNom() {
            return "4) Carré        : ";
        }
    },

    FULL_HOUSE{
        public int score(DiceHand diceHand) {
            return diceHand.getFullHouse() ? 25 : 0;
        }

        public String afficherNom() {
            return "5) Full House   : ";
        }
    },

    PETITE_SUITE{
        public int score(DiceHand diceHand) {
            return diceHand.calculerSuiteMax() >= 4 ? 30 : 0;
        }

        public String afficherNom() {
            return "6) Petite suite : ";
        }
    },

    GRANTE_SUITE{
        public int score(DiceHand diceHand) {
            return diceHand.calculerSuiteMax() == 5 ? 40 : 0;
        }

        public String afficherNom() {
            return "7) Grande suite : ";
        }
    },

    YAHTZEE{
        public int score(DiceHand diceHand) {
            return diceHand.calculerOccurenceMax() == 5 ? 50 : 0;
        }

        public String afficherNom() {
            return "8) Yahtzee      : ";
        }
    };

    public abstract int score(DiceHand diceHand);
    public abstract String afficherNom();
}
