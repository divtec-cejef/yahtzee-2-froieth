public enum Category {

    UNE_PAIRE{
        public int score(DiceHand diceHand) {
            System.out.println("1) Une paire : ");
            return diceHand.calculerOccurenceMax() == 2 ? 0 : 5;
        }
    },

    DEUX_PAIRE{
        public int score(DiceHand diceHand) {
            System.out.println("2) Deux paire : ");
            return diceHand.getDeuxPaire() ? 0 : 10;
        }
    },

    BRELAN{
        public int score(DiceHand diceHand) {
            System.out.println("3) Brelan : ");
            return diceHand.calculerOccurenceMax() == 3 ? 0 : diceHand.getPointsBrelan();
        }
    },

    CARRE{
        public int score(DiceHand diceHand) {
            System.out.println("4) Carré : ");
            return diceHand.calculerOccurenceMax() == 4 ? 0 : diceHand.getPointsCarre();
        }
    },

    FULL_HOUSE{
        public int score(DiceHand diceHand) {
            System.out.println("5) Full House : ");
            return diceHand.getFullHouse() ? 0 : 25;
        }
    },

    PETITE_SUITE{
        public int score(DiceHand diceHand) {
            System.out.println("6) Petite suite : ");
            return diceHand.calculerSuiteMax() == 4 ? 0 : 30;
        }
    },

    GRANTE_SUITE{
        public int score(DiceHand diceHand) {
            System.out.println("7) Grande suite : ");
            return diceHand.calculerSuiteMax() == 5 ? 0 : 40;
        }
    },

    YAHTZEE{
        public int score(DiceHand diceHand) {
            System.out.println("8) Yahtzee : ");
            return diceHand.calculerOccurenceMax() == 5 ? 0 : 50;
        }
    };

    public abstract int score(DiceHand diceHand);

}
