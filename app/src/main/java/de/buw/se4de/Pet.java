package de.buw.se4de;
import java.lang.Math;
import java.util.Random;


public abstract class Pet {
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

    public abstract String random_fav_food();
    public abstract String random_fav_toy();

    public abstract String get_fav_food();

    public abstract String get_fav_toy();
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

    public void feed(Pet dog ){
        if(dog.hunger_ < 7){
            System.out.println("Before feeding: " + dog.hunger_);
            dog.hunger_ += 3;
            System.out.println("After feeding: " + dog.hunger_);
        }
        else if (dog.hunger_ <= 9 && dog.hunger_ >= 7){
            System.out.println("Before feeding: " + dog.hunger_);
            dog.hunger_ = 10;
            System.out.println("After feeding: " + dog.hunger_);
        }
        else if (dog.hunger_ == 10){
            System.out.println(dog.name_ +" is not hungry");
        }
    }

    public void clean(Pet dog){
        if(dog.hygiene_ < 7){
            System.out.println("Before cleaning: " + dog.hygiene_);
            dog.hygiene_ += 3;
            System.out.println("After cleaning: " + dog.hygiene_);
        }
        else if (dog.hygiene_ <= 9 && dog.hygiene_ >= 7){
            System.out.println("Before cleaning: " + dog.hygiene_);
            dog.hygiene_ = 10;
            System.out.println("After cleaning: " + dog.hygiene_);
        }
        else if (dog.hygiene_ == 10){
            System.out.println(dog.name_ +" is clean enough");
        }
    }

    public void play(Pet dog){
        if(dog.attention_ < 7){
            System.out.println("Before playing: " + dog.attention_);
            dog.attention_ += 3;
            System.out.println("After playing: " + dog.attention_);
        }
        else if (dog.attention_ <= 9 && dog.attention_ >= 7){
            System.out.println("Before playing: " + dog.attention_);
            dog.attention_ = 10;
            System.out.println("After playing: " + dog.attention_);
        }
        else if (dog.attention_ == 10){
            System.out.println(dog.name_ +" Don't wants to play with you anymore.");
        }
    }

}