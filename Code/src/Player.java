import java.util.Scanner;

//each player has a hand
public class Player {	
	public Hand playerHand = new Hand();
	public String name = "Wayne";
	Scanner sc = new Scanner(System.in);

	public void lookSwap(Player victim, int victimIndex, int playerIndex) {
		String input;
		System.out.println("Your card: " + playerHand.hand.get(playerIndex));
		System.out.println("Their card: " + victim.playerHand.hand.get(playerIndex));
		System.out.println("Do you want to swap? (y / n)");
		input = sc.nextLine();
		if(input.equalsIgnoreCase("y")) {
			int playerCard = playerHand.hand.get(playerIndex);
			playerHand.hand.set(playerIndex, victim.playerHand.hand.get(victimIndex));
			victim.playerHand.hand.set(victimIndex, playerCard);
		} else {
			System.out.println("Swap cancelled");
		}
	}
	
	public void swap(int playerIndex, int card) {
		int currentCard = playerHand.hand.set(playerIndex, card);
		Deck.burnedDeck.add(currentCard);
	}
	
	public int getCard(int index) {
		return playerHand.hand.get(index);
	}
	
	public void blindSwap(Player victim, int victimIndex, int playerIndex) {
		int victimCard = victim.getCard(victimIndex);
		playerHand.hand.set(playerIndex, victimCard);
		System.out.println("Swap successful.");
	}
	
	public int seeCard(int index) {
		return playerHand.hand.get(index);
	}
	
	public String toString() {
		String output = "Card Indexes: ";
		for(int i = 0; i < playerHand.hand.size(); i++) {
			if(playerHand.hand.get(i) == null) {
				output += null + ", ";
			}else {
				output += i + ", ";
			}
		}
		return output;
	}
}
