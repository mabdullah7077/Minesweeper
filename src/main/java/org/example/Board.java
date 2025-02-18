package org.example;

import java.util.Random;

public class Board {
    private int width; //  width of board
    private int height; // height of board
    private int numOfMines; // number of mines
    Tile[][] tiles; // create 2d array of tile objects

    public Board (int boardWidth, int boardHeight, int boardMines) { // constructor to initialise board with dimensions and number of mines
        this.width = boardWidth;
        this.height = boardHeight;
        this.numOfMines = boardMines;
        this.tiles = new Tile[width][height]; // create 2d array of tile objects with width and height dimensions
        setupBoard(); // initialise the game board
        placeMines(); // place mines on random coordinates on board
        calculateAdjacentMines(); // calculate number of adjacent mines for each tile if any
    }


    // getters
    public int getWidth(){
        return width;
    }

    public int getHeight() {
        return height;
        }

    public int getNumOfMines() { //getter method for board height
        return numOfMines;
    }

    public Tile getTile(int x, int y) { // getter method for tile from tile array
        if (isValidCoordinate(x, y)) { // check if coordinate is valid
            return tiles[x][y]; //return tile at xy coordinate
        }
        return null;
    }

    private void setupBoard(){ // initialise board
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = new Tile(false); // set board to have no mines initially
            }
        }
    }

    private void placeMines() {
        Random random = new Random(); // create random object
        int minesPlaced = 0; // initialise mines placed to 0

        while (minesPlaced < numOfMines) { // loop the process of placing a mine until numOfMines has been reached
            int x = random.nextInt(width); // generate random number between 0 and width of board
            int y = random.nextInt(height); // generate random number between 0 and height of board

            if (!tiles[x][y].getIsMine()) { // if mine is not already on current tile
                tiles[x][y] = new Tile(true); // replace tile with new tile that has a mine
                minesPlaced++; // increment minesPlaced
            }
        }
    }

    private void calculateAdjacentMines() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) { // loop through every tile on the board
                if (!tiles[x][y].getIsMine()) { // if tile is not a mine
                    tiles[x][y].setAdjacentMines(countAdjacentMines(x, y)); // call countAdjacentMines and set result to number of adjacent mines for current tile
                }
            }
        }
    }

    private int countAdjacentMines(int x, int y) { // count how many mines are surrounding tile at position xy
        int count = 0; // initialise count variable

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) { // loop through all neighbour tiles
                int newX = x + i; // calculate neighbour x coordinate
                int newY = y + j; // calculate neighbour y coordinate

                if (isValidCoordinate(newX, newY) && tiles[newX][newY].getIsMine()) { // if new coordinates are valid and the tile at those coordinates is a mine
                    count++; // increment mine count
                }
            }
        }
        return count; // return number of surrounding mines
    }

    private boolean isValidCoordinate(int x, int y) { // method do check if coordinates are within game bounds
        return x >= 0 && x < width && y >= 0 && y < height; // return false if invalid
    }

    public void flipTile(int x, int y) {
        if (!isValidCoordinate(x, y)) {
            return; // return nothing if invalid coordinates
        }

        if (tiles[x][y].getIsFlipped()){
            System.out.println("Tile already flipped"); // let user know that tile has already been flipped
        }

        if (!tiles[x][y].getIsFlipped()){
            tiles[x][y].setFlipped(true); // set isFlipped to true if it was previously false
            tiles[x][y].setFlagged(false); // fixes bug for flagged tiles staying flagged even if they are flipped
        }

        if (tiles[x][y].isTileEmpty()) { // If the tile is empty
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) { // loop through neighbour tiles
                    int newX = x + i;
                    int newY = y + j;
                    if (isValidCoordinate(newX, newY ) && !tiles[newX][newY].getIsFlipped()) { // validate neighbour tile coordinates and isFlipped status
                        flipTile(newX, newY); // recursively flip neighbour tiles
                    }
                }
            }
        }
    }

        public void printBoard() { // prints each element of 2d tiles array
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) { // loop through each element of array
                    System.out.print(tiles[x][y] + " "); // add space between elements for easier view
                }
                System.out.println(); // print new line after each row
            }
        }
    }




