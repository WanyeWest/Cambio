package card;

import game.Deck;
import game.Player;

import static game.Player.askBurn;

public class LookSelfCard extends Card implements PowerBoiSingle {

    public LookSelfCard(int value, String name) {
        super(value, name);
    }

    @Override
    public void onDraw(Player player) {
        System.out.println(this);
        System.out.println("Do you want to keep this card? (y/n)");
        if(sc.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Which one of your cards do you want to swap it with?");
            System.out.println(player.playerHand);
            int cardIndex = sc.nextInt();
            Card temp = player.playerHand.hand.get(cardIndex);
            Deck.burnedDeck.add(temp);
            player.playerHand.hand.set(cardIndex, this);
            System.out.println("The card is: " + temp);
        } else if (sc.nextLine().equalsIgnoreCase("n")) {
            Deck.burnedDeck.add(this);
            System.out.println("The card is: " + this);
            askBurn();
            System.out.println("You can look at one of you cards!");
            System.out.println("Which card do you want to look at?");
            System.out.println(player.playerHand);
            int index = sc.nextInt();
            power(player, index);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void power(Player current, int index) {
        System.out.println("Your card is: " + current.playerHand.hand.get(index));
    }
}
