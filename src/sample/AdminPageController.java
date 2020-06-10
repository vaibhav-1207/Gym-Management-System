package sample;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminPageController implements Initializable{

    public JFXButton AddNewMemberButton;
    public JFXButton AddNewTrainerButton;
    public JFXButton AddNewEquipmentButton;
    public JFXButton LogOutButton;
    public Pane AdminPagePane;
    public TableColumn ID;
    public TableColumn Name;
    public TableColumn Phone;
    public TableColumn Address;
    public TableColumn Email;
    public TableColumn UpDel;
    public TableView UserListTable;
    public TableView TrainerListTable;
    public TableColumn TEmail;
    public TableColumn TAddress;
    public TableColumn TPhone;
    public TableColumn TName;
    public TableColumn TID;
    public TableColumn TUpDel;
    public TableColumn EID;
    public TableColumn EName;
    public TableColumn Del;
    public TableColumn PlanEndTime;
    public TableColumn PlanStartTime;
    public TableColumn PlanEquipment;
    public TableView EquipmentListTable;
    public TableColumn PlanTrainers;
    public TableColumn PlanUsers;
    public TableColumn PlanID;
    public TableView ExercisePlanTableView;
    public JFXButton DeleteNewMemberButton;

    public void AddNewMemberButtonHandler(ActionEvent actionEvent) {
        System.out.println("Add new member button pressed!");
        FadeOut("NewMemberRegistration.fxml");
    }
    public void DeleteMemberButtonHandler(ActionEvent event){
        System.out.println(" Database.UserNameToPasswordHashmap: "+Database.UserNameToPasswordHashmap);
        JFrame f = new JFrame();
        String id = JOptionPane.showInputDialog(f, "Enter User ID: ");
        Info f1=null;
        int flag=0, t = 0;
        for (int i = 0; i < Database.UserList.size(); i++) {
            f1 = Database.UserList.get(i);
            if (f1.getID().equals(id)) {
                t = i;
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            Database.UserList.remove(t);
            System.out.println(Database.UserNameToPasswordHashmap.remove(f1.getName()) + " removed!");
            System.out.println(Database.UserNameToPasswordHashmap);
            FadeOut("AdminPage.fxml");
        }
    }
    public void AddNewTrainerButtonHandler(ActionEvent actionEvent) {
        System.out.println("Add new trainer button pressed!");
        FadeOut("NewTrainerRegistration.fxml");
    }
    public void AddNewEquipmentHandler(ActionEvent actionEvent) {
        System.out.println("Add new equipment button pressed!");
        FadeOut("NewEquipmentPage.fxml");
    }
    public void LogOutButtonHandler(ActionEvent actionEvent) {
        System.out.println("Logout button pressed!");
        FadeOut("LoginScreen.fxml");
        System.out.println("Admin Logged Out!");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        UserListTable.getItems().addAll(Database.UserList);

        TID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        TName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TPhone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        TEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        TAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        TrainerListTable.getItems().addAll(Database.TrainerList);

        EID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        EName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        EquipmentListTable.getItems().addAll(Database.EquipmentList);

        PlanID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        PlanUsers.setCellValueFactory(new PropertyValueFactory<>("user"));
        PlanTrainers.setCellValueFactory(new PropertyValueFactory<>("Trainer"));
        PlanEquipment.setCellValueFactory(new PropertyValueFactory<>("equipment"));
        PlanStartTime.setCellValueFactory(new PropertyValueFactory<>("Start"));
        PlanEndTime.setCellValueFactory(new PropertyValueFactory<>("End"));
        ExercisePlanTableView.getItems().addAll(Database.ExercisePlanList1);
    }
    private void FadeOut(String fxmlFileName) {
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.millis(100));
        ft.setNode(AdminPagePane);
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
