package org.example;

import java.util.Scanner;

public class Game {
    private Board board; // create board object
    private boolean isGameOver; // create boolean to check if game is over
    private Scanner scanner; // create scanner object to take user input


    public Game(int width, int height, int numMines) { // parameters for board dimensions and number of mines
        this.board = new Board(width, height, numMines); // feed game constructor parameters into board constructor
        this.isGameOver = false; // initially set game over to false
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        while (!isGameOver) { // loop until game over condition is true
            board.printBoard();
            System.out.print("Enter x and y coordinates to flip a tile, or 'F x y' to flag/unflag a tile: ");

            String input = scanner.next(); // read user's first letter or number entered and store as a string

            if (input.equalsIgnoreCase("F")) { // if user inputs f or F
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                handleTileFlag(x, y); // call method to flag tile
            } else {
                int x = Integer.parseInt(input); // need to convert x into integer as it previously was a string
                int y = scanner.nextInt();
                handleTileFlip(x, y); // call method to flip tile
            }
        }
    }

    private void handleTileFlip(int x, int y) { //
        if (!isValidMove(x, y)) { // if coordinates are not within board bounds
            System.out.println("Invalid move. Try again."); // prompt user to enter coords again
            return;
        }

        board.flipTile(x, y); // flip tile at coordinates x,y


        if (board.getTile(x, y).isMine()) { //if flipped tile is a mine
            endGame(false); // end the game and display game over message
        } else if (checkWin()) { // if game is won
            endGame(true); // end the game and display win message
        }
    }

    private void handleTileFlag(int x, int y) {
        if (!isValidMove(x, y)) { // check if coordinates are within board bound
            System.out.println("Invalid move. Try again."); // print invalid message error
            return;
        }

        Tile tile = board.getTile(x, y); // get tile coordinates of tile currently being flagged

        if (tile.isFlipped()) { // if tile is already flipped
            System.out.println("You cannot flag a revealed tile."); // print error message
            return;
        }


        tile.setFlagged(!tile.isFlagged()); // switch flag state
    }

    private boolean checkWin() {
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) { // loop through every board tile
                Tile tile = board.getTile(x, y);
                if (!tile.isMine() && !tile.isFlipped()) { // check that current tile is not a mine and has not been flipped
                    return false; // there are still unflipped empty tiles
                }
            }
        }
        return true; // all tiles that are not mines have been flipped
    }

    private void endGame(boolean won) { // method to end the game
        isGameOver = true;
        board.printBoard(); // print board one last time
        if (won) {
            System.out.println("Congratulations, you won! :)"); // print win message
        } else {
            System.out.println("Game over! You hit a mine :("); // print loss message
        }
    }


    private boolean isValidMove(int x, int y) { // method to validate coordinates
        return x >= 0 && x < board.getWidth() && y >= 0 && y < board.getHeight(); // check if coordinates entered are within board bounds
    }
}