package de.buw.se4de;
import java.util.Random;
import java.lang.Math;

class Dog extends Pet {
    protected String favorite_food_, favorite_toy_;

    public String get_fav_food(){
        return favorite_food_;
    }

    public String get_fav_toy(){
        return favorite_toy_;
    }

    public String random_fav_food(){
        String[] food = {"Chicken", "Pork", "Beef"};
        Random random_number = new Random();
        String fav_food = food[Math.abs(random_number.nextInt()) % food.length];
        return fav_food;
    }
    public String random_fav_toy(){
        String[] toy = {"Bone", "Ball", "Tire", "Stick"};
        Random random_number = new Random();
        String fav_toy = toy[Math.abs(random_number.nextInt()) % toy.length];
        return fav_toy;
    }
    public Dog(){
        super();
        this.favorite_food_ = "None";
        this.favorite_toy_ = "None";
    }

    public Dog(String name, String sex){
        super(name, sex);
    }
    public Dog(String name, String sex, int hunger, int hygiene, int attention, String fav_food, String fav_toy){
        super(name, sex, hunger, hygiene, attention);
        this.favorite_food_ = fav_food;
        this.favorite_toy_ =fav_toy;
    }
    public void feed(Dog dog){
        if(dog.hunger_ < 7){
            dog.hunger_ += 3;
        }
        else{
            dog.hunger_ = 10;
        }
    }

    public void clean(Dog dog){
        if(dog.hygiene_ <7){
            dog.hygiene_ += 3;
        }
        else{
            dog.hygiene_ = 10;
        }
    }

    public void play(Dog dog){
        if(dog.attention_ <7){
            dog.attention_ += 3;
        }
        else{
            dog.attention_ = 10;
        }
    }
}