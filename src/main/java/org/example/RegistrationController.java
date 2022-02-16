package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.App.*;

public class RegistrationController {

    PreparedStatement preparedStatement = null;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField parentField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField passwordField2;

    @FXML
    private void switchToLoginWithData() {
        String surname = surnameField.getText();
        String name = nameField.getText();
        String parent= parentField.getText();
        String email =emailField.getText();
        String password1 = passwordField.getText();
        String password2 = passwordField2.getText();
        if(surname!="" && name!="" && email!="" && password1!="" && password1.equals(password2)){

        }
    }

    @FXML
    private void registerUser(String surname, String name, String parent, String email, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        preparedStatement = connection.prepareStatement(INSERT_NEW_USER);

    }
}
