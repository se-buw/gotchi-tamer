package tamagotchi;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Pet implements Serializable {
    protected String name;
    // protected String sex;
    protected LocalDateTime birthday;
    protected Food favoriteFood;
    protected Toy favoriteToy;
    protected int dirtiness;
    protected int boredom;
    protected int hunger;

    private static final long serialVersionUID = 10L;

    public Pet(String name, Food favoriteFood, Toy favoriteToy){
        this.name = name;
        this.birthday = LocalDateTime.now();
        this.favoriteFood = favoriteFood;
        this.favoriteToy = favoriteToy;
    }

    protected Time computeAge(){
        return new Time(
                Duration.between(birthday, LocalDateTime.now()).toDays(),
                Duration.between(birthday, LocalDateTime.now()).toHours(),
                Duration.between(birthday, LocalDateTime.now()).toMinutes());
    }
    protected String computeStage(){
        Time age = computeAge();
        if (age.days_ < 3){
            return "Child";
        }
        else if (age.days_ < 6){
            return "Teenager";
        }
        else if (age.days_ < 12){
            return "Adult";
        }
        return "Senior";
    }

    public void feed(Food food){
        if (hunger == 0){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("I am not hungry :P");}
        else {
            if (favoriteFood == food) {
                boredom += 1;
                checkRange();
            } else {
                checkRange();
            }
            dirtiness -= 2;
            checkRange();
        }
    }

    public void clean(String cleaning){
        if(dirtiness == 10){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(name +" is clean enough.");
        }
        else {
            dirtiness += 3;
            checkRange();
        }

    }

    public void play(Toy toy) {
// when would the pet not want to play? consider adding attribute boredom
        if (boredom == 0) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("I don't want to play with you anymore.");
            if (toy == favoriteToy) {
                boredom += 5;
                checkRange();
            } else {
                boredom += 3;
                checkRange();
            }
            dirtiness -= 2;
            checkRange();
        }
    }

    private void checkRange(){
        if (hunger < 0){
            hunger = 0;
        }
        if (hunger > 10){
            hunger = 10;
        }
        if (dirtiness < 0){
            dirtiness = 0;
        }
        if (dirtiness > 10){
            dirtiness = 10;
        }
        if (boredom < 0){
            boredom = 0;
        }
        if (boredom > 10){
            boredom = 10;
        }
    }
    void printInfo(){
        System.out.println("*********************************************");
        System.out.println("Name: " + name + "\t Age: " + computeAge().days_ + "D " + computeAge().hours_ + "H "+ computeAge().minutes_ + "M" + "\t Stage: " + computeStage());
        System.out.println("Hunger: " + hunger + "\t Dirtiness: " + dirtiness + "\t Boredom: " + boredom);
        System.out.println("*********************************************");
    }

    @Override
    public String toString() {
        return "Name:" + name + "\nBirthday: " + birthday +
                "\nFavorite food: " + favoriteFood + "\nFavorite toy: " + favoriteToy +
                "\nDirtiness: " + dirtiness + "\nBoredom: " + boredom + "\nHunger: " + hunger;
    }

}

class Dog extends Pet {
    Dog(String name) {
        super(name, new Steak(), new Ball());
    }
}

class Cat extends Pet{
    Cat(String name){
        super(name, new Tuna(), new Yarn());
    }
}