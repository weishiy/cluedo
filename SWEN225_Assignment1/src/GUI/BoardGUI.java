package GUI;
import net.swen225.hobbydetectives.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;


/**
 * GUI class for displaying the game board of Hobby Detectives.
 */
public class BoardGUI extends JFrame{
    private Board board; // board object
    private Map<Tile, Color> characterColors = new HashMap<>();
    private int xOffset = 50;
    private int yOffset = 50;

    // Functional buttons
    private JButton rollButton;
    private JButton upButton;
    private JButton downButton;
    private JButton rightButton;
    private JButton leftButton;


    /**
     * Constructor for the BoardGUI class.
     *
     * @param board The Board object representing the game board.
     */

    public BoardGUI(Board board) {
        this.board = board;
        setTitle("Hobby Detectives Game");
        setSize(500 + xOffset, 500 + yOffset);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }
//    private void addButtons() {
//        // Create and set up the functional buttons
//        rollButton = new JButton("Roll Dice");
//        upButton = new JButton("Up");
//
//        // Add action listeners to the buttons
//        rollButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Your code to handle the "Roll Dice" button click
//            }
//        });
//
//        upButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Your code to handle the "Move Player" button click
//            }
//        });
//
//        // Create a panel to hold the buttons
//        JPanel buttonPanel = new JPanel(null);
//        // Set the bounds (position and size) for each button
//        rollButton.setBounds(100, 200, 100, 30); // x, y, width, height
//        upButton.setBounds(120, 200, 100, 30); // x, y, width, height
//
//        buttonPanel.add(rollButton);
//        buttonPanel.add(upButton);
//
//        // Add the button panel to the frame
//        add(buttonPanel, BorderLayout.SOUTH);
//    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int cellSize = 16; // set the cell size
        int boardSize = 24;
        int gridSize = boardSize * cellSize;
        int outerBorderSize = 4; // Adjust this value to set the thickness of the outer border


        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int x = j * cellSize + xOffset;
                int y = i * cellSize + yOffset;
                Tile tile = board.inspectTile(i, j);
                //String value = tile.value(); // get the till value
                g.setColor(getColorFromValue(tile)); // set the color depends on tile
                g.fillRect(x, y, cellSize, cellSize);

                if (tile.value().equals("_")) {
                    g.setColor(Color.BLACK);
                    g.drawLine(x, y, x, y + cellSize);
                    g.drawLine(x, y, x + cellSize, y);
                }
            }
        }

        ((Graphics2D) g).setStroke(new BasicStroke(outerBorderSize));
        g.setColor(Color.BLACK);
        g.drawRect(xOffset, yOffset, gridSize, gridSize );

    }

    /**
     * Get the color associated with a Tile.
     *
     * @param tile The Tile for which to retrieve the associated color.
     * @return The color associated with the given Tile.
     */
    private Color getColorFromValue(Tile tile) {
        String value = tile.value();

        switch (value) {
            case "#":
                return new Color(100,149,237);
//                Locations roomLocation = tile.getLocation();
//                switch (roomLocation) {
//                    case HAUNTED_HOUSE:
//                        return Color.LIGHT_GRAY; // You can choose your desired color
//                    case MANIC_MANOR:
//                        return Color.LIGHT_GRAY; // You can choose your desired color
//                    // Add more cases for other rooms as needed
//                    default:
//                        return Color.LIGHT_GRAY; // Default color for rooms

            case "@":
                return Color.GRAY;
            case "*":
                Player player = board.getPlayerForTile(tile);
                CharactersCard character = player.getCharacter();
                switch (character) {
                    case Bert:
                        return Color.YELLOW;
                    case Lucilla:
                        return Color.GREEN;
                    case Percy:
                         return Color.RED;
                    case Malina:
                         return Color.BLUE;
                    default:
                        return Color.BLACK; // Default color if character is not recognized
                }
            default:
                return Color.WHITE;
        }
    }

    public static void main(String[] args) {
        Board board = new Board(); //
        SwingUtilities.invokeLater(() -> {
            BoardGUI boardGUI = new BoardGUI(board);
            boardGUI.setVisible(true); //
        });
    }

}
