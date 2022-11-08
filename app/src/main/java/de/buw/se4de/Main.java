package de.buw.se4de;
import java.util.Scanner;
import java.io.IOException;


public class Main {
    public static void startNewGame(){
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
            file.create_file();
            file.write_file(pet);
        }
    }
    public static void startGame(Pet pet){
        // Todo: code that read the file pet and make it here
        Scanner sr = new Scanner(System.in);
        FileOrganizer file = new FileOrganizer();
        boolean close = false;
        do {
            String input = sr.nextLine().toLowerCase();
            displayStats();
            displayChoices();
            switch (input) {
                case "feed": pet.feed(); break;
                case "clean": pet.clean(); break;
                case "play": pet.play(); break;
                case "save": file.write_file(pet); break;
                case "close": close = true; break;
                default:
                    System.out.println("That is not a valid command!");
            }
        }while(!close);
    }

    public static Pet loadGame() throws IOException{
        FileOrganizer file = new FileOrganizer();
        String attributes[] = file.load_file();
        Pet pet = new Dog(attributes[0], attributes[1], Integer.parseInt(attributes[2]), Integer.parseInt(attributes[3]), Integer.parseInt(attributes[4]), attributes[5], attributes[6]);
        if((pet.hunger_ + pet.attention_ + pet.hygiene_ ) == 0){
            System.out.println(pet.name_ + " died!");
        }
        return pet;
    }
    // Todo
    public static void displayChoices(){

    }

    public static void displayStats(){

    }

    public static void main(String[] args) throws IOException {
        System.out.println("If you want to load your tamagotchi type: load");
        System.out.println("If you want to create a new tamagotchi type: create");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine().toLowerCase();
        if (command.equals("create")){
            startNewGame();
            startGame(loadGame());
        }
        else if (command.equals("load")){
            startGame(loadGame());
        }

    }
}
