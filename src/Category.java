public enum Category {

    UNE_PAIRE{
        public int score(DiceHand diceHand) {
            System.out.print("1) Une paire : ");
            return diceHand.calculerOccurenceMax() == 2 ? 0 : 5;
        }

        public boolean utilisable() {
            return true;
        }
    },

    DEUX_PAIRE{
        public int score(DiceHand diceHand) {
            System.out.print("2) Deux paire : ");
            return diceHand.getDeuxPaire() ? 0 : 10;
        }

        public boolean utilisable() {
            return true;
        }
    },

    BRELAN{
        public int score(DiceHand diceHand) {
            System.out.print("3) Brelan : ");
            return diceHand.calculerOccurenceMax() == 3 ? 0 : diceHand.getPointsBrelan();
        }

        public boolean utilisable() {
            return true;
        }
    },

    CARRE{
        public int score(DiceHand diceHand) {
            System.out.print("4) Carré : ");
            return diceHand.calculerOccurenceMax() == 4 ? 0 : diceHand.getPointsCarre();
        }

        public boolean utilisable() {
            return true;
        }
    },

    FULL_HOUSE{
        public int score(DiceHand diceHand) {
            System.out.print("5) Full House : ");
            return diceHand.getFullHouse() ? 0 : 25;
        }

        public boolean utilisable() {
            return true;
        }
    },

    PETITE_SUITE{
        public int score(DiceHand diceHand) {
            System.out.print("6) Petite suite : ");
            return diceHand.calculerSuiteMax() == 4 ? 0 : 30;
        }

        public boolean utilisable() {
            return true;
        }
    },

    GRANTE_SUITE{
        public int score(DiceHand diceHand) {
            System.out.print("7) Grande suite : ");
            return diceHand.calculerSuiteMax() == 5 ? 0 : 40;
        }

        public boolean utilisable() {
            return true;
        }
    },

    YAHTZEE{
        public int score(DiceHand diceHand) {
            System.out.print("8) Yahtzee : ");
            return diceHand.calculerOccurenceMax() == 5 ? 0 : 50;
        }

        public boolean utilisable() {
            return true;
        }
    };

    public abstract int score(DiceHand diceHand);
    public abstract boolean utilisable();
}
