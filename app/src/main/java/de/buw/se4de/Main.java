package de.buw.se4de;
import java.util.Scanner;
import java.io.IOException;


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
        // Todo: code that read the file pet and make it here
        if (pet.get_name().equals("None")){
            System.out.println("Please start again!");
        }else {
            pet.getInformation();
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
                    case "close" -> close = true;
                    default -> System.out.println("That is not a valid command!");
                }
            } while (!close);
        }
    }

    public static Pet loadGame(String name) throws IOException{
        FileOrganizer file = new FileOrganizer();
        String[] attributes = file.load_file(name);
        if (attributes.length == 0){

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
        System.out.println("If you played this game before and want to continue choose: load");
        System.out.println("If you want to create a new tamagotchi type: create");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine().toLowerCase();
        if (command.equals("create")){
            String petName = startNewGame();

            startGame(loadGame(petName));
        }
        else if (command.equals("load")){
            System.out.println("What is the name of the pet you want interact with?");
            command = scanner.nextLine().toLowerCase();
            startGame(loadGame(command));
        }

    }
}
