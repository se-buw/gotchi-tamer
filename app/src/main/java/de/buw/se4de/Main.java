package de.buw.se4de;
import java.time.Duration;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Main {
    public static void main(String[] args) {
        // Todo: the variable new_game should be saved
        String new_game = "false";
        if (new_game.equals("true")){
            startNewGame();
            new_game = "false";
        }
        else{
            startGame();
        }

    }
    public static void startNewGame(){
        // this array of pets here is for later when we have more than just the dog
        String[] pets = {"dog"};

        System.out.println("Welcome to Tamagotchi!");
        System.out.println("In Tamagotchi you can create your own digital pet. The rule is easy, keep your pet alive!");
        System.out.println("That means simply, you have to take care of your pet");
        System.out.println("First, choose what kind of pet you want:");
        // listing what kinds of pets are available
        for (String pet : pets){
            System.out.println(pet);
        }
        Scanner input = new Scanner(System.in);
        // Todo: the input should be saved
        String selectedPet = input.nextLine().toLowerCase();
        // while loop need to be edited if there is more pets
        while (!selectedPet.equals(pets[0])){
            System.out.println("You can only choose from the listed pet above!");
            selectedPet = input.nextLine().toLowerCase();
        }
        System.out.println("What is the name of your " + selectedPet + "?");

        // Todo: the input should be saved
        String name = input.nextLine();
        System.out.println("Which gender should your " + selectedPet + " have?");
        System.out.println("You can choose between male and female.");

        // Todo: the input should be saved
        String sex = input.nextLine().toLowerCase();
        while(!sex.equals("male") && !sex.equals("female")){
            System.out.println("Please write male or female.");
            sex = input.nextLine().toLowerCase();
        }
        // to check
        System.out.println("Pet: " + selectedPet);
        System.out.println("name: " + name);
        System.out.println("sex: " + sex);
    }

    public static void startGame(){
        // Todo: code that read the file pet and make it here
        Pet dog = new Dog("coco", "male");
        dog.getInformation();

        LocalDateTime ldt1 = LocalDateTime.now();
        LocalDateTime ldt2 = ldt1.plusDays(3);

        long ldt3 =Duration.between(ldt1, ldt2).toMinutes();

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd HH:mm:ss");
        //String ldt4 = ldt3.toString();

        System.out.println(ldt1);
        System.out.println(ldt2);
        System.out.println(ldt3);
        //System.out.println(ldt4);

        /*
        Scanner input = new Scanner(System.in);
        boolean close = false;
        while (!close){



            close = true;
        }*/
    }

}
