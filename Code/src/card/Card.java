package card;

import java.util.Scanner;
import game.Deck;
import game.Game;
import game.Player;

public abstract class Card {
    public static Scanner sc = new Scanner(System.in);
    public int value;
    public String name;
    public Game gameI = new Game();

    /**
     * Constructor for cards
     * @param value
     */
    public Card(int value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * Gets value of cards
     */
    public int getVal(){ return value; }

    /**
     * This is called whenever a card is drawn
     * @param player the player that drew the card
     */
    public void onDraw(Player player) {
        System.out.println(this);
        System.out.println("Do you want to keep this card? (y/n)");
        if(sc.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Which one of your cards do you want to swap it with?");
            System.out.println(player.playerHand);
            int cardIndex = sc.nextInt();
            Card temp = player.playerHand.hand.get(cardIndex);
            Deck.burnedDeck.add(temp);
            player.playerHand.burnCard(cardIndex, this);
            System.out.println("The card burned is: " + temp);
        } else if (sc.nextLine().equalsIgnoreCase("n")) {
            Deck.burnedDeck.add(this);
            System.out.println("The card burned is: " + this);
            gameI.askBurn();
        }
    }

    /**
     * CompareTo method
     * @param card card to compare with
     * @return -1 if value is less, 0 if equal, 1 if more
     */
    public int compareTo(Card card) {
        if (value > card.getVal()) {
            return 1;
        } else if (value < card.getVal()){
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Checks if the card is equal to another card
     * @param card the card to be compared to
     * @return true if the obj is equal false otherwise
     */
    public boolean equals(Card card) {
        return super.equals(card);
    }

    public String toString() {
        return "Card is: " + name + "; Value: " + value;
    }
}
