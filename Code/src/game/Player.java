package game;

import java.util.Scanner;

public class Player {
	public Hand playerHand = new Hand();
	public String name;
	Scanner sc = new Scanner(System.in);

	public Player(String name) {
		this.name = name;
	}
}
