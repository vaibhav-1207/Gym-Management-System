package sample;

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

public class NewEquipmentPageController {
    public Pane NewEquipmentPagePane;
    public JFXTextField EquipmentNameTextField;

    public void AddEquipmentButtonHandler(ActionEvent actionEvent) {
        System.out.println("Add New Equipment Button Clicked!");
        int flag = 1;
        String eqname = EquipmentNameTextField.getText();
        try{
            eqname.charAt(0);
        }
        catch (Exception e){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Equipment is empty!");
            flag = 0;
        }
        if(flag == 1){
            Equipment eq=new Equipment(String.valueOf(Database.ID++),eqname);
            Database.EquipmentList.add(eq);
        }
    }

    public void CancelEquipmentButtonHandler(ActionEvent actionEvent) {
        System.out.println("Cancel Button Clicked!");
        FadeOut("AdminPage.fxml");
    }
    private void FadeOut(String fxmlFileName) {
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.millis(300));
        ft.setNode(NewEquipmentPagePane);
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
