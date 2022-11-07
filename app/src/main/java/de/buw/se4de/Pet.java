package de.buw.se4de;
import java.util.Date;


public abstract class Pet {
    protected String name_, sex_;
    // Todo: age should be implemented
    protected Date birthday_;
    protected int hunger = 10, hygiene = 10, attention = 10;
    protected int health = hunger + hygiene + attention;
    public Pet(){
        name_ = "None";
        sex_ = "None";
    }
    public Pet(String name, String sex){
        name_ = name;
        sex_ = sex;
        birthday_ = new Date();
    }
    String getName(){
        return name_;
    }
    String getSex(){
        return sex_;
    }
    // age is not done yet
    Date getBirthDay(){
        return birthday_;
    }
    abstract String getFavoriteFood();
    abstract String getFavoriteToy();

    // Todo: implement the getInformation method, which will print all the info about this pet
    void getInformation(){
        System.out.println("Name: " + name_ + "\t Sex: " + sex_ + "\t Age: " + birthday_);
        System.out.println("Hunger: " + hunger + "\t Hygiene: " + hygiene + "\t Attention: " + attention + "\t Health: "+ health);
    }
}

