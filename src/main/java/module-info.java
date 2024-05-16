module com.example.travelreservationsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.travelreservationsystem to javafx.fxml;
    exports com.example.travelreservationsystem;
}