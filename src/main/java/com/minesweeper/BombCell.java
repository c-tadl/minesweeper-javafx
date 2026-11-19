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
        System.out.println("YOU LOSE :(");
    }

    @Override 
    public void flag()
    {
        super.flag();
        if (getFlagStatus())
        {
            manager.numOfFlaggedBombs++;
            System.out.println("Flagged Bombs: " + manager.numOfFlaggedBombs);

            if (manager.numOfFlaggedBombs == manager.numOfBombs)
            {
                System.out.println("YOU WIN!!!");
            }
        }
        else
        {
            manager.numOfFlaggedBombs--;
            System.out.println("Flagged Bombs: " + manager.numOfFlaggedBombs);
        }
    }
}
