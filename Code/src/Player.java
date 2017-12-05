import java.util.ArrayList;
import java.util.Scanner;

//each player has a hand
public class Player {	
	public Hand playerHand;
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
}
