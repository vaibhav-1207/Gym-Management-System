package sample;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewTrainerRegistrationController {

    public Pane NewTrainerRegisterPane;
    public JFXTextField UsernameTextField;
    public JFXTextField EmailTextField;
    public JFXTextField AddressTextField;
    public JFXTextField PhoneTextField;
    public JFXPasswordField PasswordField;

    String uname, pword, email, phone, add;
    public void AddNewTrainerButtonHandler(ActionEvent actionEvent) {
        System.out.println("Add New Trainer Button Clicked!");
        uname = UsernameTextField.getText();
        pword = PasswordField.getText();
        email = EmailTextField.getText();
        phone = PhoneTextField.getText();
        add = AddressTextField.getText();
        int status = checkExceptions();

        if(status == 1){
            String id = String.valueOf(Database.ID++);
            Info info = new Info(id, uname, pword, phone, email, add);
            Database.TrainerUserNameToPasswordHashmap.put(uname, pword);
            Database.TrainerList.add(info);
            Database.NametoID.put(uname,Database.ID);
            System.out.println(Database.TrainerUserNameToPasswordHashmap);
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Trainer: " + uname + " added!");
        }
    }

    public void CancelNewTrainerButtonHandler(ActionEvent actionEvent) {
        System.out.println("Cancel Button Clicked!");
        FadeOut("AdminPage.fxml");
    }

    private void FadeOut(String fxmlFileName) {
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.millis(300));
        ft.setNode(NewTrainerRegisterPane);
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
    private int checkExceptions(){
        try{
            uname.charAt(0);
        }
        catch (Exception e){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Username is empty!");
            return -1;
        }
        try{
            pword.charAt(0);
        }
        catch (Exception e){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Password is empty!");
            return -1;
        }
        try{
            phone.charAt(0);
            Double.parseDouble(phone);
            if(phone.length()>10) throw new Exception();
        }
        catch (NumberFormatException e1){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Invalid phone number!");
            return -1;
        }
        catch (Exception e){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "PhoneNumber is empty!");
            return -1;
        }
        try{
            email.charAt(0);
        }
        catch (Exception e){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Email is empty!");
            return -1;
        }


        try{
            add.charAt(0);
        }
        catch (Exception e){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Address is empty!");
            return -1;
        }
        return 1;
    }
}
