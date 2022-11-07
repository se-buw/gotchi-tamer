package de.buw.se4de;
import java.lang.Math;
import java.util.Random;


public class Pet {
    protected String name_, sex_;
    protected int hunger_ = 10, hygiene_ = 10, attention_ = 10;
    //private int health_ = hunger + hygiene + attention;
    public Pet(){
        this.name_ = "None";
        this.sex_ = "None";
        this.hunger_ = 10;
        this.hygiene_ = 10;
        this.attention_ = 10;
    }
    public Pet(String name, String sex){
        this.name_ = name;
        this.sex_ = sex;
    }

    public Pet(String name, String sex, int hunger, int hygiene, int attention){
        this.name_ = name;
        this.sex_ = sex;
        this.hunger_ = hunger;
        this.hygiene_ = hygiene;
        this.attention_ = attention;
    }

    public String get_name(){ return name_; }

    public String get_sex(){
        return sex_;
    }

    public int get_hunger(){
        return hunger_;
    }

    public int get_hygiene(){
        return hygiene_;
    }

    public int get_attention(){
        return attention_;
    }

}