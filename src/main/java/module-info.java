module com.project.airlines_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.project.controller to javafx.fxml;
    exports com.project.controller;
}