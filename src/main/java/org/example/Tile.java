package org.example;

public class Tile {

    private boolean isRevealed; // determines if tile has been flipped
    private boolean isMine; // determines if tile is a mine
    private int adjacentMines; // stores number of mines adjacent to tile

    public Tile(boolean isMine) { // constructor for tile class
        this.isMine = isMine;
        this.isRevealed = false;
        this.adjacentMines = 0;
    }

    public void revealTile() {
        if (isRevealed) { // if tile is already revealed, do nothing
            return;
        }

        isRevealed = true; // set is revealed boolean to true given previous if statement is not run

        if (isMine) {
            System.out.println("Game over! You blew up a mine!"); // print game over message if mine is hit
        } else if (adjacentMines == 0) {
            System.out.println("Empty tile revealed"); // print empty tile revealed if tile is not a mine and there are no adjacent mines
        } else {
            System.out.println("Tile with " + adjacentMines + " adjacent mines revealed"); // print tile and adjacent mines revealed
        }
    }

    // getters for tile attributes
    public boolean isMine() {
        return isMine;
    }

    public boolean isRevealed() {
        return isRevealed;
    }


    public int getAdjacentMines() {
        return adjacentMines;
    }

    // setter for adjacent mines attribute
    public void setAdjacentMines(int count) {
        this.adjacentMines = count;
    }

    public String displayTile(){
        if (!isRevealed) { // if tile not yet revealed
            return "-"; // display a dash on the tile
            }

        if (isMine) { // if tile is revealed and tile is a mine
            return "M"; // display M for mine
        }

        if (adjacentMines > 0) { // if there any mines adjacent to the revealed tile
            return String.valueOf(adjacentMines); // return number of adjacent mines
        }

        return " "; // if tile is revealed and no adjacent mines, return blank space

    }

}
