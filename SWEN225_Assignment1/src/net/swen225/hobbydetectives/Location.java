package net.swen225.hobbydetectives;

/**
 * This function designates the tiles of the game, allowing players to make their moves.
 */
public record Location(int x, int y, Estate estate, int door, Player player, boolean empty) {
    /**
     * default constructor
     * @param y
     * @param x
     */
    public Location(int y, int x) {
        this(y, x, null, 0, null, true);
    }

    /**
     * Room constructor
     * @param y
     * @param x
     * @param estate
     * @param door
     */
    public Location(int y, int x, Estate estate, int door) {
        this(y, x, estate, door, null, true);
    }

    /**
     * Sets the player onto the location marking it full
     * @param player
     * @return
     */
    public Location withPlayer(Player player) {
        return new Location(y, x, estate, door, player, player == null);
    }

    /**
     * Sets the location as empty
     * @param empty
     * @return
     */
    public Location withEmpty(boolean empty) {
        return new Location(y, x, estate, door, player, empty);
    }

    /**
     * Resturns the room type symbols that's marked on the board
     */
    public String toString() {
        // showing location representation
        if (empty) {
            // Printing corridor
            if (door == 0)
                return "[ ]";
                // showing door number
            else if (estate == null)
                return "<" + door + ">";
                // showing door entrance
            else
                return "[*]";
        }
        // showing player
        else {
            if (player != null)
                return "{" + player.toString() + "}";
            else {
                return "[x]";
            }
        }
    }
}