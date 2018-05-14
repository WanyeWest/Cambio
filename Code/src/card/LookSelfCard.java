package card;

import game.Player;

public class LookSelfCard extends Card implements PowerBoiSelf {

    public LookSelfCard(int value, String name) {
        super(value, name);
    }

    @Override
    public void power(Player currentPlayer, int index) {

    }

    @Override
    public String toString() {
        return super.toString();
    }

}
