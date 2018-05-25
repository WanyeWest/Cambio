package game;

import card.*;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	//Construct all of the cards
	static NormalCard joker = new NormalCard(0, "Joker");
	static NormalCard one = new NormalCard(1, "One");
	static NormalCard two = new NormalCard(2, "Two");
	static NormalCard three = new NormalCard(3, "Three");
	static NormalCard four = new NormalCard(4, "Four");
	static NormalCard five = new NormalCard(5, "Five");
	static NormalCard six = new NormalCard(6, "Six");
	static LookSelfCard seven = new LookSelfCard(7, "Seven");
	static LookSelfCard eight = new LookSelfCard(8, "Eight");
	static LookOtherCard nine = new LookOtherCard(9, "Nine");
	static LookOtherCard ten = new LookOtherCard(10, "Ten");
	static BlindSwapCard jack = new BlindSwapCard(10, "Jack");
	static BlindSwapCard queen = new BlindSwapCard(10, "Queen");
	static LookSwapCard rKing = new LookSwapCard(-1, "Red King");
	static LookSwapCard bKing = new LookSwapCard(10, "Black King");

	//Puts all of the cards into an unshuffled deck
	public static final Card[] cards = {
			rKing, rKing, joker, joker, joker, joker, one, one,
			one, one, two, two, two, two, three, three, three,
			three, four, four, four, four, five, five, five,
			five, six, six, six, six, seven, seven, seven, seven,
			eight, eight, eight, eight, nine, nine, nine, nine,
			ten, ten, ten, ten, jack, jack, jack, jack, queen,
			queen, queen, queen, bKing, bKing
	};

	//mainDeck is the deck that people draw from
	public static Deck mainDeck = new Deck(cards);

	//burnedDeck is the deck that people discard cards into
	public static Deck burnedDeck = new Deck();

	public ArrayList<Card> deck;

	/**
	 * Deck constructor
	 */
	private Deck() {
		this.deck = new ArrayList<Card>();
	}

	/**
	 * Deck constructor
	 * @param cards list of cards that go in the deck
	 */
	Deck(Card[] cards) {
		this.deck = new ArrayList<Card>();
		for (Card card : cards) {
			this.deck.add(card);
		}
		this.shuffle();
	}

	/**
	 * add a card to a deck
	 * @param card the card that you add to a deck
	 */
	public void add(Card card) {
		this.deck.add(card);
	}

	/**
	 * gets the top cad of the deck
	 * @return the top card
	 */
	public Card getTop() {
		return deck.get(deck.size() - 1);
	}

	/**
	 * gets the card at a specific index
	 * @param index index of the card
	 * @return the value
	 */
	public Card get(int index) {
		return deck.get(index);
	}

	/**
	 * Draws a card from a deck
	 * @return the card
	 */
	public Card draw() {
		return deck.remove(0);
	}

	/**
	 * returns the size of the deck
	 * @return the size
	 */
	public int size() {
		return deck.size();
	}

	/**
	 * shuffles the deck
	 */
	public void shuffle(){
		Collections.shuffle(deck);
	}


    /**
     * QUICKSORT
     * returns the amount of cards sorted. method sorts cards from lowest to highest
     */
	public int partition (int low, int high) {
		// pivot (Element to be placed at right position)
		int pivot = deck.get(high - 1).getVal();
		int i = low;  // Index of smaller element

		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (deck.get(j).getVal() <= pivot) {
				//i++;    // increment index of smaller element

				Card placeHolder = deck.get(i);
				deck.set(i, deck.get(j));
				deck.set(j, placeHolder);
				//Collections.swap(deck, i, j);
				i++;
			}
		}
		Card pH = deck.get(i - 1);

		deck.set(i - 1, deck.get(high - 1));
		deck.set(high - 1, pH);
		//Collections.swap(deck,i + 1, high);

		return (i + 1);
	}

    /**
     * provides range for sorting and uses partition
     */
	public void reset(int low, int high) {
		if (low < high) {
            /* pi is partitioning index, arr[pi] is now
               at right place */
			int pi = partition(low, high);
			reset(low, pi - 2);  // Before pi
			reset(pi + 1, high); // After pi
		}
	}

	public void printDeck() {
		for(Card i: deck) {
			System.out.println(i);
		}
	}
}
