package com.example.tugas_plfx.jadwalKuliah;

import com.example.tugas_plfx.mahasiswa.mahasiswaController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class JadwalKuliahController {

    public TextField tbDosen;
    public TextField tbMatkul;
    public TextField tbRuangan;
    public ComboBox cbGkb;
    public Button btnUpdate;
    public Button btnCreate;
    public Button btnDelete;
    public TableView tvData;
    public TextField tbWaktu;


    ObservableList<data> dataKuliah = FXCollections.observableArrayList(new data("4","3","4","4","4"));

    ObservableList<String> listgkb = FXCollections.observableArrayList("1","2","3","4");

    ObservableList<String> listWaktu = FXCollections.observableArrayList("Teknik","FISIP","Hukum","Kesehatan","Pendidikan","FEB");



    @FXML
    private void initialize(){
       cbGkb.setItems(listgkb);



        TableColumn namaDosen = new TableColumn("Nama");
        TableColumn matkul = new TableColumn("NIM");
        TableColumn gkb = new TableColumn("Email");
        TableColumn waktu = new TableColumn("Fakultas");
        TableColumn ruangan = new TableColumn("Jurusan");


        tvData.getColumns().addAll(namaDosen,matkul,gkb,waktu,ruangan);

        namaDosen.setCellValueFactory(new PropertyValueFactory<data,String>("namaDosen"));
        matkul.setCellValueFactory(new PropertyValueFactory<data,String>("matkul"));
        gkb.setCellValueFactory(new PropertyValueFactory<data,String>("gkb"));
        waktu.setCellValueFactory(new PropertyValueFactory<data,String>("waktu"));
        ruangan.setCellValueFactory(new PropertyValueFactory<data,String>("ruangan"));



        tvData.setItems(dataKuliah);

    }




    public void createAction(ActionEvent actionEvent) {
        dataKuliah.add(new data(tbDosen.getText(),tbMatkul.getText(),(String) cbGkb.getValue(),tbWaktu.getText(),tbRuangan.getText()));
        tbDosen.clear();
        tbMatkul.clear();
        tbWaktu.clear();
        tbRuangan.clear();
    }

    public void updateAction(ActionEvent actionEvent) {
    ObservableList<data> currentTable = tvData.getItems();
    data selectedTable = (data) tvData.getSelectionModel().getSelectedItem();
    selectedTable.setNamaDosen((tbDosen.getText()));
    tvData.refresh();
    }

    public void deleteAction(ActionEvent actionEvent) {
        int selectedItem = tvData.getSelectionModel().getSelectedIndex();
        tvData.getItems().remove(selectedItem);


    }

    public void rowClick(MouseEvent event) {
        data update = (data) tvData.getSelectionModel().getSelectedItem();
        tbDosen.setText(String.valueOf(update.getNamaDosen()));
        tbMatkul.setText(String.valueOf(update.getMatkul()));
    }

    public static class data{
        private final SimpleStringProperty namaDosen,matkul,gkb,waktu,ruangan;


        public data(String namaDosen, String matkul, String gkb, String waktu, String ruangan) {
            this.namaDosen = new SimpleStringProperty(namaDosen);
            this.matkul = new SimpleStringProperty(matkul);
            this.gkb = new SimpleStringProperty(gkb);
            this.waktu = new SimpleStringProperty(waktu);
            this.ruangan = new SimpleStringProperty(ruangan);
        }

        public String getNamaDosen() {
            return namaDosen.get();
        }

        public SimpleStringProperty namaDosenProperty() {
            return namaDosen;
        }

        public void setNamaDosen(String namaDosen) {
            this.namaDosen.set(namaDosen);
        }

        public String getMatkul() {
            return matkul.get();
        }

        public SimpleStringProperty matkulProperty() {
            return matkul;
        }

        public void setMatkul(String matkul) {
            this.matkul.set(matkul);
        }

        public String getGkb() {
            return gkb.get();
        }

        public SimpleStringProperty gkbProperty() {
            return gkb;
        }

        public void setGkb(String gkb) {
            this.gkb.set(gkb);
        }

        public String getWaktu() {
            return waktu.get();
        }

        public SimpleStringProperty waktuProperty() {
            return waktu;
        }

        public void setWaktu(String waktu) {
            this.waktu.set(waktu);
        }

        public String getRuangan() {
            return ruangan.get();
        }

        public SimpleStringProperty ruanganProperty() {
            return ruangan;
        }

        public void setRuangan(String ruangan) {
            this.ruangan.set(ruangan);
        }
    }
}