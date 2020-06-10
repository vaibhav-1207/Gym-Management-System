package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserLoginScreenController {
    public Pane UserPane;
    public JFXPasswordField UserPasswordField;
    public JFXTextField UserUsernameField;
    public JFXButton UserLoginButton;
    public JFXButton UserBackButton;
    HashMap<String, String> usernameToPasswordHashmap = Database.UserNameToPasswordHashmap;
    int flag=0;
    public void UserLoginButtonHandler(MouseEvent mouseEvent) {
        String u = UserUsernameField.getText();
        String p = UserPasswordField.getText();
        try{
            u.charAt(0);
            p.charAt(0);
        }
        catch(Exception e){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Username or password empty!");
        }
        for (String users : usernameToPasswordHashmap.keySet()) {
            if (users.equals(u)) {
                if (p.equals(usernameToPasswordHashmap.get(u))) {
                    System.out.println("User Name: " + u + " logged in!");
                    flag = 1;
                    UserPageController.User_name=u;
                    loadNextScene("UserPage.fxml");
                }
            }
        }
        if(flag==0){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Username or password incorrect!");
        }
    }

    public void UserBackButtonHandler(MouseEvent mouseEvent) {
        UserBackButton.setOnMouseClicked(e -> {
            FadeOut("LoginScreen.fxml");
        });
    }

    private void FadeOut(String fxmlFileName) {
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.millis(300));
        ft.setNode(UserPane);
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
