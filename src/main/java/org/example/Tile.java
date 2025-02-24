package org.example;

public class Tile {

    private boolean isFlipped; //determines if tile has been flipped
    boolean isFlagged; // determines if tile has been flagged
    private boolean isMine; // determines if tile is a mine
    private int adjacentMines; // stores number of mines adjacent to tile

    public Tile(boolean isMine) { // constructor for tile class taking isMine as a parameter
        this.isMine = isMine;
        this.isFlipped = false;
        this.isFlagged = getIsFlagged();
        this.adjacentMines = 0;
    }

    // getters
    public boolean getIsMine() {
        return isMine;
    }

    public boolean getIsFlagged(){
        return isFlagged;
    }

    public boolean getIsFlipped() {
        return isFlipped;
    }

    // setters
    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }


    public void setAdjacentMines(int count) {
        this.adjacentMines = count;
    }

    public String toString(){ // logic for printing string value of tile symbols, called when printing an object to the console
        if (isFlagged) { // display F for flagged tiles
            return "F";
        }
        if (!isFlipped) { // if tile not yet flipped
            return "X"; // display an X for empty tiles
            }

        if (isMine) { // if tile is flipped and tile is a mine
            return "O"; // display O for mines
        }

        if (adjacentMines > 0) { // if there are any mines adjacent to the flipped tile
            return String.valueOf(adjacentMines); // return number of adjacent mines
        }

        return "-"; // if tile is flipped and no adjacent mines, display a dash

    }

    public boolean isTileEmpty() { // method to check if tile is not a mine and there are no adjacent mines
        return !isMine && adjacentMines == 0;
    }

}
