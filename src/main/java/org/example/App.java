package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    protected static String loginRemember = "";
    protected static Boolean remembered = false;
    protected final static String URL = "jdbc:mysql://172.16.225.104:3306/user02?useSSL=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    protected final static String USERNAME = "user02";
    protected final static String PASSWORD = "77053";
    protected final static String GET_ALL_USERS = "SELECT * FROM User";

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}