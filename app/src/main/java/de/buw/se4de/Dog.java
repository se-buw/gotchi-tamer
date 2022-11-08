package de.buw.se4de;
import java.util.Random;
import java.lang.Math;

class Dog extends Pet {
    protected String favorite_food_, favorite_toy_;
    @Override
    public String getFavoriteFood(){
        return favorite_food_;
    }
    @Override
    public String getFavoriteToy(){
        return favorite_toy_;
    }
    @Override
    public String randomFavFood(){
        String[] food = {"Apple", "Bread", "Steak"};
        Random random_number = new Random();
        String fav_food = food[Math.abs(random_number.nextInt()) % food.length];
        return fav_food;
    }
    @Override
    public String randomFavToy(){
        String[] toy = {"Bone", "Ball", "Tire", "Stick"};
        Random random_number = new Random();
        String fav_toy = toy[Math.abs(random_number.nextInt()) % toy.length];
        return fav_toy;
    }

    public Dog(String name, String sex){
        super(name, sex);
        favorite_food_ = randomFavFood();
        favorite_toy_ = randomFavToy();
    }

    public Dog(String name, String sex, int hunger, int hygiene, int attention, String fav_food, String fav_toy){
        super(name, sex, hunger, hygiene, attention);
        this.favorite_food_ = fav_food;
        this.favorite_toy_ = fav_toy;
    }
}