package org.example;

import java.util.Random;

public class Board {
    private int width; //  width of board
    private int height; // height of board
    private int numOfMines; // number of mines
    Tile[][] tiles; // create 2d array of tile objects

    public Board (int boardWidth, int boardHeight, int boardMines) { // constructior to intialise board with dimensions and nuumber of mines
        this.width = boardWidth;
        this.height = boardHeight;
        this.numOfMines = boardMines;
        this.tiles = new Tile[width][height]; // create 2d array of tile objects with width and height dimensions
        setupStartingBoard();
        printBoard();
    }

    public int getWidth(){ //getter method for board width
        return width;
    }

    public int getHeight() { //getter method for board height
        return height;
    }

    public Tile getTile(int x, int y){ // getter method for specific tile at given x and y coordinates
        return tiles[x][y];
    }

    private void setupStartingBoard(){
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = new Tile(false);
            }
        }
    }

    public void printBoard() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(tiles[x][y] + " ");
            }
            System.out.println();
        }
    }



}
