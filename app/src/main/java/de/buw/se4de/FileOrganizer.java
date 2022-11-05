package de.buw.se4de;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
public class FileOrganizer {
    public void file_create(){}
    public void einlesen(){}
    public void schreiben(){}
    public void save(){}

}
/*

    try {
        File myObj = new File("tamagotchi.txt");
        //File myObj = new File("C:\\Users\\danie\\Desktop\\tamagotchi.txt");

        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }
    } catch (
    IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

    Dog myDog = new Dog();
    myDog.name = myDog.give_name();
    myDog.sex = myDog.give_sex();
    myDog.fav_food = myDog.get_favourite_food();
    myDog.fav_toy = myDog.get_favourite_toy();
        System.out.println("What to do next?");
    Scanner sc = new Scanner(System.in);
    String next = sc.nextLine();
        if(next.equals("save")){
        try {
            //FileWriter myWriter = new FileWriter("tamagotchi.txt");
            FileWriter myWriter = new FileWriter("C:\\Users\\danie\\Desktop\\tamagotchi.txt");
            myWriter.write("Name " + myDog.name + "\n");
            myWriter.write("Sex " + myDog.sex + "\n");
            myWriter.write("FavFood " + myDog.fav_food + "\n");
            myWriter.write("FavToy " + myDog.fav_toy + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

        try {
        File myObj = new File("C:\\Users\\danie\\Desktop\\tamagotchi.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
*/