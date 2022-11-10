package de.buw.se4de;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class FileOrganizer {
    public void create_file(Pet pet){
        try {
            File myObj = new File(pet.get_name()+".txt");
            //File myObj = new File("C:\\Users\\danie\\Desktop\\tamagotchi.txt");

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already existed.");
            }
        } catch (
                IOException e) {
            System.out.println("An error occurred.");
            //e.printStackTrace();
        }
    }

    public void read_file(){
        try {
            File myObj = new File("tamagotchi.txt");
            //File myObj = new File("C:\\Users\\danie\\Desktop\\tamagotchi.txt");
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
    }

    public void write_file(Pet pet){
        try {
            FileWriter myWriter = new FileWriter(pet.get_name()+".txt");
            //FileWriter myWriter = new FileWriter("C:\\Users\\danie\\Desktop\\tamagotchi.txt");
            myWriter.write(pet.getType() +"\n");
            myWriter.write(pet.name_ + "\n");
            myWriter.write(pet.sex_ + "\n");
            myWriter.write(pet.hunger_ + "\n");
            myWriter.write(pet.hygiene_ + "\n");
            myWriter.write(pet.attention_ + "\n");
            myWriter.write(pet.getFavoriteFood() + "\n");
            myWriter.write(pet.getFavoriteToy() + "\n");
            myWriter.write(pet.getBirthDay() + "\n");
            myWriter.write(LocalDateTime.now() + "\n");
            myWriter.close();
            System.out.println("Successfully created a new pet.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            //e.printStackTrace();
        }
    }

    public String[] load_file(String name) throws IOException {
        try {
            FileReader fileReader = new FileReader(name+".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<String>();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
            return lines.toArray(new String[lines.size()]);
        } catch (IOException e) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Could not load a game!");
            System.out.println("Apparently the given name is not correct or you did not play this game before.");
            System.out.println("Please check your input or start a new game!");
            // e.printStackTrace();

        }
        String[] a = {} ;
        return a;
    }

}
