package net.swen225.hobbydetectives;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    private Characters character; // The character the player represents
    private Location currentLocation; // current location of the player
    private Set<Card> hand; // the list of the cards the player has
    private Estate roomIn; // the room the player is currently in
    private boolean lostGame; // player state if they have lost the game
    //private Estate lastRoom;

    /**
     * Player constructor
     */

    public Player(Characters character) {
        this.character = character;
        this.hand = new HashSet<>();
        this.roomIn = null;
        this.lostGame = false;
    }


    /**
     * get the character for player's representative
     */
    public Characters getCharacter() {
        return character;
    }

    /**
     * Add a card to the players' hand
     *
     * @param card
     */
    public void addToHand(Card card) {
        hand.add(card);
    }

    /**
     * Get all cards for player's hand
     */

    public Set<Card> getHands() {
        return hand;
    }

    /**
     * print the cards which the player hold
     */
    public void printHand() {
        System.out.print("player " + character + " cards: ");
        for (Card card : hand) {
            System.out.print(card + " ");
        }
        System.out.println();
    }

    /**
     * set player's currented location
     * @param location
     */
    public void setLocation(Location location) {
        this.currentLocation = location;
    }

    /**
     * return the player's location
     */
    public Location getCurrentLocation(){return currentLocation;}
    /**
     * is the player active or not
     */
    public boolean isLostGame() {
        return lostGame;
    }

    /**
     * Set the player state
     * @param lostGame
     */
    public void setLostGame(boolean lostGame){
        this.lostGame = lostGame;
    }

    /**
     * return the character representation on the board
     */
    @Override
    public String toString() {
        return switch (character) {
            case Lucilla -> "L";
            case Bert -> "B";
            case Malina -> "M";
            case Percy -> "P";
        };
    }
}

