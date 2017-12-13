import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private final Scanner sc = new Scanner(System.in);
	public boolean cambioCalled = false;
	public Player[] players;
	public int currentPlayer = 0;
	public int playerCambio = -12497;

	public void start(Player[] players) {
		this.players = players;

		//create and shuffle full Deck
		Player pTest = new Player();

		System.out.println(Deck.mainDeck.size());
		//testing things
		for(int i = 0; i < Deck.mainDeck.size(); i++) {
			System.out.print(Deck.mainDeck.get(i) + " ");
		}

		System.out.println();
		System.out.println(Deck.mainDeck.draw());

		for(int i = 0; i < Deck.mainDeck.size(); i++) {
			System.out.print(Deck.mainDeck.get(i) + " ");
		}

	}

	public void clearConsole() {
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
	}

	public void showComputer() {
		clearConsole();

		System.out.print("Show everyone the computer, then press enter: ");
		sc.nextLine();

	}

	public void hideComputer() {
		clearConsole();

		System.out.print("Hide the computer, then press enter: ");
		sc.nextLine();

	}

	private void nextPlayer() {
		currentPlayer++;
		if (currentPlayer >= players.length) {
			currentPlayer = 0;
		}
	}

	public boolean hasPower(int card) {

		ArrayList<Integer> cardsWithPowers = new ArrayList<Integer>();
		cardsWithPowers.add(13);
		cardsWithPowers.add(12);
		cardsWithPowers.add(11);
		cardsWithPowers.add(10);
		cardsWithPowers.add(9);
		cardsWithPowers.add(8);
		cardsWithPowers.add(7);

		if (cardsWithPowers.contains(card)) {

			return true;

		} else {

			return false;

		}
	}

	public void activatePower (int card) {

		if (card == 7 || card == 8) {

			System.out.println("You can look at a card! Which card do you want to see? \n" + players[currentPlayer]);
			int index = sc.nextInt();
			players[currentPlayer].seeCard(index);

		} else if (card == 9 || card == 10) {

			System.out.println("You can look at someone else's card! Whose card do you want to see? 1, 2, 3, or 4?");
			int victim = sc.nextInt() - 1;
			System.out.println("Which card do you want to see? \n" + players[victim]);
			int index = sc.nextInt();
			players[victim].seeCard(index);

		} else if (card == 11 || card == 12) {

			System.out.println("You can blind swap! Who do you want to swap with? 1, 2, 3, 4");
			int victim = sc.nextInt() - 1;
			System.out.println("Which card do you want to swap? \n" + players[victim]);
			int index = sc.nextInt();
			System.out.println("Which of your cards do you want to swap? \n" + players[currentPlayer]);
			int playerIndex = sc.nextInt();
			players[currentPlayer].blindSwap(players[victim], index, playerIndex);

		} else {

			System.out.println("You can blind swap! Who do you want to swap with? 1, 2, 3, 4");
			int victim = sc.nextInt() - 1;
			System.out.println("Which card do you want to swap? \n" + players[victim]);
			int index = sc.nextInt();
			System.out.println("Which of your cards do you want to swap? \n" + players[currentPlayer]);
			int playerIndex = sc.nextInt();
			players[currentPlayer].lookSwap(players[victim], index, playerIndex);

		}
	}

	public void takeTurn(Player player) {

		nextPlayer();
		showComputer();

		if (cambioCalled && currentPlayer == playerCambio) {
			//sum of person called cambio
			int playerSum = players[playerCambio].playerHand.getSum();

			for(int i = 0; i < players.length; i++) {

				if(i == playerCambio) {
					i++;
					if(i > players.length) {
						break;
					}
				}

				int sum = players[i].playerHand.getSum();

				if (sum < playerSum) {
					System.out.println("Player " + (i + 1) + " wins!!!!");
					System.exit(0);
				} else {
					System.out.println("Player " + (playerCambio + 1) + "wins!!!!");
					System.exit(0);
				}
			}
		}

		System.out.println("It's " + player.name + "'s turn.");
		System.out.print("Do you call cambio (y/n)? ");
		String cambio = sc.nextLine();

		if (cambio.equalsIgnoreCase("y")) {
			cambioCalled = true;
			playerCambio = currentPlayer;
			return;
		}

		hideComputer();
		int newCard = Deck.mainDeck.draw();
		System.out.print("You drew: " + newCard + ". Do you want to keep this card (y/n)? ");
		String keep = sc.nextLine();

		if (keep.equalsIgnoreCase("y")) {
			System.out.println("Which card do you want to swap with? \n" + player);
			String index = sc.nextLine();
			player.swap(Integer.parseInt(index), newCard);
		} else {
			Deck.burnedDeck.add(newCard);
			if(hasPower(newCard)) {
				activatePower(newCard);
			}
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();
		Player[] players = {p1, p2, p3, p4};

		game.start(players);

		while(true) {
			game.takeTurn(players[game.currentPlayer]);
		}
	}
}
