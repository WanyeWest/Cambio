package game;

import card.Card;

import java.util.Scanner;
import static game.Game.*;

public class Player {
	public static Hand playerHand = new Hand();
	public String name;
	static Scanner sc = new Scanner(System.in);

	public Player(String name) {
		this.name = name;
	}

    /**
     * Method that is to be called when you want to ask the player if they want
     * to burn a card. This should make the entire thing a lot easier to write
     */
	public static void askBurn() {
        System.out.println("Does someone want to burn?");
        System.out.println("Which player would like to burn? 1,2,3,4");
        int burner = sc.nextInt();
        System.out.println("Who's card do you want to burn? (1,2,3,4)");
        int burnee = sc.nextInt();
        if(burnee == burner) {
            System.out.println("Which of your cards do you want to burn?");
            System.out.println(Game.players[burner].playerHand);
            int index = sc.nextInt();
            burnSelf(index);
        } else {
            System.out.println("Which of their cards do you want to burn?");
            System.out.println(Game.players[burnee - 1].playerHand);
            int index = sc.nextInt();
            burnOther(burnee, index);
        }
    }

    /**
     * Checks if a burn is legal
     * @param card the card that is to be burned
     * @return true if card is the same as the top of burnedDeck, false if not the same
     */
    public static boolean isLegal(Card card) {
	    return card.equals(Deck.burnedDeck.getTop());
    }

    /**
     * Called when player want to burn their own card
     * They choose a card, check if the burn is legal, if legal burn, else penalty
     * @param index the index of the card in their hand
     */
    public static void burnSelf(int index) {
        if(isLegal(playerHand.hand.get(index))) {
            System.out.println("Burn successful");
            Deck.burnedDeck.add(playerHand.hand.set(index, null));
        } else {
            System.out.println("Burn failed");
            System.out.println("You get a penalty card");
            playerHand.hand.add(Deck.mainDeck.draw());
        }
    }

    /**
     * Called when a player wants to burn another player's card
     * They choose a card, check if the burn is legal, if legal burn and give them card, else penalty and print card
     * @param victim the index of the victim
     * @param index
     */
    public static void burnOther(int victim, int index) {
        if(isLegal(Game.players[victim].playerHand.hand.get(index))) {
            System.out.println("Burn successful");
            Deck.burnedDeck.add(Game.players[victim].playerHand.hand.set(index, null));
            System.out.println("Which card do you want to give them?");
            System.out.println(playerHand);
            int i = sc.nextInt();
            Game.players[victim].playerHand.hand.add(playerHand.hand.set(i, null));
            System.out.println("You gave them the card");
        } else {
            System.out.println("Burn failed");
            System.out.println(Game.players[victim].playerHand.hand.get(index));
            System.out.println("You get a penalty card");
            playerHand.hand.add(Deck.mainDeck.draw());
        }
    }
}
