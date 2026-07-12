# Minesweeper

A **Java** implementation of the classic Minesweeper game, built from scratch.

<!-- Add a screenshot or short GIF of the game here — great for a game project:
![Minesweeper screenshot](./screenshot.png)
-->

## About

Recreates the classic Minesweeper: uncover cells on a grid without detonating a hidden mine. Uncovering a cell reveals the number of mines in the adjacent cells, and empty regions flood-fill automatically. Flag the cells you suspect are mines, and clear the board to win.

## Features

<!-- Adjust to match your implementation -->
- Grid generation with randomly placed mines
- Recursive reveal (flood fill) of empty cells
- Flagging cells
- Win/lose detection

## Tech stack

- Java
<!-- If it uses a GUI toolkit, name it here, e.g. Swing / JavaFX. If it's console-based, say so. -->

## Getting started

**Prerequisites:** JDK 17+ (and IntelliJ IDEA if you want to run it from the IDE).

**From IntelliJ:** open the project and run the `Main` class in `src/main/java/org/example`.

**From the command line:**

```bash
# compile
javac -d out src/main/java/org/example/*.java
# run (replace Main with your entry-point class if different)
java -cp out org.example.Main
```

## Notes

Built as a personal project to practise core Java — 2D arrays, recursion (the flood-fill reveal), and game-state logic.
