package sample;

public class Equipment {
    private String ID;
    private String Name;

    public Equipment(){}

    public Equipment(String ID, String Name){
        this.ID = ID;
        this.Name = Name;
    }

    public void setID(String ID) { this.ID = ID; }
    public void setName(String name) { this.Name = name; }

    public String getID() { return ID; }
    public String getName() { return Name; }
}
