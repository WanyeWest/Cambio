package game;

import card.Card;

import java.util.ArrayList;

public class Hand {
	public ArrayList<Card> hand = new ArrayList<Card>();

	/**
	 * adds a card to the hand
	 * @param card the card that will be added
	 */
	public void addCard(Card card) {
		hand.add(card);
	}

	/**
	 * Adds a card in a specific index
	 * @param card Card that will be added
	 * @param index Index the card will be in
	 */
	public void addCard(Card card, int index) {
		hand.add(index, card);
	}

	/**
	 * Burns the card in the given index and replaces
	 * it with null
	 * @param index The index of the card to burn
	 */
	public void burnCard(int index) {
		Card burnedCard = hand.set(index, null);
		Deck.burnedDeck.add(burnedCard);
	}

	/**
	 * Burns a card in the given index and replaces
	 * it with a different card
	 * @param index The index of the card to burn
	 * @param replacement replacement card
	 */
	public void burnCard(int index, Card replacement) {
		Card burnedCard = hand.set(index, replacement);
		Deck.burnedDeck.add(burnedCard);
	}

	/**
	 * Gets the sum of the hand
	 * @return The sum
	 */
	public int getSum() {
		int sum = 0;
		for(int i = 0; i < hand.size(); i++) {
			if(hand.get(i) == null) {
				sum += 0;
			} else {
				sum += hand.get(i).getVal();
			}
		}
		return sum;
	}

	/**
	 * gets the number of cards
	 * @return the number of cards
	 */
	public int getNumCards() {
		int total = 0;
		for(int i = 0; i < hand.size(); i++) {
			if(hand.get(i) == null) {
				total += 0;
			} else {
				total++;
			}
		}
		return total;
	}

	/**
	 * Hand toString()
	 * indices that are null have (index)
	 * indices that aren't null have [index]
	 * @return formatted hand
	 */
	public String toString() {
		String out = new String();
		for(int i = 0; i < hand.size(); i++) {

			if(hand.get(i) == null) {
				out += "(" + i + "), ";
			} else {
				out += "[" + i + "], ";
			}
		}
		out = out.substring(0, out.length() - 2);
		return out;
	}
}