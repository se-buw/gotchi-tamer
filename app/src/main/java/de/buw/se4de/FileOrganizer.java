package de.buw.se4de;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class FileOrganizer {
    public void create_file(){
        try {
            //File myObj = new File("tamagotchi.txt");
            File myObj = new File("C:\\Users\\danie\\Desktop\\tamagotchi.txt");

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
    }

    public void read_file(){
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
    }

    public void write_file(Dog dog){
        try {
            //FileWriter myWriter = new FileWriter("tamagotchi.txt");
            FileWriter myWriter = new FileWriter("C:\\Users\\danie\\Desktop\\tamagotchi.txt");
            myWriter.write(dog.get_name() + "\n");
            myWriter.write(dog.get_sex() + "\n");
            myWriter.write(dog.get_hunger() + "\n");
            myWriter.write(dog.get_hygiene() + "\n");
            myWriter.write(dog.get_attention() + "\n");
            myWriter.write(dog.get_fav_food() + "\n");
            myWriter.write(dog.get_fav_toy() + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String[] load_file() throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\danie\\Desktop\\tamagotchi.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }
}
