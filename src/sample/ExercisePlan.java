package sample;

import javafx.scene.control.Button;

public class ExercisePlan {
    private String ID;
    private String trainer;
    private String equipment;
    private String start;
    private String end;
    private Button subButton;

    public ExercisePlan(){}
    public ExercisePlan(String ID,String trainer, String equipment, String start, String end){
        this.ID = ID;
        this.trainer=trainer;
        this.equipment = equipment;
        this.start = start;
        this.end = end;
        this.subButton = new Button("Subscribe");
    }

    public void setID(String ID) { this.ID = ID; }
    public void setEquipment(String equipment) { this.equipment = equipment; }
    public void setTrainer(String trainer) { this.trainer = trainer; }

    public String getID() { return this.ID; }
    public String getEquipment() { return this.equipment; }
    public String getTrainer() { return this.trainer; }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Button getSubButton() {
        return subButton;
    }

    public void setSubButton(Button subButton) {
        this.subButton = subButton;
    }
}
