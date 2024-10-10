package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Optional;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField nameField;

    @FXML
    protected void onHelloButtonClick() {
        String textField = nameField.getText();
        welcomeText.setText("Welcome to JavaFX Application " + textField + "!");
    }
    public void onGoodbyeButtonClick() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Are you sure you want to exit "+nameField.getText()+"?");
        alert.setContentText("Press OK to exit or Cancel to stay.");

        ButtonType buttonTypeOK = new ButtonType("OK");
        ButtonType buttonTypeCancel = new ButtonType("Cancel");
        alert.getButtonTypes().setAll(buttonTypeOK, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get().getText().equals("OK")){
            System.exit(0);
        }else {
            welcomeText.setText("You are still in the application!");
        }
    }
}