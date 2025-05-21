package com.audio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
	
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/audio/view/main_view.fxml"));
        
        URL url = getClass().getResource("/com/audio/view/main_view.fxml");
        
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Лаба_5");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

