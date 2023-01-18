package tamagotchi;
import java.util.Random;
import java.lang.Math;

class Elemental extends Pet {
    protected String favorite_food_, favorite_toy_, type_ = "elemental";

    @Override
    public String getFavoriteFood(){
        return favorite_food_;
    }
    @Override
    public String getFavoriteToy(){
        return favorite_toy_;
    }

    public String getType(){ return type_;}
    Elemental(){
        super();
    }
    public Elemental(String type, String name, String sex){
        super(name, sex);
        type_ = type;
        favorite_food_ = randomFavFood();
        favorite_toy_ = randomFavToy();
    }

    public Elemental(String type, String name, String sex, int hunger, int hygiene, int attention, String fav_food, String fav_toy, String birthday, String lastLogout){
        super(name, sex, hunger, hygiene, attention, birthday, lastLogout);
        this.favorite_food_ = fav_food;
        this.favorite_toy_ = fav_toy;
        this.type_ = type;
    }
}