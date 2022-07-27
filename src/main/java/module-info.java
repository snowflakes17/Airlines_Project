module com.project.airlines_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires static lombok;
    requires java.sql;


    opens com.project.controller to javafx.fxml;
    exports com.project.controller;
}

