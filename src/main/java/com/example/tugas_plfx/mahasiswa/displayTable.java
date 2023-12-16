package com.example.tugas_plfx.mahasiswa;

import com.example.tugas_plfx.mahasiswa.mahasiswa;
import com.example.tugas_plfx.mahasiswa.mahasiswaController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class displayTable {
    public TableView tvMahasiswa;
    public Button btnBack;
    ObservableList<mahasiswaController.data> dataMahasiswa = FXCollections.observableArrayList(new mahasiswaController.data("Krisna Bimantoro","2022","krisna@gmail.com","Teknik","Informatika","Lowokwaru","Malang"));


    @FXML
    private void initialize(){

        TableColumn nama = new TableColumn("Nama");
        TableColumn nim = new TableColumn("NIM");
        TableColumn email = new TableColumn("Email");
        TableColumn fakultas = new TableColumn("Fakultas");
        TableColumn jurusan = new TableColumn("Jurusan");
        TableColumn alamat = new TableColumn("Alamat");
        TableColumn kota = new TableColumn("Kota");

        tvMahasiswa.getColumns().addAll(nama,nim,email,fakultas,jurusan,alamat,kota);

        nama.setCellValueFactory(new PropertyValueFactory<mahasiswaController.data,String>("nama"));
        nim.setCellValueFactory(new PropertyValueFactory<mahasiswaController.data,String>("nim"));
        email.setCellValueFactory(new PropertyValueFactory<mahasiswaController.data,String>("email"));
        fakultas.setCellValueFactory(new PropertyValueFactory<mahasiswaController.data,String>("fakultas"));
        jurusan.setCellValueFactory(new PropertyValueFactory<mahasiswaController.data,String>("jurusan"));
        alamat.setCellValueFactory(new PropertyValueFactory<mahasiswaController.data,String>("alamat"));
        kota.setCellValueFactory(new PropertyValueFactory<mahasiswaController.data,String>("kota"));



        tvMahasiswa.setItems(dataMahasiswa);
    }

    public void backAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(mahasiswa.class.getResource("mahasiswa.fxml"));
        Parent root = fxmlLoader1.load();
        Stage stage1 = (Stage) btnBack.getScene().getWindow();

        stage1.setScene(new Scene(root));
    }
}
