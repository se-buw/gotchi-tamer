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