package card;

import game.Deck;
import game.Game;
import game.Player;


public class LookOtherCard extends Card implements PowerBoiSingle {

    public LookOtherCard(int value, String name) {
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
            player.playerHand.burnCard(cardIndex, this);
            System.out.println("The card burned is: " + temp);
        } else if (sc.nextLine().equalsIgnoreCase("n")) {
            Deck.burnedDeck.add(this);
            System.out.println("The card is: " + this);
            gameI.askBurn();
            System.out.println("You can look another person's!");
            System.out.println("Which player do you want to look at? 1,2,3,4");
            Player victim = Game.players[sc.nextInt() - 1];
            System.out.println("Which card do you want to look at?");
            System.out.println(victim.playerHand);
            int index = sc.nextInt();
            power(victim, index);
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
