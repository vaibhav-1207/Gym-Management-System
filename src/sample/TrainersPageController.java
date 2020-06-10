package sample;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainersPageController implements Initializable{

    public JFXButton CreatePlanButton;
    public TableColumn TrainersUpDel;
    public TableColumn TrainersEnd;
    public TableColumn TrainersStart;
    public TableColumn TrainersEquipments;
    public TableColumn TrainersUser;
    public TableColumn TrainersID;
    public TableView TrainersTableView;
    public Pane TrainersPane;
    public JFXButton LogOutButton;
    public static String Trainer_name;
    public JFXButton DeletePlanButton;


    public void CreatePlanButtonHandler(ActionEvent actionEvent) {
        System.out.println("Create Plan Button Clicked!");
        NewExercisePlanController.Trainer_namee=Trainer_name;
        FadeOut("NewExercisePlan.fxml");
    }

    public void LogOutButtonHandler(ActionEvent actionEvent) {
        FadeOut("LoginScreen.fxml");
    }

    private void FadeOut(String fxmlFileName) {
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.millis(300));
        ft.setNode(TrainersPane);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int flag = 1;
        TrainersID.setCellValueFactory(new PropertyValueFactory<>("ID"));
//        TrainersUser.setCellValueFactory(new PropertyValueFactory<>("Trainer"));
        TrainersEquipments.setCellValueFactory(new PropertyValueFactory<>("Equipment"));
        TrainersStart.setCellValueFactory(new PropertyValueFactory<>("Start"));
        TrainersEnd.setCellValueFactory(new PropertyValueFactory<>("End"));
        System.out.println(Database.NametoID);
        if(!Database.NametoID.isEmpty()) {
            flag = 0;
            int idx = Database.NametoID.get(Trainer_name);
            TrainersTableView.getItems().addAll(Database.ExercisePlanList[idx]);
        }
        if(flag == 1){
            System.out.println("Database Name TO ID is empty!");

        }
    }

    public void DeletePlanButtonHandler(ActionEvent actionEvent) {
        System.out.println("Delete Clicked!");
        JFrame f = new JFrame();
        String id = JOptionPane.showInputDialog(f, "Enter Plan Id: ");
        if(Database.NametoID.containsKey(Trainer_name)) {
            int idx = Database.NametoID.get(Trainer_name);
            int i = 0;
            int flag = 0;
            for (int j = 0; j < Database.ExercisePlanList[idx].size(); j++) {
                ExercisePlan p = Database.ExercisePlanList[idx].get(j);
                if (p.getID().equals(id)) {
                    i = j;
                    flag = 1;
                    break;
                }
            }
            int t = 0;
            int fl1 = 0;
            for (int j = 0; j < Database.ExercisePlanList1.size(); j++) {
                ExercisePlan1 p = Database.ExercisePlanList1.get(j);
                if (p.getID().equals(id)) {
                    t = j;
                    fl1 = 1;
                    break;
                }
            }
            if (flag == 1) {
                Database.ExercisePlanList[idx].remove(i);
                if (fl1 == 1) {
                    Database.ExercisePlanList1.remove(t);
                }
                JFrame f1 = new JFrame();
                JOptionPane.showMessageDialog(f1, "Plan deleted!");
                FadeOut("TrainersPage.fxml");
            } else {
                JFrame f1 = new JFrame();
                JOptionPane.showMessageDialog(f1, "Plan not found with this id!");
            }

        }
        else {
            JFrame f1 = new JFrame();
            JOptionPane.showMessageDialog(f1, "Plan not found with this id!");
        }
        System.out.println(id);
    }
}
