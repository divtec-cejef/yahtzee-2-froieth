public enum Category {

    // TODO : le full house ne fonctionne pas + quand il y a full house il devrait aussi y avoir une paire



    UNE_PAIRE{
        public int score(DiceHand diceHand) {
            System.out.print("1) Une paire    : ");
            return diceHand.calculerOccurenceMax() == 2 ? 5 : 0;
        }

        public boolean utilisable() {
            return true;
        }
    },

    DEUX_PAIRE{
        public int score(DiceHand diceHand) {
            System.out.print("2) Deux paire   : ");
            return diceHand.getDeuxPaire() ? 10 : 0;
        }

        public boolean utilisable() {
            return true;
        }
    },

    BRELAN{
        public int score(DiceHand diceHand) {
            System.out.print("3) Brelan       : ");
            return diceHand.calculerOccurenceMax() == 3 ? diceHand.getPointsBrelan() : 0;
        }

        public boolean utilisable() {
            return true;
        }
    },

    CARRE{
        public int score(DiceHand diceHand) {
            System.out.print("4) Carré        : ");
            return diceHand.calculerOccurenceMax() == 4 ? diceHand.getPointsCarre() : 0;
        }

        public boolean utilisable() {
            return true;
        }
    },

    FULL_HOUSE{
        public int score(DiceHand diceHand) {
            System.out.print("5) Full House   : ");
            return diceHand.getFullHouse() ? 25 : 0;
        }

        public boolean utilisable() {
            return true;
        }
    },

    PETITE_SUITE{
        public int score(DiceHand diceHand) {
            System.out.print("6) Petite suite : ");
            return diceHand.calculerSuiteMax() == 4 ? 30 : 0;
        }

        public boolean utilisable() {
            return true;
        }
    },

    GRANTE_SUITE{
        public int score(DiceHand diceHand) {
            System.out.print("7) Grande suite : ");
            return diceHand.calculerSuiteMax() == 5 ? 40 : 0;
        }

        public boolean utilisable() {
            return true;
        }
    },

    YAHTZEE{
        public int score(DiceHand diceHand) {
            System.out.print("8) Yahtzee      : ");
            return diceHand.calculerOccurenceMax() == 5 ? 50 : 0;
        }

        public boolean utilisable() {
            return true;
        }
    };

    public abstract int score(DiceHand diceHand);
    public abstract boolean utilisable();
}
