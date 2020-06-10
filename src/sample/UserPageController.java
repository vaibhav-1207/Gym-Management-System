package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import javafx.util.Duration;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserPageController implements Initializable {

    public JFXButton LOGOUT;
    public TableColumn Sub;
    public TableColumn End;
    public TableColumn Start;
    public TableColumn EquipmentName;
    public TableColumn TrainerName;
    public TableColumn UserTableID;
    public TableView UserTableView;
    public Pane UsersPane;
    public JFXButton SubscribeButton;
    public static String User_name;
    public TableColumn UnSub;
    public JFXButton UnSubscribeButton;

    public void LogOutButtonHandler(ActionEvent actionEvent) {
        System.out.println("User Logged out!");
        FadeOut("LoginScreen.fxml");
    }

    private void FadeOut(String fxmlFileName) {
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.millis(300));
        ft.setNode(UsersPane);
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
        int flag = 0;
        UserTableID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        TrainerName.setCellValueFactory(new PropertyValueFactory<>("Trainer"));
        EquipmentName.setCellValueFactory(new PropertyValueFactory<>("Equipment"));
        Start.setCellValueFactory(new PropertyValueFactory<>("Start"));
        End.setCellValueFactory(new PropertyValueFactory<>("End"));

        System.out.println(Database.NametoID);
        for(String names:Database.NametoID.keySet()){
            if(!Database.NametoID.isEmpty()) {
                flag = 1;
                int idx = Database.NametoID.get(names);
                UserTableView.getItems().addAll(Database.ExercisePlanList[idx]);
            }
        }
        if(flag==0){
            System.out.println("Database is empty!");
        }
    }

    public void SubscribeButtonHandler(ActionEvent actionEvent) {
        JFrame f = new JFrame();
        String ip = JOptionPane.showInputDialog(f,"Enter Plan ID: ");
        String ip1 = JOptionPane.showInputDialog(f,"Enter Trainer Name: ");
        System.out.println(ip);
        System.out.println(ip1);
        if(Database.NametoID.containsKey(ip1)) {
            int idx = Database.NametoID.get(ip1);
            for (int i = 0; i < Database.ExercisePlanList[idx].size(); i++) {
                ExercisePlan ep = Database.ExercisePlanList[idx].get(i);
                if (ep.getID().equals(ip)) {
                    String trainer = ep.getTrainer();
                    String equip = ep.getEquipment();
                    String Start = ep.getStart();
                    String end = ep.getEnd();
                    ExercisePlan1 ep1 = new ExercisePlan1(ip, User_name, trainer, equip, Start, end);
                    Database.ExercisePlanList1.add(ep1);
                    JOptionPane.showMessageDialog(f, "Exercise Plan subscribed!");
                }
            }
        }
        else{
            JFrame f1 = new JFrame();
            JOptionPane.showMessageDialog(f1, "No such Trainer or ID present");
        }
    }

    public void UnSubscribeButtonHandler(ActionEvent actionEvent) {
        JFrame f = new JFrame();
        String ip = JOptionPane.showInputDialog(f, "Enter Plan ID: ");
        String ip1 = JOptionPane.showInputDialog(f, "Enter Trainer Name: ");
        System.out.println(ip);
        System.out.println(ip1);
        int flag = 0;
        ExercisePlan1 ep1 = null;
        if (Database.NametoID.containsKey(ip1)) {
            int idx = Database.NametoID.get(ip1);
            for (int i = 0; i < Database.ExercisePlanList[idx].size(); i++) {
                ExercisePlan ep = Database.ExercisePlanList[idx].get(i);
                if (ep.getID().equals(ip)) {
                    String trainer = ep.getTrainer();
                    String equip = ep.getEquipment();
                    String Start = ep.getStart();
                    String end = ep.getEnd();
                    ep1 = new ExercisePlan1(ip, ip1, trainer, equip, Start, end);
                    flag = 1;

                }
            }
            int idx1 = 0;
            for (int i = 0; i < Database.ExercisePlanList1.size(); i++) {
                ExercisePlan1 ep2 = Database.ExercisePlanList1.get(i);
                if (ep2.getID().equals(ep1.getID())) {
                    idx1 = i;
                    break;
                }
            }

            if (flag == 1) {
                Database.ExercisePlanList1.remove(idx1);
                JOptionPane.showMessageDialog(f, "Exercise Plan Unsubscribed!");
            }
        }
        else {
            JFrame f1 = new JFrame();
            JOptionPane.showMessageDialog(f1, "No such Trainer or ID present");
        }
    }
}
