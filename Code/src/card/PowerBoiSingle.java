package card;

import game.Player;

/**
 * interface for cards with powers that only effect the current player
 */
public interface PowerBoiSingle {
    void power(Player current, int index);
}
