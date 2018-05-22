package card;

import game.Player;

public class LookSelfCard extends Card implements PowerBoiSingle {

    public LookSelfCard(int value, String name) {
        super(value, name);
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
