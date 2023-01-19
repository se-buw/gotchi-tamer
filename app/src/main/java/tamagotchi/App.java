// our program starts here

package tamagotchi;
import java.io.*;
import java.time.Duration;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.Random;

public class App {
    public static String startNewGame(){
        String[] pets = {"elemental", "dragon"};
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Wewcome tuwu tamagotchi.");
        System.out.println("In tamagotchi uwu cawn cweate youw own digitaw pet. The wuwe iws easy, keep youw pet awive!");
        System.out.println("Thawt means simpwy, uwu have tuwu take cawe of youw pet.");
        System.out.println("Fiwst, choose whawt kind of pet uwu wawnt:");
        // listing what kinds of pets are available
        System.out.println("Uwu cawn choose between an ewementaw ow a dwagon!");
        Scanner input = new Scanner(System.in);
        String selectedPet = input.nextLine();

        while (!selectedPet.equals(pets[0]) && !selectedPet.equals(pets[1])){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Uwu cawn onwy choose fwom the wisted pets above!");
            selectedPet = input.nextLine().toLowerCase();
        }
        //just renaming type for output
        if (selectedPet.equals("dragon")){
            selectedPet = "dwagon";
        }else {
            selectedPet = "ewementaw";
        }

        System.out.println("Whawt iws the nawme of youw " + selectedPet + "?");
        String name = input.nextLine();
        System.out.println("Which seggs shouwd youw " + selectedPet + " have?");
        System.out.println("UwU cawn choose between mawe awnd femawe ow a wandom secks.");
        String sex = input.nextLine().toLowerCase();

        while(!sex.equals("male") && !sex.equals("female") && !sex.equals("random")){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Pwease wwite mawe ow femawe ow wandom.");
            sex = input.nextLine().toLowerCase();
        }
        //
        if (sex.equals("random")){
            Random r = new Random();
            int number = r.nextInt(100);
            if (number <50){
                sex = "male";
            }else {
                sex = "female";
            }
        }
        Pet pet;
        if (selectedPet.equals("ewementaw")){
            pet = new Elemental("elemental", name, sex);
        }
		else {
            pet = new Dragon("dragon", name, sex);
        }
        FileOrganizer file = new FileOrganizer();
        file.create_file(pet);
        file.write_file(pet);
        return name;
    }
    public static void death(Pet pet){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(pet.name_ + " died!");
        System.out.println("R.I.P "+pet.name_);
        System.out.println("Uwu awe a tewwibwe ownew!!");
        System.out.println("(◞‸◟) (◞‸◟)");
        pet.dead = true;
    }
    public static void startGame(Pet pet){
        if (pet.check_death()){
            death(pet);
            return;
        }
        if (pet.sleeping){
            System.out.println(pet.name_+" has woken up and came to gweet you. UwU");
            pet.sleeping = false;
        }
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
                    System.out.println("Whawt duwu uwu wawnt tuwu feed" + pet.get_name() + "?");
                    for (String food: pet.food) {
                        System.out.print(food +"\t");
                    }
                    System.out.println(" bawck");
                    input = sr.nextLine().toLowerCase();
                    do{
                    for (String food : pet.food) {
                        if (input.equals(food)) {
                            pet.feed(food);
                            back = true;
                        } else if (input.equals("back")) {
                            back = true;
                        } else {
                            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                            System.out.println("Thawt iws nowt a vawid command!");
                            System.out.println("Pwease sewect fwom the wisted food above!");
                            input = sr.nextLine().toLowerCase();
                        }
                    }
                    pet.getInformation();
                    displayChoices();
                    } while (!back);
                }
                case "clean" -> {
                    System.out.println("Whawt duwu uwu wawnt tuwu cwean fow " + pet.get_name() + "?");
                    for (String cleaning : pet.cleaning){
                        System.out.print(cleaning + "\t");
                    }
                    System.out.println(" bawck");
                    input = sr.nextLine().toLowerCase();
                    do {
                    for (String cleaning : pet.cleaning){
                        if (input.equals(cleaning)){
                            pet.clean(cleaning);
                            back = true;
                            pet.getInformation();
                            displayChoices();
                        } else if (input.equals("back")){
                            back = true;
                            pet.getInformation();
                            displayChoices();
                        }else {
                            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                            System.out.println("Thawt iws nowt a vawid command!");
                            System.out.println("Pwease sewect fwom the wisted cwean activities above!");
                            input = sr.nextLine().toLowerCase();
                        }
                    }
                    } while (!back);
                }
                case "play" -> {
                    System.out.println("Whawt duwu uwu wawnt tuwu pway with " + pet.get_name() + "?");
                    for (String toy : pet.toy){
                        System.out.print(toy +"\t");
                    }
                    System.out.println(" bawck");
                    input = sr.nextLine().toLowerCase();
                    do{
                    for (String toy: pet.toy) {
                        if (input.equals(toy)) {
                            pet.play(toy);
                            back = true;
                            pet.getInformation();
                            displayChoices();
                        } else if (input.equals("back")) {
                            back = true;
                            pet.getInformation();
                            displayChoices();
                        } else {
                            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                            System.out.println("Thawt iws nowt a vawid command!");
                            System.out.println("Pwease sewect fwom the wisted toys above!");
                            input = sr.nextLine().toLowerCase();
                        }
                    }
                    } while (!back);
                }
                case "sleep" -> {
                    pet.sleeping = true;
                    System.out.println(pet.name_+" is now sweeping. ZZzzz");
                    file.write_file(pet);
                    close = true;
                }
                case "save" -> {
                    file.write_file(pet);
                    pet.getInformation();
                    displayChoices();
                }
                case "close" -> {
                    file.write_file(pet);
                    close = true;
                }
                default -> {
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    System.out.println("Thawt iws nowt a vawid command!");
                }
            }
        } while (!close);
    }

    public static Pet loadGame(String name) throws IOException{
        FileOrganizer file = new FileOrganizer();
        String[] attributes = file.load_file(name);
        Pet pet = new Elemental();
        long timePast = Duration.between(LocalDateTime.parse(attributes[9]), LocalDateTime.now()).toHours();
        float i = (float)timePast;

        if (attributes[0].equals("elemental") && attributes[10].equals("false")){
			pet = new Elemental(attributes[0], attributes[1], attributes[2],
					Float.parseFloat(attributes[3])-i, Float.parseFloat(attributes[4])-i,
					Float.parseFloat(attributes[5])-i, attributes[6], attributes[7], attributes[8], attributes[9]);
		}
        else if (attributes[0].equals("elemental")){
            pet = new Elemental(attributes[0], attributes[1], attributes[2],
                    Float.parseFloat(attributes[3])-i, Float.parseFloat(attributes[4]),
                    Float.parseFloat(attributes[5]), attributes[6], attributes[7], attributes[8], attributes[9]);
            pet.sleeping = true;
            System.out.println("sleepE");
        }
		else if (attributes[0].equals("dragon")&& attributes[10].equals("false")){
			pet = new Dragon(attributes[0], attributes[1], attributes[2],
					Float.parseFloat(attributes[3])-i, Float.parseFloat(attributes[4])-i,
					Float.parseFloat(attributes[5])-i, attributes[6], attributes[7], attributes[8], attributes[9]);
		}else if (attributes[0].equals("dragon")){
            pet = new Dragon(attributes[0], attributes[1], attributes[2],
                    Float.parseFloat(attributes[3])-i, Float.parseFloat(attributes[4]),
                    Float.parseFloat(attributes[5]), attributes[6], attributes[7], attributes[8], attributes[9]);
            pet.sleeping = true;
            System.out.println("sleep");
        }
        if(pet.check_death()){
            death(pet);
        }
        return pet;
    }
    public static void displayChoices(){
        System.out.println("W-what do i want tu do wif the pet uwu?");
        System.out.println("feed \t cwean \t pway \t sweep \t save \t cwose");
    }

    public static void main(String[] args) throws IOException {
        boolean quit = false;
        do {
            System.out.println("**********************************************************************");
            System.out.println("If uwu pwayed thiws gawme befowe awnd wawnt tuwu continue, pwease wite woad");
            System.out.println("If uwu wawnt tuwu cweate a new tamagotchi gawme, pwease wwite cweate");
            System.out.println("Choices: woad \t cweate \t quit");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine().toLowerCase();
            switch (command) {
                case "create" -> {
                    String petName = startNewGame();
                    Pet pet = loadGame(petName);
                    if (pet.get_name().equals("")) {
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        System.out.println("Something went wong!OwO pwease twy again =w=");
                    } else {
                        startGame(pet);
                        quit = true;
                    }
                }
                case "load" -> {
                    System.out.println("Whawt iws the nawme of the pet uwu wawnt tuwu intewact with?");
                    command = scanner.nextLine().toLowerCase();
                    Pet pet = loadGame(command);
                    if (pet.dead){quit=true;break;}
                    if (pet.get_name().equals("")) {
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    } else {
                        startGame(pet);
                        quit = true;
                    }
                }
                case "quit" -> quit = true;
                default -> {
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    System.out.println("That is not a valid choice!");
                }
            }
        }while (!quit);
    }
}

