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
        Pane mapPane = new Pane();

        MapManager manager = new MapManager(16, 5);
        manager.loadMap(mapPane);

        double mapWidth = manager.getMapDimensions() * (WindowSettings.WINDOW_WIDTH) / manager.getMapDimensions();
        double mapHeight = manager.getMapDimensions() * (WindowSettings.WINDOW_WIDTH) / manager.getMapDimensions();

        mapPane.setMinSize(mapWidth, mapHeight);
        mapPane.setPrefSize(mapWidth, mapHeight);
        mapPane.setMaxSize(mapWidth, mapHeight);

        StackPane root = new StackPane(mapPane);
        root.setStyle("-fx-background-color: #07449e;");

        scene = new Scene(root, WindowSettings.WINDOW_WIDTH, WindowSettings.WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}