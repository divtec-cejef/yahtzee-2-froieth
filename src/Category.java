public enum Category {

    // TODO : modifier toutes les fonctions scores

    UNE_PAIRE{
        public int score(DiceHand diceHand) {
            return 3;
        }
    },

    DEUX_PAIRE{
        public int score(DiceHand diceHand) {
            return 3;
        }
    },

    BRELAN{
        public int score(DiceHand diceHand) {
            return 3;
        }
    },

    CARRE{
        public int score(DiceHand diceHand) {
            return 3;
        }
    },

    FULL_HOUSE{
        public int score(DiceHand diceHand) {
            return 3;
        }
    },

    PETITE_SUITE{
        public int score(DiceHand diceHand) {
            return 3;
        }
    },

    GRANTE_SUITE{
        public int score(DiceHand diceHand) {
            return 3;
        }
    },

    YAHTZEE{
        public int score(DiceHand diceHand) {
            return 3;
        }
    };





    public abstract int score(DiceHand diceHand);

}
