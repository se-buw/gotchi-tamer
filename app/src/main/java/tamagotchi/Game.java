package tamagotchi;

import java.io.*;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDateTime;


public class Game {

    public static Pet startNewGame() throws IOException {
        String[] pets = {"dog", "cat"};
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Welcome to Tamagotchi.");
        System.out.println("In Tamagotchi you can create your own digital pet. The rule is easy, keep your pet alive!");
        System.out.println("That means simply, you have to take care of your pet");
        System.out.println("First, choose what kind of pet you want:");
        // listing what kinds of pets are available
        System.out.println("You can choose between dog or cat!");
        Scanner input = new Scanner(System.in);
        String selectedPet = input.nextLine();

        while (!selectedPet.equals(pets[0]) && !selectedPet.equals(pets[1])){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("You can only choose from the listed pets above!");
            selectedPet = input.nextLine().toLowerCase();
        }
        System.out.println("What is the name of your " + selectedPet + "?");
        String name = input.nextLine();
        /*
        System.out.println("Which gender should your " + selectedPet + " have?");
        System.out.println("You can choose between male and female.");
        String sex = input.nextLine().toLowerCase();
        while(!sex.equals("male") && !sex.equals("female")){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Please write male or female.");
            sex = input.nextLine().toLowerCase();
        }
        */

        if (selectedPet.equals("dog")){
            Pet pet = new Dog(name);
            write_file(pet);
            return pet;
        }
        else {
            Pet pet = new Cat(name);
            write_file(pet);
            return pet;
        }
    }
    public static void startGame(Pet pet) throws IOException {
        pet.printInfo();
        displayChoices();
        Scanner sr = new Scanner(System.in);
        boolean close = false;
            do {
                String input = sr.nextLine().toLowerCase();
                boolean back = false;

                switch (input) {
                    case "feed" -> {
                        System.out.println("What do you want to feed " + pet.name + "?");
                        System.out.println("apple \t bread \t steak \t tuna \t back");
                        input = sr.nextLine().toLowerCase();
                        do {
                            switch (input) {
                                case "apple" -> {
                                    pet.feed(new Apple());
                                    back = true;
                                    if (!pet.check_death())
                                    {
                                        pet.printInfo();
                                        displayChoices();
                                    }
                                    else {pet.dead();
                                        close = true;}
                                }
                                case "bread" -> {
                                    pet.feed(new Bread());
                                    back = true;
                                    if (!pet.check_death())
                                    {
                                        pet.printInfo();
                                        displayChoices();
                                    }
                                    else {pet.dead();
                                        close = true;}
                                }
                                case "steak" -> {
                                    pet.feed(new Steak());
                                    back = true;
                                    if (!pet.check_death())
                                    {
                                        pet.printInfo();
                                        displayChoices();
                                    }
                                    else {pet.dead();
                                        close = true;}
                                }
                                case "tuna" -> {
                                    pet.feed(new Tuna());
                                    back = true;
                                    if (!pet.check_death())
                                    {
                                        pet.printInfo();
                                        displayChoices();
                                    }
                                    else {pet.dead();
                                        close = true;}
                                }
                                case "back" -> {
                                    back = true;
                                    pet.printInfo();
                                    displayChoices();
                                }
                                default -> {
                                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                                    System.out.println("That is not a valid command!");
                                    System.out.println("Please select from the listed food above!");
                                    input = sr.nextLine().toLowerCase();
                                }
                            }
                        } while (!back);
                    }
                    case "clean" -> {
                        System.out.println("What do you want to clean for " + pet.name + "?");
                        System.out.println("bath \t toilet \t grooming \t back");
                        input = sr.nextLine().toLowerCase();
                        back = false;
                        do {
                            switch (input) {
                                case "bath" -> {
                                    pet.clean("bath");
                                    back = true;
                                    if (!pet.check_death())
                                    {
                                        pet.printInfo();
                                        displayChoices();
                                    }
                                    else {pet.dead();
                                        close = true;}
                                }
                                case "toilet" -> {
                                    pet.clean("toilet");
                                    back = true;
                                    if (!pet.check_death())
                                    {
                                        pet.printInfo();
                                        displayChoices();
                                    }
                                    else {pet.dead();
                                        close = true;}
                                }
                                case "grooming" -> {
                                    pet.clean("grooming");
                                    back = true;
                                    if (!pet.check_death())
                                    {
                                        pet.printInfo();
                                        displayChoices();
                                    }
                                    else {pet.dead();
                                        close = true;}
                                }
                                case "back" -> {
                                    back = true;
                                    pet.printInfo();
                                    displayChoices();
                                }
                                default -> {
                                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                                    System.out.println("That is not a valid command!");
                                    System.out.println("Please select from the listed clean activities above!");
                                    input = sr.nextLine().toLowerCase();
                                }
                            }
                        } while (!back);
                    }
                    case "play" -> {
                        System.out.println("What do you want to play with " + pet.name + "?");
                        System.out.println("ball \t stick \t yarn \t back");
                        input = sr.nextLine().toLowerCase();
                        back = false;
                        do {
                            switch (input) {
                                case "ball" -> {
                                    pet.play(new Ball());
                                    back = true;
                                    pet.printInfo();
                                    displayChoices();
                                }
                                case "stick" -> {
                                    pet.play(new Stick());
                                    back = true;
                                    pet.printInfo();
                                    displayChoices();
                                }
                                case "yarn" -> {
                                    pet.play(new Yarn());
                                    back = true;
                                    pet.printInfo();
                                    displayChoices();
                                }
                                case "back" -> {
                                    back = true;
                                    pet.printInfo();
                                    displayChoices();
                                }
                                default -> {
                                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                                    System.out.println("That is not a valid command!");
                                    System.out.println("Please select from the listed toys above!");
                                    input = sr.nextLine().toLowerCase();
                                }
                            }
                        } while (!back);
                    }
                    case "save" -> {
                        write_file(pet);
                        pet.printInfo();
                        displayChoices();
                    }
                    case "close" -> {
                        write_file(pet);
                        close = true;
                    }
                    default -> {
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        System.out.println("That is not a valid command!");
                    }
                }
            } while (!close);
        }


