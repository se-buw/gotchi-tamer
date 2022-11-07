package de.buw.se4de;
import java.util.Random;
import java.lang.Math;

class Dog extends Pet {
    private String favorite_food_, favorite_toy_;
    public Dog(String name, String sex){
        super(name, sex);
        favorite_food_ = getFavoriteFood();
        favorite_toy_ = getFavoriteToy();
    }
    @Override
    public String getFavoriteFood(){
        String[] food = {"Chicken", "Pork", "Beef"};
        Random random_number = new Random();
        String fav_food = food[Math.abs(random_number.nextInt()) % 3];
        return fav_food;
    }
    @Override
    public String getFavoriteToy(){
        String[] toy = {"Bone", "Ball", "Tire", "Stick"};
        Random random_number = new Random();
        String fav_toy = toy[Math.abs(random_number.nextInt()) % 4];
        return fav_toy;
    }


}
