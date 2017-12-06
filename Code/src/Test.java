import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> deck = new ArrayList<Integer>();
        Deck gameDeck = new Deck(deck);
        Deck shuffledDeck = new Deck(gameDeck.createAndShuffleDeck());

        Player player1 = new Player();
        Player player2 = new Player();

        Player[] players = {player1, player2};

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

        for(int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + " hand:");
            System.out.println(players[i].playerHand.hand);
        }

        for(int i = 0; i < deck.size(); i++) {
            System.out.print(shuffledDeck.get(i) + " ");
        }

        //testing look swap
//        System.out.println("Testing look swap");
//        System.out.println();
//        player1.lookSwap(player2, 1, 0);
//        for(int i = 0; i < players.length; i++) {
//            System.out.println("Player " + (i + 1) + " hand:");
//            System.out.println(players[i].playerHand.hand);
//        }

        System.out.println();
        System.out.println("Testing see card");
        System.out.println("which player?");
        int player = sc.nextInt();
        System.out.println("what index?");
        int index = sc.nextInt();
        System.out.println(players[player-1].playerHand.hand.get(index));
    }
}
