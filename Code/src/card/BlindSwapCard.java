package card;

import game.Player;

public class BlindSwapCard extends Card implements PowerBoiDouble {

    public BlindSwapCard(int value, String name) {
        super(value, name);
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
