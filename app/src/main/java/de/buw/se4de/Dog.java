package de.buw.se4de;
import java.util.Random;
import java.lang.Math;

class Dog extends Pet {
    private String favorite_food_, favorite_toy_;

    public String get_favourite_food(){
        String[] food = {"Chicken", "Pork", "Beef"};
        Random random_number = new Random();
        String fav_food = food[Math.abs(random_number.nextInt()) % 3];
        return fav_food;
    }
    public String get_favourite_toy(){
        String[] toy = {"Bone", "Ball", "Tire", "Stick"};
        Random random_number = new Random();
        String fav_toy = toy[Math.abs(random_number.nextInt()) % 4];
        return fav_toy;
    }
    public Dog(String name, String sex){
        Pet pet = new Pet(name, sex);
        favorite_food_ = get_favourite_food();
        favorite_toy_ = get_favourite_toy();
    }

}
