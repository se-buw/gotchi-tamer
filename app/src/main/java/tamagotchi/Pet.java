package tamagotchi;
import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public abstract class Pet {
    protected String name_, sex_, stage_ = "Bébé";
    protected float hunger_ = 8.0f, hygiene_ = 8.0f, attention_ = 8.0f;
    protected float health_ = (hunger_+ hygiene_+attention_)/3;
    protected LocalDateTime birthday_, lastLogout_;
    protected Time age_;
    public boolean dead = false;
    public boolean sleeping = false;
    public String[] toy = {"bone", "ball", "yarn", "stick"};
    public String[] food = {"apple", "bread", "steak"};
    public String[] cleaning = {"bath", "toilet","grooming"};


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
                System.out.println(name_+" woved this food, this might be its favowite food uwu.");
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
            if (Throw()){
                attention_ +=3;
            }else {
                attention_ +=1;
            }
            if (getFavoriteToy().equals(currentToy)) {
                attention_ += 3;
                System.out.println(name_+" woved to pway wif this toy. it might be its favowite uwu.");
            } else {
                attention_ += 1;
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
    public boolean Throw(){
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        String distance;
        int distanceInt = r.nextInt(102);
            if (distanceInt < 34) {
                distance = "short";
            } else if (distanceInt < 68) {
                distance = "medium";

            } else {
                distance = "long";
            }
            System.out.println("How Long do you thwow uwu?");
            System.out.println("short \t medium \t long \t");
            String yourDist = s.nextLine().toLowerCase();
            if (yourDist.equals(distance)){
                System.out.println(name_+" cawtched the toy. Nice thwow uwu.");
                return true;
            }
            System.out.println(name_+" missed the toy."+ name_+" is sad. TwT");
            return false;
    }
    public boolean TicTacToe(){
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        char player = 'X';
        System.out.println("Uwu go fwist.");
        while (true) {
            System.out.println("Current board:");
            printBoard(board);
            System.out.println("Pwease enwer a wow and cowumn(0,1,2) sepewated by space.");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            if (board[row][column]!= ' '){
                System.out.println("Invawid move. Pwease wry again. =w=");
                continue;
            }
            board[row][column]=player;
            if(checkForWin(board,player)){
                System.out.println("Congwats uwu won. ^^");
                return true;
            }
            if(checkForDraw(board)){
                System.out.println("It's a draw. :(");
                return false;
            }
            System.out.println("Now it's "+name_+"s wurn. OwO");
            while (true) {
                row = r.nextInt(3);
                column = r.nextInt(3);
                if (board[row][column]==' '){
                    board[row][column]='O';
                    break;
                }
            }
            if(checkForWin(board,'O')){
                System.out.println(name_+" won the game. :)");
                return false;
            }
            if (checkForDraw(board)){
                System.out.println("It's a draw. :(");
                return false;
            }
        }
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean checkForWin(char[][] board, char player) {
        // check rows and columns for win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // check diagonals for win
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }

    public static boolean checkForDraw(char[][] board) {
        // check rows, columns and diagonals for a draw
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        if(!(board[0][0] == board[1][1] && board[0][0] == board[2][2]))
            return true;
        return !(board[0][2] == board[1][1] && board[0][2] == board[2][0]);
    }

}