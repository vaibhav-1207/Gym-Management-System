package sample;

public class User {
    private Info info;
    public User(Info i){ this.info = i; }
    public User(String ID, String Name, String password, String Phone, String Email, String Address){
        this.info = new Info(ID, Name, password, Phone, Email, Address);
    }
    public Info getInfo(){return this.info;}
    public void setInfo(Info info1){ this.info = info1; }
}
