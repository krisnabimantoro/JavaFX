 module com.example.tugas_plfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tugas_plfx to javafx.fxml;
    exports com.example.tugas_plfx;
}