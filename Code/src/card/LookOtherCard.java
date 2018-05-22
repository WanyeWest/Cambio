package card;

import game.Deck;
import game.Player;

public class LookOtherCard extends Card implements PowerBoiSingle {

    public LookOtherCard(int value, String name) {
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
