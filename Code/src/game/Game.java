package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private final Scanner sc = new Scanner(System.in);
    private boolean cambioCalled = false;
    private int playerCambio = -12497;
    public static int currentPlayer = 0;
    public static Player[] players = new Player[4];

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
                players[i].playerHand.hand.addCard(Deck.mainDeck.draw());
            }
        }

        //prints out all the player's hands for testing
        for(int i = 0; i < players.length; i++) {
            System.out.println("game.Player " + (i + 1) + " cards: " + players[i].playerHand.hand);
        }

        clearConsole();

        //prints each the bottom 2 cards in a player's hand
        for(int i = 0; i < players.length; i++) {
            hideComputer();
            System.out.println("game.Player " + (i + 1) + " cards: \n" +
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
        System.out.println("Does anyone want to burn a card? (y/n)");
        String burn = sc.nextLine();

        if (burn.equalsIgnoreCase("y")) {
            System.out.println("Which player would like to burn a card? 1, 2, 3, 4");
            int playerBurn = sc.nextInt() - 1;
            System.out.println("Are you burning one of your own cards? (y/n)");
            String burnSelf = sc.next();
            if (burnSelf.equalsIgnoreCase("y")) {
                game.Player.burnSelf(playerBurn);
            } else {
                burnOther(playerBurn);
            }
        }
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

//    /**
//     * Method that lets person burn a card
//     * @param burner the player that is doing the burning
//     */
//    private void burnOther(int burner) {
//        //choose the player the player that will lose the card and index of the card
//        System.out.println("Which player's card would you like to burn? 1, 2, 3, 4");
//        int victimBurn = sc.nextInt() - 1;
//        System.out.println("Which card would you like to burn? " + players[victimBurn]);
//        int cardBurn = sc.nextInt();
//
//        //checks if the burn is legal
//        if (isLegal(players[victimBurn].playerHand.hand.get(cardBurn))) {
//            System.out.println("Which card would you like to replace the burned card with? " + players[burner]);
//            int cardReplace = sc.nextInt();
//            players[victimBurn].playerHand.burnCard(cardBurn, cardReplace);
//        } else {
//            System.out.println("That was the wrong card. You will receive a penalty.");
//            players[burner].playerHand.addCard(Deck.mainDeck.draw());
//        }
//    }
//
//    /**
//     * Method to burn your own card
//     * @param burner the player that is doing the burning
//     */
//    private void burnSelf(int burner) {
//        //choose which card gets burned
//        System.out.println("Which card would you like to burn? Options: " + players[burner]);
//        int cardBurn = sc.nextInt();
//
//        //checks if the burn is legal
//        if (isLegal(players[burner].playerHand.hand.get(cardBurn))) {
//            System.out.println("You have burned a card");
//        } else {
//            System.out.println("That was the wrong card. You will receive a penalty.");
//            players[burner].playerHand.addCard(Deck.mainDeck.draw());
//        }
//    }

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
                    System.out.println("game.Player " + (i + 1) + " wins!!!!");
                    System.out.println("Cards:");
                    for(int z = 0; z < players.length; z++) {
                        System.out.println("game.Player " + (z + 1) + " cards: " + players[z].playerHand.hand);
                    }
                    System.exit(0);

                } else {
                    System.out.println("game.Player " + (playerCambio + 1) + " wins!!!!");
                    System.out.println("Cards:");
                    for(int z = 0; z < players.length; z++) {
                        System.out.println("game.Player " + (z + 1) + " cards: " + players[z].playerHand.hand);
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

        showComputer();

        System.out.println("The card that was just burned is: " + Deck.burnedDeck.getTop());
        System.out.println("Does anyone want to burn a card? (y/n)");
        String burn = sc.nextLine();

        if (burn.equalsIgnoreCase("y")) {
            System.out.println("Which player would like to burn a card? 1, 2, 3, 4");
            int playerBurn = sc.nextInt() - 1;
            System.out.println("Are you burning one of your own cards? (y/n)");
            String burnSelf = sc.nextLine();
            if (burnSelf.equalsIgnoreCase("y")) {
                burnSelf(playerBurn);
            } else {
                burnOther(playerBurn);
            }
        }
    }
}