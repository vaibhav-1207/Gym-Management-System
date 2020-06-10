package sample;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Button;

import javax.swing.*;

public class Info {
    private String ID;
    private String Name;
    private String Phone;
    private String Email;
    private String Address;
    private String Password;
    //private JFXButton ButtonsUpdate;
    //private JFXButton ButtonsDelete;

    public Info(){}
    public Info(String ID, String Name, String password, String Phone, String Email, String Address){
        this.ID = ID;
        this.Name = Name;
        this.Password = password;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
//        this.ButtonsUpdate = new JFXButton("Update");
//        this.ButtonsDelete = new JFXButton("Delete");
//        ButtonsUpdate.setButtonType(JFXButton.ButtonType.RAISED);
//        ButtonsDelete.setButtonType(JFXButton.ButtonType.RAISED);
//        ButtonsUpdate.setStyle("-fx-background-color: #59cb59;");
//        ButtonsDelete.setStyle("-fx-background-color: #59cb59;");
    }

    public void setID(String id){this.ID = id;}
    public void setName(String name){this.Name = name;}
    public void setPhone(String phone){this.Phone = phone;}
    public void setEmail(String email){this.Email = email;}
    public void setAddress(String address){this.Address = address;}
    public void setPassword(String password){this.Password = password;}

    public String getID(){return this.ID;}
    public String getName(){return this.Name;}
    public String getPhone(){return this.Phone;}
    public String getEmail(){return this.Email;}
    public String getAddress(){return this.Address;}
    public String getPassword(){return this.Password;}

//    public JFXButton getButtonsUpdate() {
//        return ButtonsUpdate;
//    }
//
//    public JFXButton getButtonsDelete() {
//        return ButtonsDelete;
//    }



}
