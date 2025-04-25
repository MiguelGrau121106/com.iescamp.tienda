module com.example.proyectofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;
    requires java.sql;
    requires com.opencsv;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;


    opens iescamp.tienda to javafx.fxml;
    exports iescamp.tienda;
    exports iescamp.tienda.modelo;
    opens iescamp.tienda.modelo to javafx.fxml;
}