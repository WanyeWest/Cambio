import java.util.ArrayList;
import java.util.Scanner;

public class PenaltyTest {
	public static void main(String[] args) {
        ArrayList<Integer> deck = new ArrayList<Integer>();
        ArrayList<Integer> burned = new ArrayList<Integer>();
        
        Deck gameDeck = new Deck(deck);
        Deck shuffledDeck = new Deck(gameDeck.createAndShuffleDeck());

        Player player1 = new Player();
        Player player2 = new Player();

        Player[] players = {player1, player2};
        Scanner 

        //print deck and stuff
        System.out.println(deck.size());
        for(int i = 0; i < deck.size(); i++) {
            System.out.print(shuffledDeck.get(i) + " ");
        }

        System.out.println();
        //loop to deal cards
        for(int i = 0; i < players.length; i++) {
            for(int x = 0; x < 4; x++) {
                players[i].playerHand.hand.add(shuffledDeck.draw());
            }
        }
        
        //see cards
        for(int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + " hand:");
            System.out.println(players[i].playerHand.hand);
        }
        
        int newCard = Deck.draw();
        System.out.println("The card you drew: " + newCard);
        System.out.println("Would you like to burn this card or swap it?");
        
    	if() {
    		player1.playerHand.burnCard();
    	}else {
    		player1.playerHand.swap()
    	}
	}
}
