package com.minesweeper;

public class BombCell extends Cell{
    BombCell(MapManager manager, int size, Vector2 mapPosition)
    {
        super(manager, size, mapPosition);
        this.hasBomb = true;
    }

    @Override
    public void reveal()
    {
        super.reveal();
        this.setBackground(TextureManager.createBackground("textures/bomb_1.png"));
    }
}
