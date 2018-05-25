package game;

public class SortFun {



    public static void main(String[] args) {
        Deck sortFun = new Deck(Deck.cards);
        sortFun.printDeck();
        System.out.println("\n-------------------------\n");
        sortFun.reset(0,sortFun.deck.size());
        sortFun.printDeck();
    }
}
