package com.minesweeper;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();

        MapManager manager = new MapManager(16, 5);
        manager.loadMap(root);

        scene = new Scene(root, WindowSettings.WINDOW_WIDTH, WindowSettings.WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}