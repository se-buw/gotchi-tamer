package tamagotchi;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

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
        this.dirtiness = 5;
        this.boredom = 5;
        this.hunger = 5;
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
                hunger -= 2;
                checkRange();
            } else {
                hunger -= 1;
                checkRange();
            }
            dirtiness += 2;
            checkRange();
        }
    }

    public void clean(String cleaning){
        if(dirtiness == 0){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(name +" is clean enough.");
        }
        else {
            dirtiness -= 3;
            checkRange();
        }

    }

    public void play(Toy toy) {
// when would the pet not want to play? consider adding attribute boredom
        if (boredom == 0) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("I don't want to play with you yet.");}
        else {
            Random rand = new Random();
            Scanner sr = new Scanner(System.in);
            String side = null;
            boolean finished = false;
            int tries = 0;

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("I want you to play with me! You should pick the same side as I do.");

            while (!finished) {
                int random = rand.nextInt(2);
                //0 - left, 1 - center, 2 - right
                if (random == 0) {
                    side = "left";
                } else if (random == 1) {
                    side = "center";
                } else if (random == 2) {
                    side = "right";
                }
                System.out.println("What side do you choose?");
                System.out.println("left \t center \t right");
                String input = sr.nextLine().toLowerCase();
                
                if (input.equals(side)) {
                    System.out.println("You got it right! I like playing with you!");
                    if (toy == favoriteToy) {
                        boredom -= toy.fun + 2;
                        checkRange();
                        finished = true;
                    } else {
                        boredom -= toy.fun + 1;
                        checkRange();
                        finished = true;
                    }
                } else {
                    System.out.println("You got it wrong :( Do you want to have another try?");
                    System.out.println("yes \t no");
                    Scanner sr1 = new Scanner(System.in);
                    String input2 = sr1.nextLine().toLowerCase();

                    while(!input2.equals("yes") && !input2.equals("no")){
                            System.out.println("That is not a valid answer!");
                            System.out.println("Please answer yes or no.");
                            input2 = sr.nextLine().toLowerCase();
                    }
                    if (input2.equals("no")){
                        finished = true;
                    }
                    else if (input2.equals("yes")){
                        tries += 1;
                        if (tries == 3)
                        {
                            System.out.println("Sorry. I am tired of playing.");
                            finished = true;
                        }
                    }
                }
            }
        }
        dirtiness += 2;
        checkRange();
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

    public boolean check_death(){
        if ((this.hunger + this.boredom + this.dirtiness) == 30) {
            return true;
        }else{
            return false;
        }
    }

    public void dead(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(this.name + " died!");
        System.out.println(this.name + " R.I.P");
        System.out.println("You are a terrible owner!!");
        System.out.println(" :( \t :( \t :( \t :( \t :( \t :( \t :( ");
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