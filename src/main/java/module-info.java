module com.project.airlines_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires jbcrypt;
    requires static lombok;
    requires java.sql;
    requires org.controlsfx.controls;


    opens com.project.controller to javafx.fxml;
    opens com.project.models to javafx.base;
    exports com.project.controller;
}

