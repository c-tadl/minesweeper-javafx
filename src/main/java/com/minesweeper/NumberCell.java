package com.minesweeper;

import javafx.scene.paint.Color;

public class NumberCell extends Cell{
    private int neighboringBombCount;

    NumberCell(MapManager manager, int size, Vector2 mapPosition)
    {
        super(manager, size, mapPosition);
    }

    @Override
    public void reveal()
    {
        super.reveal();
        this.setText(String.valueOf(neighboringBombCount));
        this.setTextFill(Color.BLACK);
    }

    public void setNeighboringBombCount()
    {
        this.neighboringBombCount = manager.getNeighboringBombCount(this);
    }
}
