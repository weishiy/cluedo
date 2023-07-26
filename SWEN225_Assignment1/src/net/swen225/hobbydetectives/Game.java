package net.swen225.hobbydetectives;

public class Game {

    private Board board; // game board

    /**
     * Main constructor, set up for game's need, but not finished yet.
     */
    public Game() {
        this.board = new Board();
    }

    /**
     * Main function for running the game
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game();
    }

}
