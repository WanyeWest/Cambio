package game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Player p1 = new Player("Wayne");
        Player p2 = new Player("Grace");
        Player p3 = new Player("Chris");
        Player p4 = new Player("Ethan");
        Player[] players = {p1, p2, p3, p4};

        game.start(players);

        while(true) {
            game.takeTurn(players[game.currentPlayer]);
        }
    }
}
