package sample;

public class ExercisePlan1 {
    String ID;
    String user;
    String Trainer;
    String equipment;
    String Start;
    String End;
    ExercisePlan1(String ID,String user,String Trainer,String equipment,String Start,String End){
        this.ID=ID;
        this.user=user;
        this.Trainer=Trainer;
        this.equipment=equipment;
        this.Start=Start;
        this.End=End;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEnd() {
        return End;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getStart() {
        return Start;
    }

    public String getTrainer() {
        return Trainer;
    }

    public String getUser() {
        return user;
    }

    public void setEnd(String end) {
        End = end;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public void setStart(String start) {
        Start = start;
    }

    public void setTrainer(String trainer) {
        Trainer = trainer;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
