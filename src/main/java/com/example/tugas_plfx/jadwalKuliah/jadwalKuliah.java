package com.example.tugas_plfx.jadwalKuliah;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class jadwalKuliah extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("jadwal.fxml"));
  Scene scene = new Scene(fxmlLoader.load());



        stage.setTitle("Jadwal Kuliah");
        stage.setScene(scene);
        stage.show();
    }
}
