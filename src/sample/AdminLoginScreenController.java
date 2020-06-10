package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminLoginScreenController {

    public Pane AdminPane;
    public JFXButton AdminBackButton;
    public JFXButton AdminLoginButton;
    public JFXTextField AdminUsernameField;
    public JFXPasswordField AdminPasswordField;


    private String adminUserName = "admin";
    private String adminPassword = "1234";
    public void AdminLoginButtonHandler(MouseEvent mouseEvent) {
        String u = AdminUsernameField.getText();
        String p = AdminPasswordField.getText();
        try{
            u.charAt(0);
            p.charAt(0);
        }
        catch(Exception e){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Username or password empty!");
        }
        if(u.equals(adminUserName) && p.equals(adminPassword)){
            System.out.println("Admin Logged in!");
            FadeOut("AdminPage.fxml");
        }
        else{
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Username or password incorrect!");
        }
    }

    public void AdminBackButtonHandler(MouseEvent mouseEvent) {
        AdminBackButton.setOnMouseClicked(e -> {
            loadNextScene("LoginScreen.fxml");
        });
    }

    private void FadeOut(String fxmlFileName) {
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.millis(300));
        ft.setNode(AdminPane);
        ft.setFromValue(1);
        ft.setToValue(0);
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
