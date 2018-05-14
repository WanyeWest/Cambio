package card;

import java.util.Scanner;
import game.Player;
import game.Deck;

public abstract class Card {
    private Scanner sc = new Scanner(System.in);
    public int value;
    public String name;

    /**
     * Constructor for cards
     * @param value
     */
    public Card(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public void onDraw(Player player) {
        System.out.println(this);
        System.out.println("Do you want to keep this card? (y/n)");
        if(sc.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Which one of your cards do you want to swap it with?");
            System.out.println(player.playerHand);
            int cardIndex = sc.nextInt();
            Card temp = player.playerHand.hand.get(cardIndex);
            Deck.burnedDeck.add(temp);
            player.playerHand.hand.set(cardIndex, temp);

        }
    }

    public int getValue() {
        return value;
    }

    public int compareTo(Card card) {
        if (value > card.getValue()) {
            return 1;
        } else if (value < card.getValue()){
            return -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return "Card is: " + name + "\nValue: " + value;
    }
}
