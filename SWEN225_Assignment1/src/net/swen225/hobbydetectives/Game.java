package net.swen225.hobbydetectives;

import GUI.GameGUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Board board; // game board
    private final List<Player> playerList = new ArrayList<>();
    private final GameGUI gameGUI;

    /**
     * Main constructor, set up for game's need, but not finished yet.
     */
    public Game() {
        board = new Board();
        // print board for debugging purpose
        System.out.print(board);

        playerList.add(new Player("Bert", Color.YELLOW,9,1));
        playerList.add(new Player("Lucilla", Color.GREEN,1,11));
        playerList.add(new Player("Percy", Color.RED,15,22));
        playerList.add(new Player("Malina", Color.BLUE,22,9));
        playerList.forEach(p -> p.setCurrentTileLocation(board.inspectTile(p.x(), p.y())));
        gameGUI = new GameGUI(this);

        SwingUtilities.invokeLater(() -> {
            gameGUI.setVisible(true);
        });
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
}
