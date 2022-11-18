package tamagotchi;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Pet {
    protected String name;
    // protected String sex_;
    protected String stage = "Baby";
    protected int hunger = 3; // the value is initialized with 3 so that the pet is a little hungry when created
    protected Food favoriteFood;
    protected int hygiene = 10;
    protected int attention = 10;
    protected int health = hygiene + attention - hunger;
    protected LocalDateTime birthday, lastLogout_;
    protected Time age_;

    public Pet(){
    }

    public Pet(String name, String sex){
        this.name = name;
        this.birthday = LocalDateTime.now();
    }
    private LocalDateTime stringToLocalDateTime(String str){
        LocalDateTime dateTime = LocalDateTime.parse(str);
        return dateTime;
    }

    public Pet(String name, String sex, int hunger, int hygiene, int attention, String birthday, String lastLogout){
        this.name = name;
        // this.sex = sex;
        this.hunger = hunger;
        this.hygiene = hygiene;
        this.attention = attention;
        this.birthday = stringToLocalDateTime(birthday);
        lastLogout_ = stringToLocalDateTime(lastLogout);
        checkRange();
    }

    public abstract String getType();

    abstract String randomFavFood();
    abstract String randomFavToy();

    abstract String getFavoriteFood();

    abstract String getFavoriteToy();


    public String get_name(){ return name; }

    public int get_hunger(){
        return hunger;
    }

    public int get_hygiene(){
        return hygiene;
    }

    public int get_attention(){
        return attention;
    }

    LocalDateTime getBirthDay(){ return birthday; }

    LocalDateTime getLastLogout(){ return lastLogout_; }
    Time getAge(){return age_;}

    void setAge(){
        age_ = new Time(Duration.between(birthday, LocalDateTime.now()).toDays(), Duration.between(birthday, LocalDateTime.now()).toHours(), Duration.between(birthday, LocalDateTime.now()).toMinutes());
        if (age_.days_ >= 2 && age_.days_ < 4){
            stage = "Child";
        }
        else if (age_.days_ >= 4 && age_.days_ < 6){
            stage = "Teenager";
        }
        else if (age_.days_ >= 6 && age_.days_ < 12){
            stage = "Adult";
        }
        else if (age_.days_ >= 12){
            stage = "Senior";
        }
    }
    private void checkRange(){
        if (hunger < 0){
            hunger = 0;
        }
        if (hunger > 10){
            hunger = 10;
        }
        if (hygiene < 0){
            hygiene = 0;
        }
        if (hygiene > 10){
            hygiene = 10;
        }
        if (attention < 0){
            attention = 0;
        }
        if (attention > 10){
            attention = 10;
        }
        health = hunger + hygiene + attention;

    }

    public void feed(Food food){
        if (hunger == 0){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("I am not hungry :P");}
        else {
            if (favoriteFood == food) {
                hunger += 5;
                attention += 1;
                checkRange();
            } else {
                hunger += 3;
                checkRange();
            }
            hygiene -= 2;
            checkRange();
        }
    }

    public void clean(String cleaning){
        if(hygiene == 10){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(name +" is clean enough.");
        }
        else {
            hygiene += 3;
            checkRange();
        }

    }

    public void play(String favorite){

        if (attention == 10){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(name +" doesn't want to play with you anymore.");}
        else {
            if (getFavoriteToy().equals(favorite)) {
                attention += 5;
                checkRange();
            } else {
                attention += 3;
                checkRange();
            }
            hunger -= 2;
            hygiene -= 2;
            checkRange();
        }
    }

    void printInfo(){
        System.out.println("*********************************************");
        setAge();
        System.out.println("Name: " + name + "\t Age: " + age_.days_ + "D " + age_.hours_ + "H "+ age_.minutes_ + "M" + "\t Stage: " + stage);
        System.out.println("Hunger: " + hunger + "\t Hygiene: " + hygiene + "\t Attention: " + attention + "\t Health: "+ health);
        System.out.println("*********************************************");
    }

}