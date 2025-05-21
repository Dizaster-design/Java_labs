package com.audio.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class AnalysisController {
    @FXML private TextArea analysisArea;

    @FXML
    public void initialize() {
        analysisArea.setText("Пример анализа: \n- Длительность: 03:45\n- Битрейт: 320kbps\n- Формат: MP3");
    }
}
