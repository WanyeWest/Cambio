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


        for(int i = 0; i < players.length; i++) {
            for(int x = 0; x < 4; x++) {
                players[i].playerHand.hand.add(Deck.mainDeck.draw());
            }
        }

        for(Player i: players) {
            System.out.println(i.playerHand.hand);
        }

        Deck.burnedDeck.add(Deck.mainDeck.draw());
        System.out.println(Deck.burnedDeck.getTop());

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

    private boolean isLegal(int card) {
        if (card == Deck.burnedDeck.getTop()) {
            return true;
        }
        return false;
    }

    private void burnOther() {
        System.out.println("Which player are you? 1, 2, 3, 4");
        int playerBurn = sc.nextInt() - 1;
        System.out.println("Which player's card would you like to burn? 1, 2, 3, 4");
        int victimBurn = sc.nextInt() - 1;
        System.out.println("Which card would you like to burn? " + players[victimBurn]);
        int cardBurn = sc.nextInt() - 1;

        if (isLegal(cardBurn)) {
            System.out.println("Which card would you like to replace the burned card with? " + players[playerBurn]);
            int cardReplace = sc.nextInt();
            players[victimBurn].playerHand.burnCard(cardBurn, cardReplace);
        } else {
            System.out.println("That was the wrong card. You will receive a penalty.");
            players[playerBurn].playerHand.addCard(Deck.mainDeck.draw());
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
            System.out.println(players[currentPlayer].seeCard(index));

        } else if (card == 9 || card == 10) {

            System.out.println("You can look at someone else's card! Whose card do you want to see? 1, 2, 3, or 4?");
            int victim = sc.nextInt() - 1;
            System.out.println("Which card do you want to see? \n" + players[victim]);
            int index = sc.nextInt();
            System.out.println(players[victim].seeCard(index));

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

        showComputer();

        System.out.println("The card that was just burned is: " + Deck.burnedDeck.getTop());
        System.out.println("Does anyone want to burn a card? (y/n)");
        String burn = sc.nextLine();

        if (burn.equalsIgnoreCase("y")) {
            burnOther();
        }
    }
}