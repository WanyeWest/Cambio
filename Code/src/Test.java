import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> deck = new ArrayList<Integer>();
        Deck gameDeck = new Deck(deck);
        Deck shuffledDeck = new Deck(gameDeck.createAndShuffleDeck());

        Player player1 = new Player();
        Player player2 = new Player();

        Player[] players = new Player[2];

        //loop to deal cards

        //main game loop
        while(true) {

        }
    }
}
