import java.util.Scanner;

public class Game {
	private final Scanner sc = new Scanner(System.in);
	public boolean cambioCalled = false;
	public Player[] players; 
	public int currentPlayer = 0;
	
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
    
    public void takeTurn(Player player) {
    	
    	nextPlayer();
    	showComputer();
    	
    	System.out.println("It's " + player.name + "'s turn.");
    	System.out.print("Do you call cambio (y/n)? ");
    	String cambio = sc.nextLine();
    	
    	if (cambio.equalsIgnoreCase("y")) {
    		cambioCalled = true;
    		return;
    	}
    	
    	hideComputer();
    	int newCard = Deck.mainDeck.draw();
    	System.out.print("You drew: " + newCard + ". Do you want to keep this card (y/n)? ");
    	String keep = sc.nextLine();
    	if (keep.equalsIgnoreCase("y")) {
    		System.out.println("Which card do you want to swap with? Options:");
    		String index = sc.nextLine();
    	}
    	
    }
    
}
