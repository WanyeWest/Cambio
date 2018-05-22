package card;

import game.Player;

/**
 * interface for cards with powers that target other players
 */
public interface PowerBoiDouble {
    void power(Player current, Player victim, int indexSelf, int indexVictim);
}
