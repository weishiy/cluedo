package net.swen225.hobbydetectives;

import java.util.*;
/**
 * The Board class stores information on player locations, grids, and room locations.
 */

import java.util.*;
public class Board {
    private static int BOARD_SIZE = 24;
    private Map<Characters, Location> startLocations;
    private Map<Estates, Estate> estateMap;

    private Map<Weapons, Estate> weaponsLocation; // In which estate is the weapon stored

    private Location[][] map;

    public Board(Location[][] map,  Map<Estates, Estate> estateMap, Map<Characters, Location> startingLocations){
        this.map = map;
        this.estateMap = estateMap;
        this.startLocations = startingLocations;
        setWeapons(); // adds the random weapons to different rooms
    }

    /**
     * to load the board.
     */
    public void loadBoard(){

    }

    /**
     * random weapons locations
     */
    public void setWeapons() {

        List<Estates> tempEstateList =List.of(Estates.values());
        List<Weapons> tempWeaponsList = List.of(Weapons.values());
        // because the room and weapon has same size in this game, so we do need to check for it.
        // random both estates
        Collections.shuffle(tempEstateList);

        for(int i=0; i<tempEstateList.size(); i++){
            Estate e = estateMap.get(tempEstateList.get(i));
            Weapons w = tempWeaponsList.get(i);
            weaponsLocation.put(w, e);
            e.addItem(w);
        }

    }
}
