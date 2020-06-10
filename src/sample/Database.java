package sample;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    public static HashMap<String, String> TrainerUserNameToPasswordHashmap;
    public static HashMap<String, String> UserNameToPasswordHashmap;
    public static HashMap<String,Integer> NametoID;
    public static ArrayList<Info> UserList;
    public static ArrayList<Info> TrainerList;
    public static ArrayList<Equipment> EquipmentList;
    public static int IDX=0;
    public static ArrayList<ExercisePlan>[] ExercisePlanList = new ArrayList[1000];
    public static ArrayList<ExercisePlan1> ExercisePlanList1;
    public static int ID = 0,EID=0;
    public Database(){
        TrainerUserNameToPasswordHashmap = new HashMap<>();
        UserNameToPasswordHashmap = new HashMap<>();
        NametoID = new HashMap<>();
        TrainerList = new ArrayList<>();
        UserList = new ArrayList<>();
        for(int i=0; i<1000; i++)
            ExercisePlanList[i] = new ArrayList<>();
        EquipmentList = new ArrayList<>();
        ExercisePlanList1=new ArrayList<>();
//        TrainerUserNameToPasswordHashmap.put("Trainer1", "t1");
//        TrainerUserNameToPasswordHashmap.put("Trainer2", "t2");
//        UserNameToPasswordHashmap.put("User1", "u1");
//        UserNameToPasswordHashmap.put("vaibhav", "1234");
//        UserList.add(new Info("1", "hero", "hero", "1234567890", "hero@gmail.com", "kjasdhfhasjdfjsaldkjf"));
//        UserList.add(new Info("2", "hero1", "hero", "1234567890", "hero1@gmail.com", "dafsdkjfkla89349sn9"));
//        UserList.add(new Info("9", "hero2", "hero", "1230987654", "hero2@gmail.com", "aekljdfbale4rlanwf"));
//        UserList.add(new Info("3", "hero3", "hero", "1234567", "hero3@gmail.com", "sdafgakkliurlfwe"));
//        TrainerList.add(new Info("1.9", "trainer3", "hero", "123", "trainer3@gmail.com", "failw8ebfa"));
//        TrainerList.add(new Info("1.9", "trainer4", "hero", "123", "trainer4@gmail.com", "7alugifawkuiegfk"));

    }

}
