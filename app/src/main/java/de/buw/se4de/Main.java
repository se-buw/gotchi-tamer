package de.buw.se4de;
import java.time.Duration;
import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static String startNewGame(){
        String[] pets = {"dog"};
        System.out.println("Welcome to Tamagotchi.");
        System.out.println("In Tamagotchi you can create your own digital pet. The rule is easy, keep your pet alive!");
        System.out.println("That means simply, you have to take care of your pet");
        System.out.println("First, choose what kind of pet you want:");
        // listing what kinds of pets are available
        for (String pet : pets){
            System.out.println(pet);
        }
        Scanner input = new Scanner(System.in);
        String selectedPet = input.nextLine();
        // Todo für gesamte Pets Array
        while (!selectedPet.equals(pets[0])){
            System.out.println("You can only choose from the listed pets above!");
            selectedPet = input.nextLine().toLowerCase();
        }
        System.out.println("What is the name of your " + selectedPet + "?");
        String name = input.nextLine();
        System.out.println("Which gender should your " + selectedPet + " have?");
        System.out.println("You can choose between male and female.");
        String sex = input.nextLine().toLowerCase();
        while(!sex.equals("male") && !sex.equals("female")){
            System.out.println("Please write male or female.");
            sex = input.nextLine().toLowerCase();
        }
        //Todo andere Tiere und Filename
        if (selectedPet.equals("dog")){
            Pet pet = new Dog(name, sex);
            FileOrganizer file = new FileOrganizer();
            file.create_file(pet);
            file.write_file(pet);
        }
        return name;
    }
    public static void startGame(Pet pet){
        pet.getInformation();
        displayChoices();
        Scanner sr = new Scanner(System.in);
        FileOrganizer file = new FileOrganizer();
        boolean close = false;
        do {
            // Age berechnen

            LocalDateTime timeNow = LocalDateTime.now();
            //long updatedAgeDays = Duration.between(timeNow, pet.getBirthDay()).toDays();
            //long updatedAgeHours = Duration.between(pet.getBirthDay(), timeNow).toHours();
            //long updatedAgeMinutes = Duration.between(pet.getBirthDay(), timeNow).toMinutes();
            //Time updatedAge = new Time(updatedAgeDays, updatedAgeHours, updatedAgeMinutes);
            //pet.setAge(updatedAge);

            String input = sr.nextLine().toLowerCase();
            boolean back = false;
            switch (input) {
                case "feed" -> {
                    System.out.println("What do you want to feed " + pet.get_name() + "?");
                    System.out.println("apple \t bread \t steak \t back");
                    input = sr.nextLine().toLowerCase();
                    do {
                        switch (input) {
                            case "apple" -> {
                                pet.feed();
                                back = true;
                                pet.getInformation();
                                displayChoices();
                            }
                            case "bread" -> {
                                pet.feed();
                                back = true;
                                pet.getInformation();
                                displayChoices();
                            }
                            case "steak" -> {
                                pet.feed();
                                back = true;
                                pet.getInformation();
                                displayChoices();
                            }
                            case "back" -> {
                                back = true;
                                pet.getInformation();
                                displayChoices();
                            }
                            default -> {
                                System.out.println("That is not a valid command!");
                                System.out.println("Please select from the listed food above!");
                                input = sr.nextLine().toLowerCase();
                            }
                        }
                    } while (!back);
                }
                case "clean" -> {
                    System.out.println("What do you want to clean for " + pet.get_name() + "?");
                    System.out.println("bath \t toilet \t grooming \t back");
                    input = sr.nextLine().toLowerCase();
                    back = false;
                    do {
                        switch (input) {
                            case "bath" -> {
                                pet.clean();
                                back = true;
                                pet.getInformation();
                                displayChoices();
                            }
                            case "toilet" -> {
                                pet.clean();
                                back = true;
                                pet.getInformation();
                                displayChoices();
                            }
                            case "grooming" -> {
                                pet.clean();
                                back = true;
                                pet.getInformation();
                                displayChoices();
                            }
                            case "back" -> {
                                back = true;
                                pet.getInformation();
                                displayChoices();
                            }
                            default -> {
                                System.out.println("That is not a valid command!");
                                System.out.println("Please select from the listed clean activities above!");
                                input = sr.nextLine().toLowerCase();
                            }
                        }
                    } while (!back);
                }
                case "play" -> {
                    System.out.println("What do you want to play with " + pet.get_name() + "?");
                    System.out.println("ball \t stick \t yarn \t back");
                    input = sr.nextLine().toLowerCase();
                    back = false;
                    do {
                        switch (input) {
                            case "ball" -> {
                                pet.play();
                                back = true;
                                pet.getInformation();
                                displayChoices();
                            }
                            case "stick" -> {
                                pet.play();
                                back = true;
                                pet.getInformation();
                                displayChoices();
                            }
                            case "yarn" -> {
                                pet.play();
                                back = true;
                                pet.getInformation();
                                displayChoices();
                            }
                            case "back" -> {
                                back = true;
                                pet.getInformation();
                                displayChoices();
                            }
                            default -> {
                                System.out.println("That is not a valid command!");
                                System.out.println("Please select from the listed toys above!");
                                input = sr.nextLine().toLowerCase();
                            }
                        }
                    } while (!back);
                }
                case "save" -> {
                    file.write_file(pet);
                    pet.getInformation();
                    displayChoices();
                }
                case "close" -> {
                    file.write_file(pet);
                    close = true;
                }
                default -> System.out.println("That is not a valid command!");
            }
        } while (!close);
    }


    public static Pet loadGame(String name) throws IOException{
        FileOrganizer file = new FileOrganizer();
        String[] attributes = file.load_file(name);
        if (attributes.length == 0){
            Pet none = new Dog();
            return none;
        }
        Pet pet = new Dog(attributes[0], attributes[1], Integer.parseInt(attributes[2]), Integer.parseInt(attributes[3]), Integer.parseInt(attributes[4]), attributes[5], attributes[6]);
        if((pet.hunger_ + pet.attention_ + pet.hygiene_ ) == 0){
            System.out.println(pet.name_ + " died!");
        }
        return pet;

    }
    // Todo
    public static void displayChoices(){
        System.out.println("Interactions with the pet:");
        System.out.println("feed \t clean \t play \t save \t close");
    }

    public static void displayStats(){

    }

    public static void main(String[] args) throws IOException {
        boolean quit = false;
        do {
            System.out.println("**********************************************************************");
            System.out.println("If you played this game before and want to continue, please write load");
            System.out.println("If you want to create a new tamagotchi game, please write create");
            System.out.println("Choices: load \t create \t quit");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine().toLowerCase();
            if (command.equals("create")) {
                String petName = startNewGame();
                Pet pet = loadGame(petName);
                if (pet.get_name().equals("None")) {
                    System.out.println("Something went wrong! Please try again!");
                } else {
                    startGame(pet);
                    quit = true;
                }
            } else if (command.equals("load")) {
                System.out.println("What is the name of the pet you want interact with?");
                command = scanner.nextLine().toLowerCase();
                Pet pet = loadGame(command);
                if (pet.get_name().equals("None")) {
                    System.out.println("**** In this case please write create! ****");
                } else {
                    startGame(pet);
                    quit = true;
                }
            }
            else if(command.equals("quit")) {
                quit = true;
            }
            else {
                System.out.println("That is not a valid choice!");
            }
        }while (!quit);
    }

}
