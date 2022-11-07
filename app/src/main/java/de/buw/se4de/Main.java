package de.buw.se4de;
import java.util.Scanner;
import java.io.IOException;


public class Main {
    public static void game(Dog dog, FileOrganizer file){
        boolean close = false;
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (!close) {
            System.out.println("What would you like to do next?");
            command = scanner.nextLine();
            if (command.toUpperCase().equals("SAVE")) {
                file.write_file(dog);
            }
            if (command.toUpperCase().equals("READ")) {
                file.read_file();
            }
            if (command.toUpperCase().equals("CLOSE")) {
                close = true;
            }
            if (command.toUpperCase().equals("FEED")) {
                dog.feed(dog);
            }
            if (command.toUpperCase().equals("CLEAN")) {
                dog.clean(dog);
            }
            if (command.toUpperCase().equals("PLAY")) {
                dog.play(dog);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Tamagotchi.");
        System.out.println("If you want to load your tamagotchi type: load");
        System.out.println("If you want to create a new tamagotchi type: create");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        if (command.toUpperCase().equals("CREATE")) {
            System.out.println("For now you can create a dog");
            System.out.println("What is the name of your dog?");
            String name = scanner.nextLine();
            System.out.println("Which gender should your dog have?");
            System.out.println("You can choose between Male and Female.");
            String sex = scanner.nextLine();
            while (!sex.toUpperCase().equals("MALE") && !sex.toUpperCase().equals("FEMALE")) {
                System.out.println("Please write Male or Female.");
                sex = scanner.nextLine();
            }
            Dog myDog = new Dog(name, sex);
            System.out.println(myDog.get_name());
            String fav_food = myDog.random_fav_food();
            String fav_toy = myDog.random_fav_toy();
            System.out.println("Your dogs favourite food is: " + fav_food);
            System.out.println("Your dogs favourite toy is: " + fav_toy);
            myDog = new Dog(name, sex, 10, 10, 10, fav_food, fav_toy);
            FileOrganizer file = new FileOrganizer();
            file.create_file();
            game(myDog, file);
        }
        if (command.toUpperCase().equals("LOAD")) {
            FileOrganizer file = new FileOrganizer();
            String attributes[] = file.load_file();
            Dog myDog = new Dog(attributes[0], attributes[1], Integer.parseInt(attributes[2]), Integer.parseInt(attributes[3]), Integer.parseInt(attributes[4]), attributes[5], attributes[6]);
            if((myDog.hunger_ + myDog.attention_ + myDog.hygiene_ ) == 0){
                System.out.println(myDog.name_ + "died!");
            }
            game(myDog, file);
        }
    }
}
