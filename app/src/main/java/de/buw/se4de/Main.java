package de.buw.se4de;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean close = false;
        System.out.println("Welcome to tamagotchi \n For now you can create a dog \n");
        System.out.println("What is the name of your dog?");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Which gender should your dog have?");
        System.out.println("You can choose between Male and Female.");
        Scanner s = new Scanner(System.in);
        String sex = s.nextLine();
        while(!sex.equals("Male") && !sex.equals("Female")){
            System.out.println("Please write Male or Female.");
            sex = sc.nextLine();
        }
        while (!close){
            FileOrganizer file;
        }

    }
}
