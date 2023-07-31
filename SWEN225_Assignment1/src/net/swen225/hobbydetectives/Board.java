package net.swen225.hobbydetectives;

import java.awt.*;
import java.util.Map;

public class Board {

    private final Tile[][] board = new Tile[24][24];
    private Map<WeaponsCard, Location> weaponsLocation; // In which estate is the weapon stored
    /***
     * Creates a new board for the game to operate on.
     *
     */
    public Board(){
        setBoard();
//        for(Player p:players)
//            setPlayer(p, p.x(), p.y());
    }

    /***
     * Creates the full board representation and plots spaces between rooms
     */
    private void setBoard(){
        //the basics on setting up a room and a door
        // HAUNTED_HOUSE
        addRoom(2, 2, 6, 6, Locations.HAUNTED_HOUSE);
        setDoor(3, 6, Locations.HAUNTED_HOUSE);
        setDoor(6, 5, Locations.HAUNTED_HOUSE);
        // MANIC_MANOR
        addRoom(2, 17, 6, 21, Locations.MANIC_MANOR);
        setDoor(5, 17, Locations.MANIC_MANOR);
        setDoor(6, 20, Locations.MANIC_MANOR);
        // VISITATION_VILLA
        addRoom(10, 9, 13, 14, Locations.VISITATION_VILLA);
        setDoor(10, 12, Locations.MANIC_MANOR);
        setDoor(12, 9, Locations.MANIC_MANOR);
        setDoor(13, 11, Locations.MANIC_MANOR);
        setDoor(11, 14, Locations.MANIC_MANOR);
        // CALAMITY_CASTLE
        addRoom(17, 2, 21, 6, Locations.CALAMITY_CASTLE);
        setDoor(17, 3, Locations.CALAMITY_CASTLE);
        setDoor(18, 6, Locations.CALAMITY_CASTLE);
        //PERIL_PALACE
        addRoom(17, 17, 21, 21, Locations.PERIL_PALACE);
        setDoor(17, 18, Locations.PERIL_PALACE);
        setDoor(20, 17, Locations.PERIL_PALACE);

        //four grey areas
        addRoom(11, 5, 12, 6, Locations.GREY_AREA);
        addRoom(5, 11, 6, 12, Locations.GREY_AREA);
        addRoom(11, 17, 12, 18, Locations.GREY_AREA);
        addRoom(17, 11, 18, 12, Locations.GREY_AREA);

       // initial players' locations
       setPlayer(new Player(CharactersCard.Bert, Color.YELLOW,9,1));
       setPlayer(new Player(CharactersCard.Lucilla, Color.GREEN,1,11));
       setPlayer(new Player(CharactersCard.Percy, Color.RED,15,22));
       setPlayer(new Player(CharactersCard.Malina, Color.BLUE,22,9));


        for(int x = 0; x < 24; x++)
            for(int y = 0; y < 24; y++)
                if(board[x][y] == null)
                    board[x][y] = new Tile(x, y, "_", Locations.BOARD);
    }

    /***
     * Creates a room on the board
     * @param x1 Integer - Represents top left X coordinate
     * @param y1 Integer - Represents top left Y coordinate
     * @param x2 Integer - Represents bottom right X coordinate
     * @param y2 Integer - Represents bottom right Y coordinate
     * @param room Locations - Location enum representation
     */
    private void addRoom(int x1, int y1, int x2, int y2, Locations room){
        for (int x = x1; x < x2; x++) {
            board[x][y1] = new Tile(x, y1, "#", room);
            board[x][y2] = new Tile(x, y2, "#", room);
        }
        for (int y = y1; y <= y2; y++) {
            board[x1][y] = new Tile(x1, y, "#", room);
            board[x2][y] = new Tile(x2, y, "#", room);
        }
    }

    /***
     * Creates a new door Tile at specified coordinates
     * @param x Integer - Represents X axis
     * @param y Integer - Represents Y axis
     * @param room Location - Represents connected room
     */
    private void setDoor(int x, int y, Locations room){
        board[x][y] = new Tile(x, y, "@", room);
    }

    /***
     * Returns a Tile object from the specified coordinates of the board
     * @param x Integer - Represents X axis
     * @param y Integer - Represents Y axis
     * @return Tile - Tile found at X and Y coordinates
     */
    private Tile inspectTile(int x, int y){
        return board[x][y];
    }

    private void setPlayer(Player player){
        int x = player.x();
        int y = player.y();
        board[x][y] = new Tile(x, y, "*", player.getCurrentRoom());
    }

    /***
     * Returns a string representation of the current game board
     * @return String - The board
     */
    public String toString(){
        //I could remake this using streams, but that can be done later.
        String Sboard = "";
        for(int x = 0; x < 24; x++){
            for(int y = 0; y < 24; y++){
                Sboard = Sboard.concat(board[x][y].value());
            }
            Sboard = Sboard.concat("\n");
        }
        return Sboard;
    }

    /***
     * Returns the tile of a given directional input based off of a given tile
     * @param from Tile - Tile to measure direction from
     * @param d Direction - direction to get the next tile from
     * @return Tile - Tile object given by the direction
     */
    public Tile getDirectionTile(Tile from, Direction d){
        switch(d){
            case NORTH -> {
                return inspectTile(from.x(), from.y() + 1);
            }
            case SOUTH -> {
                return inspectTile(from.x(), from.y() - 1);
            }
            case EAST -> {
                return inspectTile(from.x() + 1, from.y());
            }
            case WEST -> {
                return inspectTile(from.x() - 1, from.y());
            }
            default ->
                throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        Board board1 = new Board();
        System.out.println(board1);
    }
}
