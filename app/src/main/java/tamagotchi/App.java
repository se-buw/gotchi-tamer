// our program starts here

package tamagotchi;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.IOException;
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
        System.out.println("What is the name of your " + selectedPet + "?");
        String name = input.nextLine();
        System.out.println("Which secks should your " + selectedPet + " have?");
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
        if (selectedPet.equals("elemental")){
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
    public static void startGame(Pet pet){
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
                    for (String food: pet.food) {
                        System.out.print(food +"\t");
                    }
                    System.out.println(" back");
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
                    System.out.println("What do you want to clean for " + pet.get_name() + "?");
                    System.out.println("bath \t toilet \t grooming \t back");
                    input = sr.nextLine().toLowerCase();
                    back = false;
                    do {
                        switch (input) {
                            case "bath" -> {
                                pet.clean("bath");
                                back = true;
                                pet.getInformation();
                                displayChoices();
                            }
                            case "toilet" -> {
                                pet.clean("toilet");
                                back = true;
                                pet.getInformation();
                                displayChoices();
                            }
                            case "grooming" -> {
                                pet.clean("grooming");
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
                                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                                System.out.println("Thawt iws nowt a vawid command!");
                                System.out.println("Please select from the listed clean activities above!");
                                input = sr.nextLine().toLowerCase();
                            }
                        }
                    } while (!back);
                }
                case "play" -> {
                    System.out.println("What do you want to play with " + pet.get_name() + "?");
                    for (String toy : pet.toy){
                        System.out.print(toy +"\t");
                    }
                    System.out.println(" back");
                    input = sr.nextLine().toLowerCase();
                    do{
                    for (String toy: pet.toy) {
                        if (input.equals(toy)) {
                            pet.play(toy);
                            back = true;
                        } else if (input.equals("back")) {
                            back = true;
                        } else {
                            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                            System.out.println("Thawt iws nowt a vawid command!");
                            System.out.println("Pwease sewect fwom the wisted toys above!");
                            input = sr.nextLine().toLowerCase();
                        }
                    }
                    pet.getInformation();
                    displayChoices();
                    } while (!back);
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
        Pet none = new Elemental();
        if (attributes.length == 0){
            return none;
        }
        Pet pet = new Elemental();
        long timePast = Duration.between(LocalDateTime.parse(attributes[9]), LocalDateTime.now()).toHours();
        int i = (int)timePast;
        if (attributes[0].equals("elemental")){
			pet = new Elemental(attributes[0], attributes[1], attributes[2],
					Integer.parseInt(attributes[3])-i, Integer.parseInt(attributes[4])-i,
					Integer.parseInt(attributes[5])-i, attributes[6], attributes[7], attributes[8], attributes[9]);
		}
		if (attributes[0].equals("dragon")){
			pet = new Dragon(attributes[0], attributes[1], attributes[2],
					Integer.parseInt(attributes[3])-i, Integer.parseInt(attributes[4])-i,
					Integer.parseInt(attributes[5])-i, attributes[6], attributes[7], attributes[8], attributes[9]);
		}
        if((pet.hunger_ + pet.attention_ + pet.hygiene_ ) == 0){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(pet.name_ + " died!");
            System.out.println(pet.name_ + " R.I.P");
            System.out.println("You are a terrible owner!!");
            System.out.println(" :( \t :( \t :( \t :( \t :( \t :( \t :( ");
            return none;
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
        boolean quit = false;
        do {
            System.out.println("**********************************************************************");
            System.out.println("If you played this game before and want to continue, please write load");
            System.out.println("If you want to create a new tamagotchi game, please write create");
            System.out.println("Choices: load \t create \t quit");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine().toLowerCase();
            switch (command) {
                case "create" -> {
                    String petName = startNewGame();
                    Pet pet = loadGame(petName);
                    if (pet.get_name().equals("None")) {
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        System.out.println("Something went wrong! Please try again!");
                    } else {
                        startGame(pet);
                        quit = true;
                    }
                    break;
                }
                case "load" -> {
                    System.out.println("What is the name of the pet you want to interact with?");
                    command = scanner.nextLine().toLowerCase();
                    Pet pet = loadGame(command);
                    if (pet.get_name().equals("None")) {
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    } else {
                        startGame(pet);
                        quit = true;
                    }
                    break;
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

