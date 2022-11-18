package tamagotchi;

import java.time.Duration;
import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDateTime;

public class Game {
    public static String startNewGame(){
        String[] pets = {"dog", "cat"};
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Welcome to Tamagotchi.");
        System.out.println("What pet do you choose?");

        Scanner input = new Scanner(System.in);
        String selectedPet = input.nextLine();

        while (!selectedPet.equals(pets[0]) && !selectedPet.equals(pets[1])){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("You can only choose from the listed pets above!");
            selectedPet = input.nextLine().toLowerCase();
        }
        System.out.println("What is the name of your " + selectedPet + "?");
        String name = input.nextLine();
        System.out.println("Which gender should your " + selectedPet + " have?");
        System.out.println("You can choose between male and female.");
        String sex = input.nextLine().toLowerCase();
        while(!sex.equals("male") && !sex.equals("female")){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Please write male or female.");
            sex = input.nextLine().toLowerCase();
        }

        if (selectedPet.equals("dog")){
            Pet pet = new Dog("dog",name, sex);
            FileOrganizer file = new FileOrganizer();
            file.create_file(pet);
            file.write_file(pet);
        }
		else if (selectedPet.equals("cat")){
			Pet pet = new Cat("cat", name, sex);
			FileOrganizer file = new FileOrganizer();
			file.create_file(pet);
			file.write_file(pet);
		}
        return name;
    }
    public static void startGame(Pet pet){
        pet.printInfo();
        displayChoices();
        Scanner sr = new Scanner(System.in);
        FileOrganizer file = new FileOrganizer();
        boolean close = false;
        do {
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
                                pet.feed(new Apple());
                                back = true;
                                pet.printInfo();
                                displayChoices();
                            }
                            case "bread" -> {
                                pet.feed(new Bread());
                                back = true;
                                pet.printInfo();
                                displayChoices();
                            }
                            case "steak" -> {
                                pet.feed(new Steak());
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
                                pet.clean("bath");
                                back = true;
                                pet.printInfo();
                                displayChoices();
                            }
                            case "toilet" -> {
                                pet.clean("toilet");
                                back = true;
                                pet.printInfo();
                                displayChoices();
                            }
                            case "grooming" -> {
                                pet.clean("grooming");
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
                                pet.play("ball");
                                back = true;
                                pet.printInfo();
                                displayChoices();
                            }
                            case "stick" -> {
                                pet.play("stick");
                                back = true;
                                pet.printInfo();
                                displayChoices();
                            }
                            case "yarn" -> {
                                pet.play("yarn");
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
                    file.write_file(pet);
                    pet.printInfo();
                    displayChoices();
                }
                case "close" -> {
                    file.write_file(pet);
                    close = true;
                }
                default -> {
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    System.out.println("That is not a valid command!");
                }
            }
        } while (!close);
    }


    public static Pet loadGame(String name) throws IOException{
        FileOrganizer file = new FileOrganizer();
        String[] attributes = file.load_file(name);
        Pet none = new Dog();
        if (attributes.length == 0){
            return none;
        }
        Pet pet = new Dog();
        long timePast = Duration.between(LocalDateTime.parse(attributes[9]), LocalDateTime.now()).toHours();
        int i = (int)timePast;
        if (attributes[0].equals("dog")){
			pet = new Dog(attributes[0], attributes[1], attributes[2],
					Integer.parseInt(attributes[3])-i, Integer.parseInt(attributes[4])-i,
					Integer.parseInt(attributes[5])-i, attributes[6], attributes[7], attributes[8], attributes[9]);
		}
		if (attributes[0].equals("cat")){
			pet = new Cat(attributes[0], attributes[1], attributes[2],
					Integer.parseInt(attributes[3])-i, Integer.parseInt(attributes[4])-i,
					Integer.parseInt(attributes[5])-i, attributes[6], attributes[7], attributes[8], attributes[9]);
		}
        if((pet.hunger + pet.attention + pet.hygiene) == 0){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(pet.name + " died!");
            System.out.println(pet.name + " R.I.P");
            System.out.println("You are a terrible owner!!");
            System.out.println(" :( \t :( \t :( \t :( \t :( \t :( \t :( ");
            return none;
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
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    System.out.println("Something went wrong! Please try again!");
                } else {
                    startGame(pet);
                    quit = true;
                }
            } else if (command.equals("load")) {
                System.out.println("What is the name of the pet you want to interact with?");
                command = scanner.nextLine().toLowerCase();
                Pet pet = loadGame(command);
                if (pet.get_name().equals("None")) {
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

}

