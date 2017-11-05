import java.util.ArrayList;

import static java.util.Collections.shuffle;

public class Game {
    public static void main(String[] args) {
        /*
        Array of unshuffled deck
        -1 is red king
        11 is jack
        12 is queen
        13 is black king
         */
        int[] fullDeck = {
                -1,-1,0,0,1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,
                6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,11,11,11,11,
                12,12,12,12,13,13
        };
        ArrayList<Integer> deck = new ArrayList<Integer>();
        for(int i: fullDeck) {
            deck.add(i);
        }
        shuffle(deck);

        Deck gameDeck = new Deck(deck);
    }
}
