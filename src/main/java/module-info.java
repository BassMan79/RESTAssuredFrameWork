module com.example.testapi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testapi to javafx.fxml;
    exports com.example.testapi;
}