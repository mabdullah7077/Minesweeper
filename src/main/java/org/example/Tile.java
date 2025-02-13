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
            System.out.println("Game over! You hit a mine!");
        } else if (adjacentMines == 0) {
            System.out.println("Empty tile revealed.");
        } else {
            System.out.println("Tile with " + adjacentMines + " adjacent mines revealed.");
        }
    }

    // getters and setters
    public boolean isMine() {
        return isMine;
    }

    public boolean isRevealed() {
        return isRevealed;
    }


    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int count) {
        this.adjacentMines = count;
    }

}
