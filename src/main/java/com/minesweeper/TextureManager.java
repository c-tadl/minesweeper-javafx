package com.minesweeper;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class TextureManager {
    public static final Background dirt_tex = createBackground("textures/dirt.png");

    //Making the flag image -George
    public static Background createBackgroundFlag(Background background) {
        Image img = new Image(
            Cell.class.getResourceAsStream("textures/flag.png"),
            64,64,
            true,
            false);
        BackgroundSize bgSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage flagImg = new BackgroundImage( 
            img,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            bgSize
        );
        BackgroundImage baseImg = background.getImages().get(0);
        return new Background(baseImg, flagImg);
    }     

    //Making the tile background -George
    public static Background createBackground(String path) {
        Image img = new Image(
            Cell.class.getResourceAsStream(path),
            64,64,
            true,
            false);
        BackgroundSize bgSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage bgImg = new BackgroundImage( 
            img,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            bgSize
        );
        return new Background(bgImg);
    }

    public static Background getRandomForestTex()
    {
        Random random = new Random();
        int randVal = random.nextInt(3) + 1; // 3 is the count of forest textures

        Background background;
        background = createBackground("textures/forest_" + randVal + ".png");
        return background;
    }
}
