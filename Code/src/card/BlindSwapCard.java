package card;

import game.Deck;
import game.Player;

public class BlindSwapCard extends Card implements PowerBoiDouble {

    public BlindSwapCard(int value, String name) {
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
            System.out.println("You can blind swap!");
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
        Card victimCard = victim.playerHand.hand.get(indexVictim);
        current.playerHand.hand.set(indexSelf, victimCard);
        System.out.println("Swap successful.");
    }
}
