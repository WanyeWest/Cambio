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

	private ArrayList<Card> deck;

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
	private Deck(Card[] cards) {
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

}
