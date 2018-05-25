package game;

import card.Card;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private final Scanner sc = new Scanner(System.in);
    private boolean cambioCalled = false;
    private int playerCambio = -12497;
    public static int currentPlayer = 0;
    public static Player[] players;

    /**
     * Method that gets called before the start of the game
     * deals all of the cards to the players
     * @param players the players that are playing
     */
    public void start(Player[] players) {

        this.players = players;

        //Deal cards
        for(int i = 0; i < players.length; i++) {
            for(int x = 0; x < 4; x++) {
                players[i].playerHand.hand.add(Deck.mainDeck.draw());
            }
        }

        //prints out all the player's hands for testing
        for(int i = 0; i < players.length; i++) {
            System.out.println(players[i].name + " cards: " + players[i].playerHand.hand);
        }

        clearConsole();

        //prints each the bottom 2 cards in a player's hand
        for(int i = 0; i < players.length; i++) {
            hideComputer();
            System.out.println(players[i].name + " cards: \n" +
                    "index 0: " + players[i].playerHand.hand.get(0) + "\n" +
                    "index 1: " + players[i].playerHand.hand.get(1));
            if(i < players.length - 1) {
                System.out.println("When you are ready, press enter and pass computer to the next player");
                sc.nextLine();
            } else {
                System.out.println("Everyone has seen their cards");
            }
        }

        clearConsole();

        //the initial burn draw thing
        Deck.burnedDeck.add(Deck.mainDeck.draw());
        System.out.println("The initial card is: " + Deck.burnedDeck.getTop());

        System.out.println("Press enter once everyone has seen this card");
        sc.nextLine();

        askBurn();
    }

    /**
     * Method that "clears" the console by adding a lot of lines
     */
    public void clearConsole() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    /**
     * Method that tells the player to show the computer to everyone
     */
    public void showComputer() {
        clearConsole();

        System.out.print("Show everyone the computer, then press enter: ");
        sc.nextLine();

    }

    /**
     * Method that tells the player to hide the computer so that
     * people don't see what they are doing
     */
    public void hideComputer() {
        clearConsole();

        System.out.print("Hide the computer, then press enter: ");
        sc.nextLine();

    }

    /**
     * Method that goes increments the current player
     */
    private void nextPlayer() {
        currentPlayer++;
        if (currentPlayer >= players.length) {
            currentPlayer = 0;
        }
    }

    /**
     * The important method where all the stuff gets done
     * @param player the current player
     */
    public void takeTurn(Player player) {

        nextPlayer();
        showComputer();

        //Checks if cambio has been called and if it is the callers turn
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

                //gets the sum of the player at index i
                int sum = players[i].playerHand.getSum();

                if (sum < playerSum) {
                    System.out.println(players[i].name + " wins!!!!");
                    System.out.println("Cards:");
                    for(int z = 0; z < players.length; z++) {
                        System.out.println(players[z].name + " cards: " + players[z].playerHand.hand);
                    }
                    System.exit(0);

                } else {
                    System.out.println(players[playerCambio].name + " wins!!!!");
                    System.out.println("Cards:");
                    for(int z = 0; z < players.length; z++) {
                        System.out.println(players[z].name + " cards: " + players[z].playerHand.hand);
                    }
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
        Card newCard = Deck.mainDeck.draw();
        newCard.onDraw(player);

        showComputer();

        System.out.println("The card that was just burned is: " + Deck.burnedDeck.getTop());

        askBurn();
    }

    /**
     * Method that is to be called when you want to ask the player if they want
     * to burn a card. This should make the entire thing a lot easier to write
     */
    public void askBurn() {
        System.out.println("Does someone want to burn?");
        if(sc.nextLine().equalsIgnoreCase("y")){
            System.out.println("Which player would like to burn? 1,2,3,4");
            int burner = sc.nextInt();
            System.out.println("Who's card do you want to burn? (1,2,3,4)");
            int burnee = sc.nextInt();
            if(burnee == burner) {
                System.out.println("Which of your cards do you want to burn?");
                System.out.println(Game.players[burner].playerHand);
                int index = sc.nextInt();
                burnSelf(index);
            } else {
                System.out.println("Which of their cards do you want to burn?");
                System.out.println(Game.players[burnee - 1].playerHand);
                int index = sc.nextInt();
                burnOther(burnee, index);
            }
        }
    }

    /**
     * Checks if a burn is legal
     * @param card the card that is to be burned
     * @return true if card is the same as the top of burnedDeck, false if not the same
     */
    public static boolean isLegal(Card card) {
        return card.equals(Deck.burnedDeck.getTop());
    }

    /**
     * Called when player want to burn their own card
     * They choose a card, check if the burn is legal, if legal burn, else penalty
     * @param index the index of the card in their hand
     */
    public void burnSelf(int index) {
        if(isLegal(players[currentPlayer].playerHand.hand.get(index))) {
            System.out.println("Burn successful");
            Deck.burnedDeck.add(players[currentPlayer].playerHand.hand.set(index, null));
        } else {
            System.out.println("Burn failed");
            System.out.println("You get a penalty card");
            players[currentPlayer].playerHand.hand.add(Deck.mainDeck.draw());
        }
    }

    /**
     * Called when a player wants to burn another player's card
     * They choose a card, check if the burn is legal, if legal burn and give them card, else penalty and print card
     * @param victim the index of the victim
     * @param index
     */
    public void burnOther(int victim, int index) {
        if(isLegal(Game.players[victim].playerHand.hand.get(index))) {
            System.out.println("Burn successful");
            Deck.burnedDeck.add(Game.players[victim].playerHand.hand.set(index, null));
            System.out.println("Which card do you want to give them?");
            System.out.println(players[currentPlayer].playerHand);
            int i = sc.nextInt();
            Game.players[victim].playerHand.hand.add(players[currentPlayer].playerHand.hand.set(i, null));
            System.out.println("You gave them the card");
        } else {
            System.out.println("Burn failed");
            System.out.println(Game.players[victim].playerHand.hand.get(index));
            System.out.println("You get a penalty card");
            players[currentPlayer].playerHand.hand.add(Deck.mainDeck.draw());
        }
    }
}