package tamagotchi;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public abstract class Pet {
    protected String name_, sex_, stage_ = "Bébé";
    protected float hunger_ = 10.0f, hygiene_ = 10.0f, attention_ = 10.0f;
    protected float health_ = (hunger_+ hygiene_+attention_)/3;
    protected LocalDateTime birthday_, lastLogout_;
    protected Time age_;
    public String[] toy = {"Bone", "Ball", "Yarn", "Stick"};
    public String[] food = {"Apple", "Bread", "Steak"};
    public String[] cleaning = {"Bath", "Toilet","Grooming"};


    public Pet(){
        name_ = "None";
        sex_ = "None";
    }
    public void set_hunger(float f){hunger_ =f;}
    public void set_hygiene(float f){hygiene_=f;}
    public void set_attention(float f){attention_=f;}
    private LocalDateTime stringToLocalDateTime(String str){
        return LocalDateTime.parse(str);
    }

    public Pet(String name, String sex){
        name_ = name;
        sex_ = sex;
        birthday_ = LocalDateTime.now();
    }

    public Pet(String name, String sex, float hunger, float hygiene, float attention, String birthday, String lastLogout){
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

    public String randomFavFood(){
        Random random_number = new Random();
        return food[random_number.nextInt(food.length)];
    }
    String randomFavToy(){
        Random random_number = new Random();
        return toy[random_number.nextInt(toy.length)];
    }

    abstract String getFavoriteFood();

    abstract String getFavoriteToy();


    public String get_name(){ return name_; }

    public String get_sex(){
        return sex_;
    }

    public float get_hunger(){
        return hunger_;
    }

    public float get_hygiene(){
        return hygiene_;
    }

    public float get_attention(){
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
        health_ = (hunger_ + hygiene_ + attention_)/3;

    }


    public void feed(String favorite){
        if (hunger_ == 10){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(name_ +" is not hungwy. TT ");}
        else {
            if (getFavoriteFood().equals(favorite)) {
                hunger_ += 5;
                attention_ += 1;
            } else {
                hunger_ += 3;
            }
            hygiene_ -= 2;
        }
        checkRange();
    }

    public void clean(String cleaning){ //ToDo differenciate between clean possibilities
        if(hygiene_ == 10){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(name_ +" is cwean ewough. UwU");
        }
        else {
            hygiene_ += 3;
        }
        checkRange();
    }

    public void play(String currentToy){

        if (attention_ == 10){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(name_ +" doesn't want to pway with you anymowre.");}
        else {
            if (getFavoriteToy().equals(currentToy)) {
                attention_ += 5;
            } else {
                attention_ += 3;
            }
            hunger_ -= 2;
            hygiene_ -= 2;
        }
        checkRange();

    }
    public boolean check_death(){
        checkRange();
        return health_ <= 0;
    }

    void getInformation(){
        System.out.println("*********************************************");
        setAge();
        System.out.println("Name: " + name_ + "\t Seggs: " + sex_ + "\t OwO: " + age_.days_ + "D " + age_.hours_ + "H "+ age_.minutes_ + "M" + "\t Stage: " + stage_);
        System.out.println("Hungwy: " + hunger_ + "\t Hygiwe: " + hygiene_ + "\t Attentiwn: " + attention_ + "\t Hewwth: "+ health_);
        System.out.println("*********************************************");
    }

}