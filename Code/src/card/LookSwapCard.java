package card;

import game.Deck;
import game.Player;

public class LookSwapCard extends Card implements PowerBoiDouble {

    public LookSwapCard(int value, String name) {
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
            System.out.println("You can look swap!");
            System.out.println("Which player do you want to swap with? (1,2,3,4)");
            Player victim = game.Game.players[sc.nextInt() - 1];
            System.out.println("What card do you want to give them?");
            System.out.println(player.playerHand);
            int playerIndex = sc.nextInt();
            System.out.println("What card do you want to take?");
            System.out.println(victim.playerHand);
            int victimIndex = sc.nextInt();
            power(player, victim, playerIndex, victimIndex);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void power(Player current, Player victim, int indexSelf, int indexVictim) {
        String input;
        System.out.println("Your card: " + current.playerHand.hand.get(indexSelf));
        System.out.println("Their card: " + victim.playerHand.hand.get(indexVictim));
        System.out.println("Do you want to swap? (y / n)");
        input = sc.nextLine();
        if(input.equalsIgnoreCase("y")) {
            Card playerCard = current.playerHand.hand.get(indexSelf);
            current.playerHand.hand.set(indexSelf, victim.playerHand.hand.get(indexVictim));
            victim.playerHand.hand.set(indexVictim, playerCard);
        } else {
            System.out.println("Swap cancelled");
        }
    }
}
