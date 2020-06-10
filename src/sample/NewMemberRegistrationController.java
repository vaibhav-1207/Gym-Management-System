package sample;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewMemberRegistrationController {
    public Pane NewMemberRegisterPane;
    public JFXTextField AddressTextField;
    public JFXTextField EmailTextField;
    public JFXTextField UsernameTextField;
    public JFXTextField PhoneTextField;
    public JFXPasswordField PasswordField;
    private String uname, pword, email, phone, add;

    public void AddNewMemberButtonHandler(ActionEvent actionEvent) {

        System.out.println("Add New Member Button Clicked!");
        uname = UsernameTextField.getText();
        pword = PasswordField.getText();
        email = EmailTextField.getText();
        phone = PhoneTextField.getText();
        add = AddressTextField.getText();
        int status = checkExceptions();

        if(status == 1){
            String id = String.valueOf(Database.ID++);
            Info info = new Info(id, uname, pword, phone, email, add);
            Database.UserNameToPasswordHashmap.put(uname, pword);
            Database.UserList.add(info);
            System.out.println(Database.UserNameToPasswordHashmap);
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Username: " + uname + " added!");
        }

    }

    public void CancelNewMemberButtonHandler(ActionEvent actionEvent) {
        System.out.println("Cancel Button Clicked!");
        FadeOut("AdminPage.fxml");
    }

    private void FadeOut(String fxmlFileName) {
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.millis(300));
        ft.setNode(NewMemberRegisterPane);
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
            else if(phone.length()<10) throw new Exception();
        }
        catch (NumberFormatException e1){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Invalid phone number!");
            return -1;
        }
        catch (Exception e){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "PhoneNumber has " + phone.length() + " digits!");
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
