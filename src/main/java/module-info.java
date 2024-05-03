module it.itismeucci {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens it.itismeucci to javafx.fxml;

    exports it.itismeucci;
}
