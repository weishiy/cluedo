package net.swen225.hobbydetectives;


import java.util.*;

/**
 * represent each estate with location and items(characters or weapons) in the game.
 */
public class Estate {
    private final EstatesCard estate;
    private final Set<Card> items;
    private final Map<Integer, Location> locations;

    /**
     * A room constructor that accepts a room enum and initializes the items.
     * @param estatesCard
     * @param estate
     * @param items
     * @param locations
     */
    public Estate(EstatesCard estatesCard, EstatesCard estate, Set<Card> items, Map<Integer, Location> locations) {
        this.estate = estate;
        this.items = items;
        this.locations = locations;
    }

    /**
     * Adding a location "entrance" to the room.
     *
     * @param door The door number.
     * @param location The location to add.
     */
    public void addLocation(int door, Location location){
        locations.put(door, location);
    }

    /**
     * Adding an item such as a player or weapon to the room.
     *
     * @param item The item to add.
     */
    public void addItem(Card item) {
        items.add(item);
    }

    /**
     * Removing an item from this estate.
     *
     * @param item The item to remove.
     */
    public void removeItem(Card item) {
        items.remove(item);
    }

    /**
     * Returns the map of locations in the estate.
     *
     * @return The map of locations.
     */
    public Map<Integer, Location> getLocations() {
        return locations;
    }

    /**
     * Returns the current estate.
     *
     */
    public EstatesCard getEstate() {
        return estate;
    }

    /**
     * Returns the items in the estate as a string representation.
     *
     * @return The string representation of the items in the estate.
     */
    public String itemsToString() {
        if (items.isEmpty()) {
            return "No items in the estate.";
        }
        return items.toString();
    }

    /**
     * Returns a string representation of the estate.
     *
     * @return The string representation of the estate.
     */
    @Override
    public String toString() {
        return "Estate: " + estate + "\nItems: " + itemsToString();
    }
}
