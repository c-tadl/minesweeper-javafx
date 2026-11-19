package com.minesweeper;

public class NumberCell extends Cell{
    private int neighboringBombCount;

    NumberCell(Cell[][] parentMap, int size, Vector2 mapPosition)
    {
        super(parentMap, size, mapPosition);
        this.neighboringBombCount = 5; // TEMPORARY VALUE
    }

    // Override Reveal
}
