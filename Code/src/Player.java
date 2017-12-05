import java.util.ArrayList;

//each player has a hand
public class Player {	
	public Hand hand;
	
	public int getCard(int index) {
		return hand.hand.get(index);
	}
	
	public void blindSwap(Player victim, int victimIndex, int playerIndex) {
		int victimCard = victim.getCard(victimIndex);
		hand.hand.set(playerIndex, victimCard);
	}
	
}
