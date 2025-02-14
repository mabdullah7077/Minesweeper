package org.example;

import java.util.Scanner;

public class Game {
    private Board board;
    private boolean isGameOver;
    private Scanner scanner;

    // Constructor: Initializes the board and scanner
    public Game(int width, int height, int numMines) {
        this.board = new Board(width, height, numMines);
        this.isGameOver = false;
    }


    private void handleMove(int x, int y) {
        if (!isValidMove(x, y)) {
            System.out.println("Invalid move, try again."); // print invalid move message
            return;
        }
        board.flipTile(x, y); // flip tile at x,y coordinate
    }

    // Validates if the move is within bounds
    private boolean isValidMove(int x, int y) { // check if coordinates entered are within board bounds
        return x >= 0 && x < board.getWidth() && y >= 0 && y < board.getHeight();
    }
}