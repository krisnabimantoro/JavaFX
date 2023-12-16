 module com.example.tugas_plfx {
    requires javafx.controls;
    requires javafx.fxml;


//    opens com.example.tugas_plfx to javafx.fxml;
//    exports com.example.tugas_plfx;
     opens com.example.tugas_plfx.jadwalKuliah to javafx.fxml;
     exports com.example.tugas_plfx.jadwalKuliah;

     exports com.example.tugas_plfx.mahasiswa;
     opens com.example.tugas_plfx.mahasiswa to javafx.fxml;
 }
