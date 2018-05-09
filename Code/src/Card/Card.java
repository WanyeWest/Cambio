package Card;

import java.util.Scanner;

public abstract class Card {
    private Scanner sc = new Scanner(System.in);
    static int value;

    public Card(int value) {
        this.value = value;
    }

    /**
     * The method is called whenever you draw the card
     * Asks the player if they want to keep the card
     * if they want to keep the card, ask which card do they want to swap the card with
     *      place new card in hand and put old card in pile
     * if they don't  want to keep the card, place the new card in the pile
     */
    public void onDraw() {
        System.out.println("The card is a " + value);
        System.out.println("Do you want to keep this card? (y/n)");
        if (sc.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Which one of your cards do you want to swap it with?");
        }
    }

    /**
     * @return the value of the card
     */
    private static int getValue() {
        return value;
    }

    /**
     * @param card The card that you are comparing to
     * @return -1 if the value of your card is less, 1 if more, 0 if equal
     */
    public int compareTo(Card card) {
        if (value > Card.getValue()) {
            return 1;
        } else if (value < Card.getValue()) {
            return -1;
        } else {
            return 0;
        }
    }
}
