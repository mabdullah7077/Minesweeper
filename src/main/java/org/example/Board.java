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
    }

}
