package com.minesweeper;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Tile extends Button {
    Tile[][] parentMap;

    private boolean revealed = false;
    private boolean hasBomb;

    int size;
    Vector2 mapPosition;
    Vector2 windowPosition;

    Tile(Tile[][] parentMap, int size, Vector2 mapPosition, boolean hasBomb)
    {
        this.parentMap = parentMap;

        this.size = size;
        this.setPrefSize(size, size);

        this.mapPosition = mapPosition;
        windowPosition = new Vector2(mapPosition.x * size, mapPosition.y * size);

        this.setLayoutX(windowPosition.x);
        this.setLayoutY(windowPosition.y);

        this.hasBomb = hasBomb;

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
            {
                if (!revealed)
                {
                    reveal();
                }
            }
        );
    }

    public void updateSize(int size)
    {
        this.setPrefSize(size, size);
    }

    public void updatePosition(int x, int y)
    {
        mapPosition.x = x;
        mapPosition.y = y;

        windowPosition = new Vector2(mapPosition.x * size, mapPosition.y * size);

        this.setLayoutX(windowPosition.x);
        this.setLayoutY(windowPosition.y);
    }

    public void reveal()
    {
        if (hasBomb)
        {
            this.setStyle("-fx-background-color: red");
        }
        else
        {
            this.setStyle("-fx-background-color: whitesmoke");
            
            // Find number of neigboring bombs and set graphic to number
            int numOfNeigboringBombs = MapManager.getNeighboringBombCount(parentMap, this);
            this.setText(String.valueOf(numOfNeigboringBombs));

        }
        revealed = true;
    }

    public boolean getBombStatus()
    {
        return this.hasBomb;
    }
}