    public static void displayChoices(){
        System.out.println("Interactions with the pet:");
        System.out.println("feed \t clean \t play \t save \t close");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        boolean quit = false;

        // TODO: update the values according to the time that has passed since the last session

        do {
            System.out.println("**********************************************************************");
            System.out.println("If you played this game before and want to continue, please write load");
            System.out.println("If you want to create a new tamagotchi game, please write create");
            System.out.println("Choices: load \t create \t quit");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine().toLowerCase();

            if (command.equals("create")) {
                Pet pet = startNewGame();
                if (pet.name.equals("None")) {
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    System.out.println("Something went wrong! Please try again!");
                } else {
                    startGame(pet);
                    quit = true;
                }

            } else if (command.equals("load")) {
                System.out.println("What is the name of the pet you want to interact with?");
                String NameOfPet = scanner.nextLine().toLowerCase();
                Pet pet = read_file(NameOfPet);
                if (pet.name.equals("None")) {
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                } else {
                    startGame(pet);
                    quit = true;
                }
            }
            else if(command.equals("quit")) {
                quit = true;
            }
            else {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.println("That is not a valid choice!");
            }
        }while (!quit);
    }

    static void write_file(Pet pet) throws IOException {

        //change the path
        String filepath = "C:\\Users\\ufimt\\Desktop\\Projects\\Gotchi tamer\\gotchi-tamer\\"+ pet.name + ".txt";
        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(pet);
            objectOut.close();
            //System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
    static Pet read_file(String nameOfPet) throws IOException, ClassNotFoundException {

        FileInputStream fi = new FileInputStream(nameOfPet + ".txt");
        ObjectInputStream oi = new ObjectInputStream(fi);

        // Read objects
        Pet pet = (Pet) oi.readObject();

        oi.close();
        fi.close();

        return pet;
    }

}


/*
package tamagotchi;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.io.File;
import java.util.Scanner;

@Command(
        name = "Game",
        mixinStandardHelpOptions = true)
public class Game implements Runnable{

    @Parameters
    private String action;

    @Override
    public void run(){

        System.out.println("Welcome to Tamagotchi Pet Simulator!\n");
        //if there is a file, read it. If there isn't, proceed.
        File f = new File();
        if(f.exists() && !f.isDirectory()) {

        } else if (action == null){
            createNewPet();
        }

        //select which pet you want to play with
        }
    }

    public static void main(String[] args){
        int exitCode = new CommandLine(new Game()).execute(args);

        System.exit(exitCode);
    }

    public Pet createNewPet(){

        Scanner input = new Scanner(System.in);

        System.out.println("What kind of pet would you like to have?\n");
        String selectedPet = input.nextLine();

        System.out.println("What is the name of your" + selectedPet + "?\n");
        String name = input.nextLine();

        switch(selectedPet){
        case "dog":
            return new Dog(name);
        case "cat":
            return new Cat(name);
        }

    }
}
 */