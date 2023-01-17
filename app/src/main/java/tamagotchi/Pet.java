package tamagotchi;
import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Pet {
    protected String name_, sex_, stage_ = "Bébé";
    protected int hunger_ = 10, hygiene_ = 10, attention_ = 10;
    protected int health_ = hunger_ + hygiene_ + attention_;
    protected LocalDateTime birthday_, lastLogout_;
    protected Time age_;
    public String[] toy = {"Bone", "Ball", "Tire", "Stick"};
    public String[] food = {"Mana", "Sheep", "Human"};
    public String[] cleaning = {"Bath", "Toilet","Grooming"};


    public Pet(){
        name_ = "None";
        sex_ = "None";
    }
    private LocalDateTime stringToLocalDateTime(String str){
        return LocalDateTime.parse(str);
    }

    public Pet(String name, String sex){
        name_ = name;
        sex_ = sex;
        birthday_ = LocalDateTime.now();
    }

    public Pet(String name, String sex, int hunger, int hygiene, int attention, String birthday, String lastLogout){
        name_ = name;
        sex_ = sex;
        hunger_ = hunger;
        hygiene_ = hygiene;
        attention_ = attention;
        birthday_ = stringToLocalDateTime(birthday);
        lastLogout_ = stringToLocalDateTime(lastLogout);
        checkRange();
    }

    public abstract String getType();

    abstract String randomFavFood();
    abstract String randomFavToy();

    abstract String getFavoriteFood();

    abstract String getFavoriteToy();


    public String get_name(){ return name_; }

    public String get_sex(){
        return sex_;
    }

    public int get_hunger(){
        return hunger_;
    }

    public int get_hygiene(){
        return hygiene_;
    }

    public int get_attention(){
        return attention_;
    }

    LocalDateTime getBirthDay(){ return birthday_; }

    LocalDateTime getLastLogout(){ return lastLogout_; }
    Time getAge(){return age_;}

    void setAge(){
        age_ = new Time(Duration.between(birthday_, LocalDateTime.now()).toDays(), Duration.between(birthday_, LocalDateTime.now()).toHours(), Duration.between(birthday_, LocalDateTime.now()).toMinutes());
        if (age_.days_ >= 2 && age_.days_ < 4){
            stage_ = "Child";
        }
        else if (age_.days_ >= 4 && age_.days_ < 6){
            stage_ = "Teenager";
        }
        else if (age_.days_ >= 6 && age_.days_ < 12){
            stage_ = "Adult";
        }
        else if (age_.days_ >= 12){
            stage_ = "Senior";
        }
    }
    private void checkRange(){
        if (hunger_ < 0){
            hunger_ = 0;
        }
        if (hunger_ > 10){
            hunger_ = 10;
        }
        if (hygiene_ < 0){
            hygiene_ = 0;
        }
        if (hygiene_ > 10){
            hygiene_ = 10;
        }
        if (attention_ < 0){
            attention_ = 0;
        }
        if (attention_ > 10){
            attention_ = 10;
        }
        health_ = hunger_ + hygiene_ + attention_;

    }


    public void feed(String favorite){
        if (hunger_ == 10){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(name_ +" is not hungwy. TT ");}
        else {
            if (getFavoriteFood().equals(favorite)) {
                hunger_ += 5;
                attention_ += 1;
                checkRange();
            } else {
                hunger_ += 3;
                checkRange();
            }
            hygiene_ -= 2;
            checkRange();
        }
    }

    public void clean(String cleaning){
        if(hygiene_ == 10){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(name_ +" is cwean ewough. UwU");
        }
        else {
            hygiene_ += 3;
            checkRange();
        }

    }

    public void play(String favorite){

        if (attention_ == 10){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(name_ +" doesn't want to pway with you anymowre.");}
        else {
            if (getFavoriteToy().equals(favorite)) {
                attention_ += 5;
                checkRange();
            } else {
                attention_ += 3;
                checkRange();
            }
            hunger_ -= 2;
            hygiene_ -= 2;
            checkRange();
        }
    }

    void getInformation(){
        System.out.println("*********************************************");
        setAge();
        System.out.println("Name: " + name_ + "\t Secks: " + sex_ + "\t OwO: " + age_.days_ + "D " + age_.hours_ + "H "+ age_.minutes_ + "M" + "\t Stage: " + stage_);
        System.out.println("Hunger: " + hunger_ + "\t Hygiene: " + hygiene_ + "\t Attention: " + attention_ + "\t Health: "+ health_);
        System.out.println("*********************************************");
    }

}