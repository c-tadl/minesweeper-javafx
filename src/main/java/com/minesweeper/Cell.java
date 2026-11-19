package com.minesweeper;

import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public abstract class Cell extends Button {
    Cell[][] parentMap;

    private boolean isRevealed = false;
    private boolean isFlagged = false;
    protected boolean hasBomb;

    int size;
    Vector2 mapPosition;
    Vector2 windowPosition;

    Cell(Cell[][] parentMap, int size, Vector2 mapPosition)
    {
        this.parentMap = parentMap;

        this.size = size;
        this.setPrefSize(size, size);

        this.mapPosition = mapPosition;
        windowPosition = new Vector2(WindowSettings.SCREEN_PADDING + mapPosition.x * size, WindowSettings.SCREEN_PADDING + mapPosition.y * size);

        this.setLayoutX(windowPosition.x);
        this.setLayoutY(windowPosition.y);

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
            {
                if (!isRevealed)
                {
                    if (event.getButton() == MouseButton.PRIMARY && !isFlagged)
                    {
                        reveal();
                    }
                    else if (event.getButton() == MouseButton.SECONDARY)
                    {
                        flag();
                    }
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
        isRevealed = true;
        System.out.println("Revealed, (" + mapPosition.x + ", " + mapPosition.y + ")");
    }

    public void flag()
    {
        if(!isFlagged)
        {   
            isFlagged = true;
            System.out.println("Flagged, (" + mapPosition.x + ", " + mapPosition.y + ")");
        }
        else
        {
            isFlagged = false;
            System.out.println("Unflagged, (" + mapPosition.x + ", " + mapPosition.y + ")");
        }
    }

    public boolean getBombStatus()
    {
        return this.hasBomb;
    }
}
