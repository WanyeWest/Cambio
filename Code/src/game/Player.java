package game;

import card.Card;

import java.util.Scanner;
import static game.Game.*;

public class Player {
	public Hand playerHand = new Hand();
	public String name;
	Scanner sc = new Scanner(System.in);

	public Player(String name) {
		this.name = name;
	}

	public void askBurn() {
        System.out.println("Do you want to burn?");
        System.out.println("Who's card do you want to burn? (1,2,3,4)");
        int burnee = sc.nextInt();
        if(burnee == currentPlayer) {
            System.out.println("Which of your cards do you want to burn?");
            System.out.println(Game.players[currentPlayer].playerHand);
            int index = sc.nextInt();
            burnSelf(index);
        } else {
            burnOther(burnee);
        }
    }

    public boolean isLegal(Card card) {
	    return card.equals(Deck.burnedDeck.getTop());
    }
}
