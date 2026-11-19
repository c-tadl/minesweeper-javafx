package com.minesweeper;

public class BombCell extends Cell{
    BombCell(Cell[][] parentMap, int size, Vector2 mapPosition)
    {
        super(parentMap, size, mapPosition);
        this.hasBomb = true;
    }

    // Override reveal
}
