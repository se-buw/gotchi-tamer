package tamagotchi;

import java.io.Serializable;

public abstract class Toy implements Serializable {
    String name;
    int fun;

    public Toy(String name, int fun){
        this.name = name;
        this.fun = fun;
    }
}

class Ball extends Toy{
    public Ball(){
        super("Ball", 6);
    }
}

class Stick extends Toy{
    public Stick(){
        super("Stick", 4);
    }
}

class Yarn extends Toy{
    public Yarn(){
        super("Yarn", 5);
    }
}