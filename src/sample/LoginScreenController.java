package sample;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginScreenController {

    public JFXButton UserButton;
    public JFXButton AdminButton;
    public JFXButton TrainerButton;
    public Pane MainPane;

    public LoginScreenController(){
    }

    public void AdminButtonHandler(ActionEvent actionEvent) {
        System.out.println("AdminButton clicked!");
        //Your code goes here
        AdminButton.setOnAction(e -> {
            FadeOut("AdminLoginScreen.fxml");
        });
    }

    public void UserButtonHandler(ActionEvent actionEvent) {
        System.out.println("UserButton clicked!");
        //Your code goes here
        UserButton.setOnAction(e -> {
            FadeOut("UserLoginScreen.fxml");
        });
    }

    public void TrainerButtonHandler(ActionEvent actionEvent) {
        System.out.println("TrainerButton clicked!");
        //Your code goes here
        TrainerButton.setOnAction(e -> {
            FadeOut("TrainerLoginScreen.fxml");
        });
    }

    private void FadeOut(String fxmlFileName) {
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.millis(100));
        ft.setNode(MainPane);
        ft.setFromValue(1);
        ft.setToValue(0.2);
        ft.setOnFinished(e -> {
            loadNextScene(fxmlFileName);
        });
        ft.play();
    }

    private void loadNextScene(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Parent root = loader.load();
            Scene newScene = new Scene(root);
            Main.primaryStage.setScene(newScene);
        }
        catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
