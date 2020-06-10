package sample;

import com.jfoenix.controls.JFXButton;
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

public class NewExercisePlanController {

    public JFXTextField ExerciseDescriptionField;
    public JFXTextField EndTextField;
    public JFXButton AddButton;
    public JFXButton CancelButton;
    public JFXTextField StartTimeTextField;
    public JFXTextField EquipmentTextField;
    public Pane ExercisePane;
    public static String Trainer_namee;

    public void AddNewExerciseButtonHandler(ActionEvent actionEvent) {
        System.out.println("Add New Plan Clicked!");
        int flag=0;
        String ExerciseDescription=ExerciseDescriptionField.getText();
        String Equipment=EquipmentTextField.getText();
        String Start=StartTimeTextField.getText();
        String End=EndTextField.getText();
        try{
            ExerciseDescription.charAt(0);
            Equipment.charAt(0);
            Start.charAt(0);
            End.charAt(0);
            if(!(Double.parseDouble(Start)<24 && Double.parseDouble(Start)>=0 && Double.parseDouble(End)<24 && Double.parseDouble(End)>=0)){
                throw new Exception();
            }
        }
        catch (NumberFormatException e1){
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,"Invalid time!");
            flag = 1;
        }
        catch(Exception e){
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,"Fields are empty or Time is invalid!");
            flag=1;
        }
        if(flag==0){
            ExercisePlan ep=new ExercisePlan(String.valueOf(Database.EID++),Trainer_namee,Equipment,Start,End);
            int idx=Database.NametoID.get(Trainer_namee);
            Database.ExercisePlanList[idx].add(ep);
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,"Exercise Plan added");
        }

    }

    public void CancelExerciseButtonHandler(ActionEvent actionEvent) {
        System.out.println("Cancel Button Clicked!");
        FadeOut("TrainersPage.fxml");
    }


    private void FadeOut(String fxmlFileName) {
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.millis(300));
        ft.setNode(ExercisePane);
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
