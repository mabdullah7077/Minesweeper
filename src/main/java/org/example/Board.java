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

        while (minesPlaced < numOfMines) { // loop the process of placing a mine until numOfMines has been reached
            int x = random.nextInt(width);
            int y = random.nextInt(height); // generate random tile coordinates

            if (!tiles[x][y].isMine()) { // if mine is not already on current tile
                tiles[x][y] = new Tile(true); // add mine on tile
                minesPlaced++; // increment minesPlaced
            }
        }
    }

    private void calculateAdjacentMines() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) { // loop through every tile on the board
                if (!tiles[x][y].isMine()) { // if tile is not a mine
                    tiles[x][y].setAdjacentMines(countAdjacentMines(x, y)); // call countAdjacentMines and set result to number of adjecent mines for current tile
                }
            }
        }
    }

    private int countAdjacentMines(int x, int y) { // count how many mines are surrounding tile at position x,y
        int count = 0; // initialise count variable

        for (int i = -1; i <= 1; i++) { // loop from -1 to 1 to cover left, current and right tile
            for (int j = -1; j <= 1; j++) { // loop from -1 to 1 to cover above, current and below tile
                int newX = x + i; // calculate new x coordinate
                int newY = y + j; // calculate new y coordinate

                if (tiles[newX][newY].isMine()) { // check if surrounding tile is a mine
                    count++; // increase adjacent mine count
                }
            }
        }
        return count;
    }

    public void revealTile(int x, int y) {
        if (tiles[x][y].isRevealed()) { // if tile is already revealed, do nothing
            return;
        }

        tiles[x][y].revealResult(); // print output of revealing current tile

        if (tiles[x][y].isEmpty()) { // If the tile is empty
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) { // loop through neighbour tiles
                    int newX = x + i;
                    int newY = y + j;
                    revealTile(newX, newY); // recursive function to reveal neighbour tiles
                    }
                }
            }
        }

    public void printBoard() { // prints each element of 2d tiles array
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) { // loop through each element of array
                System.out.print(tiles[x][y] + " "); // add space between elements for easier view
            }
            System.out.println();
        }
    }

}



