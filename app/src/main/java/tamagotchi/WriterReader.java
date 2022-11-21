package tamagotchi;

import java.io.*;

public class WriterReader {

    void write(Pet pet) throws IOException {

        FileOutputStream f = new FileOutputStream(pet.name + ".txt");
        ObjectOutputStream o = new ObjectOutputStream(f);

        // Write objects to file
        o.writeObject(pet);

        o.close();
        f.close();
    }

    Pet read(String nameOfPet, String[] args) throws IOException, ClassNotFoundException {

            FileInputStream fi = new FileInputStream(nameOfPet + ".txt");
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            Pet pet = (Pet) oi.readObject();

            oi.close();
            fi.close();

            return pet;
    }

}