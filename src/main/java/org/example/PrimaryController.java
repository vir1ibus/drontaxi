package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.sql.*;
import static org.example.App.*;

public class PrimaryController {

    PreparedStatement preparedStatement = null;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private CheckBox rememberBox;


    @FXML
    private void initialize(){
        loginField.setText(loginRemember);
        if (remembered==true){
            rememberBox.setSelected(true);
        }
    }

    @FXML
    private void login() throws IOException, SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        preparedStatement = connection.prepareStatement(GET_ALL_USERS);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            if (resultSet.getString("email").equals(loginField.getText()) && resultSet.getString("password").equals(passwordField.getText())){
                if (rememberBox.isSelected()){
                    loginRemember = loginField.getText();
                    remembered = true;
                } else {
                    loginRemember = "";
                    remembered = false;
                }
                App.setRoot("secondary");
            }
        }
    }

    @FXML
    private void registration() throws IOException {
        App.setRoot("registration");
    }
}
