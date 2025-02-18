package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select difficulty: E/M/H"); // user inputs difficulty level
            String input = scanner.next();
            if (input.equalsIgnoreCase("E")){
                Game game = new Game(5,5,2); // create easy game object
                game.startGame();
                break;
            } else if (input.equalsIgnoreCase("M")) {
                Game game = new Game(10, 10, 10); // create medium game object
                game.startGame(); // start the game
                break;
            } else if (input.equalsIgnoreCase("H")){
                Game game = new Game(15,15, 20); // create hard game object
                game.startGame();
                break;
            } else {
                System.out.println("Invalid input, please try again"); // Error message for invalid input
            }
        }
    }
}
