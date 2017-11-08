import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Collections.shuffle;

public class Game {
    public static void main(String[] args) {
        //create and shuffle full Deck
        ArrayList<Integer> deck = new ArrayList<Integer>();
        Deck gameDeck = new Deck(deck);
        Deck shuffledDeck = new Deck(gameDeck.createAndShuffleDeck());
        
        Player pTest = new Player();
        

        //testing things
        for(int i = 0; i < deck.size(); i++) {
        	System.out.print(shuffledDeck.get(i) + ", ");
        }

        for(int i = 0; i < deck.size(); i++) {
        	System.out.print(shuffledDeck.get(i) + ", ");
        }       
    }
}
