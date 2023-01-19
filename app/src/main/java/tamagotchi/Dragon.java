package tamagotchi;
import java.util.Random;
import java.lang.Math;

class Dragon extends Pet {
    protected String favorite_food_, favorite_toy_, type_ = "dragon";

    @Override
    public String getFavoriteFood(){
        return favorite_food_;
    }
    @Override
    public String getFavoriteToy(){
        return favorite_toy_;
    }

    public String getType(){ return type_;}
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
    Dragon(){
        super();
    }
    public Dragon(String name, String sex){
        super(name, sex);
        type_ = "dragon";
        favorite_food_ = randomFavFood();
        favorite_toy_ = randomFavToy();
    }
    public Dragon(String type, String name, String sex){
        super(name, sex);
        type_ = type;
        favorite_food_ = randomFavFood();
        favorite_toy_ = randomFavToy();
    }

    public Dragon(String type, String name, String sex, float hunger, float hygiene, float attention, String fav_food, String fav_toy, String birthday, String lastLogout){
        super(name, sex, hunger, hygiene, attention, birthday, lastLogout);
        this.favorite_food_ = fav_food;
        this.favorite_toy_ = fav_toy;
    }


}