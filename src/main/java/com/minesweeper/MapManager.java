package com.minesweeper;

import javafx.scene.layout.*;

public class MapManager {
    public static int[][] generateMapLayout(int dimensions, int numOfBombs)
    {
        //Generate map
        return new int[dimensions][dimensions];
    }

    public static Tile[][] generateMapFromMapLayout(int[][] array, int dimensions)
    {
        Tile[][] map = new Tile[dimensions][dimensions];

        for (int i = 0; i < dimensions; i++)
        {
            for (int j = 0; j < dimensions; j++)
            {
                int tileSize = WindowSettings.WINDOW_WIDTH / dimensions;

                if (array[i][j] == 0)
                {
                    map[i][j] = new Tile(map, tileSize, new Vector2(i, j), false);
                }
                else
                {
                    map[i][j] = new Tile(map, tileSize, new Vector2(i, j), true);
                }
            }
        }

        return map;
    }

    public static void loadMap(Pane root, Tile[][] map, int dimensions)
    {
        for (int i = 0; i < dimensions; i++)
        {
            for (int j = 0; j < dimensions; j++)
            {
                root.getChildren().add(map[i][j]);
            }
        }
    }

    public static int getNeighboringBombCount(Tile[][] map, Tile tile)
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
