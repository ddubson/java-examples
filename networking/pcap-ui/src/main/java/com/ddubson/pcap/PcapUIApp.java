package com.ddubson.pcap;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Author: ddubson
 */
public class PcapUIApp extends Application {
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
    }
}
