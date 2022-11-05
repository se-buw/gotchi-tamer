package de.buw.se4de;
import java.lang.Math;



public class Pet {
    private String name_, sex_;
    private int hunger = 10, hygiene = 10, attention = 10;
    private int health = hunger + hygiene + attention;
    public Pet(){
        name_ = "None";
        sex_ = "None";
    }
    public Pet(String name, String sex){
        name_ = name;
        sex_ = sex;
    }

}

