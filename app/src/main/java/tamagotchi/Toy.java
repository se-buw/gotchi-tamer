package tamagotchi;

import java.io.Serializable;
import java.util.Random;

public abstract class Toy implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int fun;

    public Toy(String name, int fun){
        this.name = name;
        this.fun = fun;
    }

}

class Ball extends Toy{
    public Ball(){
        super("Ball", 3);
    }
}

class Stick extends Toy{
    public Stick(){
        super("Stick", 1);
    }
}

class Yarn extends Toy{
    public Yarn(){
        super("Yarn", 2);
    }
}