package net.swen225.hobbydetectives;

import GUI.GameGUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Board board; // game board
    private final List<Player> playerList = new ArrayList<>();
    private int currentPlayerIndex;
    private GameGUI gameGUI;

    /**
     * Main constructor, set up for game's need, but not finished yet.
     */
    public Game() {
        board = new Board();
        // print board for debugging purpose
        System.out.print(board);

        playerList.add(new Player("Bert", Color.YELLOW, board.inspectTile(9,1)));
        playerList.add(new Player("Lucilla", Color.GREEN,board.inspectTile(1,11)));
        playerList.add(new Player("Percy", Color.RED,board.inspectTile(15,22)));
        playerList.add(new Player("Malina", Color.BLUE,board.inspectTile(22,9)));

        currentPlayerIndex = 0;

        gameGUI = new GameGUI(this);
        gameGUI.setVisible(true);
    }

    /**
     * Main function for running the game
     * @param args
     */

    public static void main(String[] args) {
        Game board = new Game();
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public Player getCurrentPlayer() {
        return playerList.get(currentPlayerIndex);
    }

    public void moveCurrentPlayer(Direction direction) {
        var currentPlayer = getCurrentPlayer();
        var tile = board.getDirectionTile(currentPlayer.getCurrentTileLocation(), direction);
        if (tile != null && tile.tileType().accessible()) {
            currentPlayer.move(tile);
        }
    }

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
    }
}
