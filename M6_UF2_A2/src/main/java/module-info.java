module com.example.m6_uf2_a2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m6_uf2_a2 to javafx.fxml;
    exports com.example.m6_uf2_a2;
}