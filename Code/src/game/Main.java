package game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        Player p3 = new Player("Player 3");
        Player p4 = new Player("Player 4");
        Player[] players = {p1, p2, p3, p4};
        game.start(players);

        while(true) {
            game.takeTurn(players[game.currentPlayer]);
        }
    }
}
