package card;

import game.Player;

public class LookSwapCard extends Card implements PowerBoiDouble {

    public LookSwapCard(int value, String name) {
        super(value, name);
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
