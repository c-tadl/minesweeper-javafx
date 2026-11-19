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

        map = generateMapFromMapLayout(generateMapLayout(numOfBombs));
    }

    public int[][] generateMapLayout(int numOfBombs)
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

    public Cell[][] generateMapFromMapLayout(int[][] array)
    {
        Cell[][] map = new Cell[mapDimensions][mapDimensions];

        for (int i = 0; i < mapDimensions; i++)
        {
            for (int j = 0; j < mapDimensions; j++)
            {
                int tileSize = (WindowSettings.WINDOW_WIDTH - (2 * WindowSettings.SCREEN_PADDING)) / mapDimensions;

                if (array[i][j] == 0)
                {
                    map[i][j] = new NumberCell(map, tileSize, new Vector2(i, j));
                }
                else
                {
                    map[i][j] = new BombCell(map, tileSize, new Vector2(i, j));
                }
            }
        }

        return map;
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

    public void radialClearSurroundingTiles(Cell tile)
    {
        // First: run if tile is equal to zero
        // Second: check neigbors and reveal if they are not the bomb
        // Third: run the function for each neighbor that is not a bomb
    }

    public int getNeighboringBombCount(Cell tile)
    {
        int count = 0;

        int x = tile.mapPosition.x;
        int y = tile.mapPosition.y;

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
}
