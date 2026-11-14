package com.minesweeper;

import javafx.scene.layout.*;

public class MapManager {
    public static int[][] generateMap(int dimensions, int numOfBombs)
    {
        //Generate map
        return new int[dimensions][dimensions];
    }

    public static void loadMap(Pane root, int[][] map, int dimensions)
    {
        for (int i = 0; i < dimensions; i++)
        {
            for (int j = 0; j < dimensions; j++)
            {
                Tile tile;
                int tileSize = WindowSettings.WINDOW_WIDTH / dimensions;

                if (map[i][j] == 0)
                {
                    tile = new Tile(map, tileSize, new Vector2(i, j), false);
                }
                else
                {
                    tile = new Tile(map, tileSize, new Vector2(i, j), true);
                }
                root.getChildren().add(tile);
            }
        }
    }

    public static int getNeighboringBombCount(int[][] map, Tile tile)
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
                    if (map[checkX][checkY] == 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
