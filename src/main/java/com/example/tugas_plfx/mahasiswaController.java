package com.example.tugas_plfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class mahasiswaController {
    public TableView tvData;
    public TextField tbJurusan;
    public Label alert;
    ObservableList<String> listFakultas = FXCollections.observableArrayList("Teknik","FISIP","Hukum","Kesehatan","Pendidikan","FEB");

    ObservableList<data> dataMahasiswa = FXCollections.observableArrayList(new data("Krisna Bimantoro","2022","krisna@gmail.com","Teknik","Informatika","Lowokwaru","Malang"));


    public Button btnCreate;
    public ComboBox cbFakultas;
    public TextField tbNama;
    public TextField tbNim;
    public TextField tbEmail;
    public TextField tbAlamat;
    public TextField tbKota;



    @FXML
    private void initialize(){
        cbFakultas.setItems(listFakultas);

        TableColumn nama = new TableColumn("Nama");
        TableColumn nim = new TableColumn("NIM");
        TableColumn email = new TableColumn("Email");
        TableColumn fakultas = new TableColumn("Fakultas");
        TableColumn jurusan = new TableColumn("Jurusan");
        TableColumn alamat = new TableColumn("Alamat");
        TableColumn kota = new TableColumn("Kota");

        tvData.getColumns().addAll(nama,nim,email,fakultas,jurusan,alamat,kota);

        nama.setCellValueFactory(new PropertyValueFactory<data,String>("nama"));
        nim.setCellValueFactory(new PropertyValueFactory<data,String>("nim"));
        email.setCellValueFactory(new PropertyValueFactory<data,String>("email"));
        fakultas.setCellValueFactory(new PropertyValueFactory<data,String>("fakultas"));
        jurusan.setCellValueFactory(new PropertyValueFactory<data,String>("jurusan"));
        alamat.setCellValueFactory(new PropertyValueFactory<data,String>("alamat"));
        kota.setCellValueFactory(new PropertyValueFactory<data,String>("kota"));



        tvData.setItems(dataMahasiswa);
    }

    public void onActionCreate(ActionEvent actionEvent) throws IOException {



        if (tbNama.getText().isEmpty()) {
            alert.setText("Kolom nama tidak boleh kososng");

        } else if (tbNim.getText().isEmpty()) {
            alert.setText("Kolom NIM tidak boleh kososng");

        }else if (tbEmail.getText().isEmpty()) {

            alert.setText("Kolom Email tidak boleh kososng");
        }else if (cbFakultas.getValue()==null) {

            alert.setText("Fakultas harus dipilih");
        }else if (tbJurusan.getText().isEmpty()) {

            alert.setText("Kolom Jurusan tidak boleh kososng");
        }else if (tbAlamat.getText().isEmpty()) {

            alert.setText("Kolom Alamat tidak boleh kososng");
        }else if (tbKota.getText().isEmpty()) {

            alert.setText("Kolom Kota tidak boleh kososng");
        }else if (!tbNim.getText().matches("^[0-9]+$")){
            alert.setText("Kolom NIM harus berupa angka");
        } else if (!tbEmail.getText().contains("@webmail.umm.ac.id")) {
            alert.setText("Format email salah");
            
        } else{
            dataMahasiswa.add(new data(tbNama.getText(),tbNim.getText(),tbEmail.getText(), (String) cbFakultas.getValue(),tbJurusan.getText(),tbAlamat.getText(),tbKota.getText()));
            tbNama.clear();
            tbNim.clear();
            tbEmail.clear();
            tbJurusan.clear();
            tbAlamat.clear();
            tbKota.clear();
            alert.setText("");




        }


    }

    public static class data{
        private final SimpleStringProperty nama,nim,email,fakultas,jurusan,alamat,kota;


        public data(String nama, String nim, String email, String fakultas, String jurusan, String alamat, String kota) {
            this.nama = new SimpleStringProperty(nama);
            this.nim = new SimpleStringProperty(nim);
            this.email = new SimpleStringProperty(email);
            this.fakultas = new SimpleStringProperty(fakultas);
            this.jurusan = new SimpleStringProperty(jurusan);
            this.alamat = new SimpleStringProperty(alamat);
            this.kota = new SimpleStringProperty(kota);
        }


        public String getNim() {
            return nim.get();
        }

        public SimpleStringProperty nimProperty() {
            return nim;
        }

        public void setNim(String nim) {
            this.nim.set(nim);
        }

        public String getEmail() {
            return email.get();
        }

        public SimpleStringProperty emailProperty() {
            return email;
        }

        public void setEmail(String email) {
            this.email.set(email);
        }

        public String getFakultas() {
            return fakultas.get();
        }

        public SimpleStringProperty fakultasProperty() {
            return fakultas;
        }

        public void setFakultas(String fakultas) {
            this.fakultas.set(fakultas);
        }

        public String getJurusan() {
            return jurusan.get();
        }

        public SimpleStringProperty jurusanProperty() {
            return jurusan;
        }

        public void setJurusan(String jurusan) {
            this.jurusan.set(jurusan);
        }

        public String getAlamat() {
            return alamat.get();
        }

        public SimpleStringProperty alamatProperty() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat.set(alamat);
        }

        public String getKota() {
            return kota.get();
        }

        public SimpleStringProperty kotaProperty() {
            return kota;
        }

        public void setKota(String kota) {
            this.kota.set(kota);
        }

        public String getNama() {
            return nama.get();
        }

        public SimpleStringProperty namaProperty() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama.set(nama);
        }
    }


}
