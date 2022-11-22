package tamagotchi;

import java.io.Serializable;

public abstract class Food implements Serializable {
    String name;
    int energy;

    public Food(String name, int energy){
        this.name = name;
        this.energy = energy;
    }

    void printInfo(){

    }
}

class Apple extends Food{
    public Apple() {
        super("apple", 1);
    }
}

class Bread extends Food{
    public Bread() {
        super("bread", 3);
    }
}

class Steak extends Food{
    public Steak() {
        super("steak", 4);
    }
}

class Tuna extends Food{
    public Tuna(){super("tuna", 4);}
}