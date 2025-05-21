package com.audio.controller;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import com.audio.util.AudioPlayer;
import javafx.scene.Scene;
import java.io.File;
import javafx.stage.Stage;


public class MainController {

    @FXML private TextField trackNameField;
    @FXML private Button playButton;
    @FXML private Button stopButton;
    @FXML private Button analysisButton;

    private AudioPlayer player = new AudioPlayer();

    @FXML
    public void initialize() {
        playButton.setOnAction(e -> chooseAndPlayTrack());
        stopButton.setOnAction(e -> player.stop());
        analysisButton.setOnAction(e -> openAnalysisWindow());
    }

    private void chooseAndPlayTrack() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите аудиофайл");
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            trackNameField.setText(file.getName());
            player.play(file.getAbsolutePath());
        }
    }

    private void openAnalysisWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/audio/view/analysis_view.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Анализ трека");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

