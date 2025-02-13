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

    private void setupStartingBoard(){ // initalise board
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = new Tile(false); // set board to have no mines initially
            }
        }
    }

    private void placeMines() {
        Random random = new Random(); // create random object
        int minesPlaced = 0; // initailse mines places to 0

        while (minesPlaced < numOfMines) {
            int x = random.nextInt(width);
            int y = random.nextInt(height); // generate random tile coordinates

            if (!tiles[x][y].isMine()) { // if mine is not already on current tile
                tiles[x][y] = new Tile(true); // add mine on tile
                minesPlaced++; // increment minesPlaced
            }
        }
    }




    public void printBoard() { // prints each element of 2d tiles array
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(tiles[x][y] + " "); // add space between elements for easier view
            }
            System.out.println();
        }
    }


}



