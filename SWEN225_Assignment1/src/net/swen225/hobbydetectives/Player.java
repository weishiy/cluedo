package net.swen225.hobbydetectives;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private final int x;
    private int y;
    private  String name;
    private  Color color;
    private Tile currentTileLocation;
    private Locations currentRoom = Locations.BOARD;
    private  ArrayList<Card> currentCards;
    private CharactersCard character; // The character the player represents
    private boolean hasLost; // player state if they have lost the game

    private Location roomIn; // the room the player is currently in
    /***
     * Creates a new Player object
     * @param name String - name of the player
     * @param color Color - colour representation of the player
     * @param x Int - X coordinate of the player's starting location
     * @param y Int - Y coordinate of the player's starting location
     * @param cards Variable - Card - A variable amount of refutation cards that the player may have
     */
    public Player(String name, Color color, int x, int y, Card... cards){
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
        Collections.addAll(currentCards, cards);
    }

    public Player(CharactersCard character, Color color, int x, int y) {
        this.currentCards =new ArrayList<>();
        this.character = character;
        this.hasLost = false;
        this.roomIn = null;
        this.color = color;
        this.x = x;
        this.y = y;


    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public void setCurrentRoom(Locations currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Locations getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentTileLocation(Tile currentTileLocation) {
        this.currentTileLocation = currentTileLocation;
    }

    public Tile getCurrentTileLocation() {
        return currentTileLocation;
    }

//    /***
//     * Checks if the player's refutation card contains a given query
//     * @param query String - query to search by
//     * @return True if the player does, else false.
//     */
//    public boolean queryCards(String query) {
//        for (RefuCard card : currentCards)
//            if (card.value().equals(query))
//                return true;
//        return false;
//    }

    /***
     * Moves the player into the given tile or room depending on the data of the tile
     * @param newTileLoc Tile - New tile to be moved into
     */
    public void move(Tile newTileLoc){
        //checks if it's a door or not
        if(newTileLoc.value().equals("@")){
            setCurrentRoom(newTileLoc.locations());
        } else {
            setCurrentTileLocation(newTileLoc);
        }
    }

}
