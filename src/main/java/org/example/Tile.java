package org.example;

public class Tile {

    private boolean isFlipped; // determines if tile has been flipped
    private boolean isMine; // determines if tile is a mine
    private int adjacentMines; // stores number of mines adjacent to tile

    public Tile(boolean isMine) { // constructor for tile class taking isMine as a parameter
        this.isMine = isMine;
        this.isFlipped = false;
        this.adjacentMines = 0;
    }

    // getters for tile attributes
    public boolean isMine() {
        return isMine;
    }

    public boolean isFlipped() {
        return isFlipped;
    }


    public int getAdjacentMines() {
        return adjacentMines;
    }

    // setter for adjacent mines attribute
    public void setAdjacentMines(int count) {
        this.adjacentMines = count;
    }

    public void revealTileResult() { // outputs result once a tile has been flipped
        if (isFlipped) { // if tile is already flipped, return nothing
            return;
        }

        isFlipped = true; // set is revealed boolean to true given previous if statement is not run

        if (isMine) { // if user reveals a ine
            System.out.println("Game over! You blew up a mine!"); // print game over message if mine is hit
        } else if (adjacentMines == 0) { // if no adjacent mines in tile that user revealed
            System.out.println("Empty tile revealed"); // print empty tile revealed to console if tile is not a mine and there are no adjacent mines
        } else {
            System.out.println("Tile with " + adjacentMines + " adjacent mines revealed");
        }

    }

    public String toString(){ // logic for printing string value of board symbols
        if (!isFlipped) { // if tile not yet flipped
            return "-"; // display a dash on the tile
            }

        if (isMine) { // if tile is flipped and tile is a mine
            return "X"; // display X for mine
        }

        if (adjacentMines > 0) { // if there any mines adjacent to the flipped tile
            return String.valueOf(adjacentMines); // return number of adjacent mines
        }

        return " "; // if tile is flipped and no adjacent mines, return blank space

    }

    public boolean isTileEmpty() { // method to check if tile is not a mine and there are no adjacent mines
        return !isMine && adjacentMines == 0;
    }

}
