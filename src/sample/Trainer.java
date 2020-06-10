package sample;

public class Trainer {
    private Info info;

    public Trainer(){}
    public Trainer(Info info){this.info = info;}
    public Trainer(String ID, String Name, String password, String Phone, String Email, String Address){
        this.info = new Info(ID, Name, password, Phone, Email, Address);
    }
    public void setInfo(Info info1){this.info = info1;}
    public Info getInfo(){return this.info;}
}
