package com.minesweeper;

import javafx.scene.layout.*;

public class MapManager {
    private int mapDimensions;
    private int numOfBombs;
    private Cell[][] map;

    MapManager(int mapDimensions, int numOfBombs)
    {
        this.mapDimensions = mapDimensions;
        this.numOfBombs = numOfBombs;

        this.generateMapFromMapLayout(generateMapLayout());
    }

    public int[][] generateMapLayout()
    {
        //Generate map (TEMPORARY)

        int test_map[][] = {
        {0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0},
        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}
        };

        return test_map;
    }

    public void generateMapFromMapLayout(int[][] array)
    {
        map = new Cell[mapDimensions][mapDimensions];

        for (int i = 0; i < mapDimensions; i++)
        {
            for (int j = 0; j < mapDimensions; j++)
            {
                int cellSize = (WindowSettings.WINDOW_WIDTH) / mapDimensions;

                if (array[i][j] == 0)
                {
                    map[i][j] = new NumberCell(this, cellSize, new Vector2(i, j));
                }
                else
                {
                    map[i][j] = new BombCell(this, cellSize, new Vector2(i, j));
                }
            }
        }

        // Set radial bomb counts for number cells
        for (int i = 0; i < mapDimensions; i++)
        {
            for (int j = 0; j < mapDimensions; j++)
            {
                if (map[i][j] instanceof NumberCell)
                {
                    ((NumberCell)map[i][j]).setNeighboringBombCount();
                }
            }
        }
    }

    public void loadMap(Pane root)
    {
        for (int i = 0; i < mapDimensions; i++)
        {
            for (int j = 0; j < mapDimensions; j++)
            {
                root.getChildren().add(map[i][j]);
            }
        }
    }

    public void radialClearSurroundingcells(Cell cell)
    {
        // First: run if cell is equal to zero
        // Second: check neigbors and reveal if they are not the bomb
        // Third: run the function for each neighbor that is not a bomb
    }

    public int getNeighboringBombCount(Cell cell)
    {
        int count = 0;

        int x = cell.mapPosition.x;
        int y = cell.mapPosition.y;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                
                if (i == 0 && j == 0) {
                    continue;
                }

                int checkX = x + i;
                int checkY = y + j;

                if (checkX >= 0 && checkX < map.length && checkY >= 0 && checkY < map[0].length) {
                    if (map[checkX][checkY].getBombStatus() == true) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public int getMapDimensions()
    {
        return mapDimensions;
    }
}
