package de.buw.se4de;

import java.time.LocalDateTime;

public abstract class Pet {
    protected String name_, sex_;
    protected int hunger_ = 10, hygiene_ = 10, attention_ = 10;
    protected int health = hunger_ + hygiene_ + attention_;

    protected LocalDateTime birthday_;
    protected Time age_;

    public Pet(){
        name_ = "None";
        sex_ = "None";
    }
    public Pet(String name, String sex){
        name_ = name;
        sex_ = sex;
        birthday_ = LocalDateTime.now();
    }
    private LocalDateTime stringToLocalDateTime(String str){
        LocalDateTime dateTime = LocalDateTime.parse(str);
        return dateTime;
    }
    public Pet(String name, String sex, int hunger, int hygiene, int attention, String birthday){
        name_ = name;
        sex_ = sex;
        hunger_ = hunger;
        hygiene_ = hygiene;
        attention_ = attention;
        birthday_ = stringToLocalDateTime(birthday);
    }

    abstract String randomFavFood();
    abstract String randomFavToy();

    abstract String getFavoriteFood();

    abstract String getFavoriteToy();

    //Todo getter ändern mit Großbuchstaben
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

    LocalDateTime getBirthDay(){ return birthday_; }
    Time getAge(){return age_;}

    void setAge(Time newAge){
        age_ = newAge;
    }

// Todo: berechnungen der variablen in den methoden anpassen
    public void feed(){
        if(hunger_ < 7){
            System.out.println("Before feeding: " + hunger_);
            hunger_ += 3;
            System.out.println("After feeding: " + hunger_);
        }
        else if (hunger_ <= 9 && hunger_ >= 7){
            System.out.println("Before feeding: " + hunger_);
            hunger_ = 10;
            System.out.println("After feeding: " + hunger_);
        }
        else if (hunger_ == 10){
            System.out.println(name_ +" is not hungry");
        }
    }

    public void clean(){
        if(hygiene_ < 7){
            System.out.println("Before cleaning: " + hygiene_);
            hygiene_ += 3;
            System.out.println("After cleaning: " + hygiene_);
        }
        else if (hygiene_ <= 9 && hygiene_ >= 7){
            System.out.println("Before cleaning: " + hygiene_);
            hygiene_ = 10;
            System.out.println("After cleaning: " + hygiene_);
        }
        else if (hygiene_ == 10){
            System.out.println(name_ +" is clean enough");
        }
    }

    public void play(){
        if(attention_ < 7){
            System.out.println("Before playing: " + attention_);
            attention_ += 3;
            System.out.println("After playing: " + attention_);
        }
        else if (attention_ <= 9 && attention_ >= 7){
            System.out.println("Before playing: " + attention_);
            attention_ = 10;
            System.out.println("After playing: " + attention_);
        }
        else if (attention_ == 10){
            System.out.println(name_ +" Don't wants to play with you anymore.");
        }
    }

    void getInformation(){
        System.out.println("*********************************************");
        System.out.println("Name: " + name_ + "\t Sex: " + sex_ + "\t Age: " + age_.days_ + "D " + age_.hours_ + "H "+ age_.minuets_ + "M" );
        System.out.println("Hunger: " + hunger_ + "\t Hygiene: " + hygiene_ + "\t Attention: " + attention_ + "\t Health: "+ health);
        System.out.println("*********************************************");
    }

}