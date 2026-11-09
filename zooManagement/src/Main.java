import java.io.*;
import java.util.ArrayList; // All Imports Used For This Project
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Animal> animals = new ArrayList<>();

        // Load zoo details
        try {
            BufferedReader zooReader = new BufferedReader(new FileReader("ZooDetails.txt"));
            String line;

            while ((line = zooReader.readLine()) != null) {
                System.out.println(line);
            }

            zooReader.close();

        } catch (IOException e) {
            System.out.println("No previous zoo details found.");
        }

        // Load animal details
        try {
            BufferedReader animalReader = new BufferedReader(new FileReader("AnimalDetails.txt"));
            String line;

            while ((line = animalReader.readLine()) != null) {
                String[] data = line.split(","); // Seperates all data by commas

                String type = data[0]; // Assigns Data within the animal details file to their set variables
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String color = data[3];
                double weight = Double.parseDouble(data[4]);

                if (type.equalsIgnoreCase("Eagle")) {               // If statement is used so that
                    double wingSpan = Double.parseDouble(data[5]);          // due to different types of animals
                    animals.add(new Eagle(name, age, color, weight, wingSpan));// it sets their type to the data variable 5
                } else if (type.equalsIgnoreCase("Swan")) {         // if it matches the if statement conditions
                    double wingSpan = Double.parseDouble(data[5]);
                    animals.add(new Swan(name, age, color, weight, wingSpan));

                } else if (type.equalsIgnoreCase("Fish")) {
                    String waterType = data[5];
                    animals.add(new Fish(name, age, color, weight, waterType));
                }
            }

            animalReader.close();
            System.out.println("Animal details loaded from file.");

        } catch (IOException e) {
            System.out.println("No previous animal details found.");  // Validation in case no details for animals were found in the animals file
        }

        boolean running = true; // This is to repeat the functional code until the user decides to quit using the 7 key

        while (running) { // This is the Main interface where all actions can be formed
            System.out.println("Add (1) || Display Report (2) || Edit (3) || Delete (4) || Daily Care (5) || Display Animals (6) || Search Animals (7) || Quit (8)");
            int userChoice = scan.nextInt();
            scan.nextLine();

            if (userChoice == 1) {  // Adding Sections (1)

                System.out.println("Which Type of Animal? (Eagle, Swan, Fish)");
                String type = scan.nextLine();

                if (!type.equalsIgnoreCase("Eagle") &&
                        !type.equalsIgnoreCase("Swan") &&    // This validation ensures that none other of theses 3
                        !type.equalsIgnoreCase("Fish")) {    // types of animals are added to the system

                    System.out.println("Unknown animal type. Animal will not be saved."); // error message

                } else {  // User input Screen for adding an animal
                    System.out.println("Name: ");
                    String name = scan.nextLine();  //Scanner is used for each input

                    System.out.println("Age: ");
                    int age = scan.nextInt(); //<---
                    scan.nextLine();

                    System.out.println("Color (Brown, White, Blue): ");
                    String color = scan.nextLine(); // <----

                    System.out.println("Weight: ");
                    double weight = scan.nextDouble(); //<---
                    scan.nextLine(); // This code is used to ensure it runs correctly

                    if (name.equals("") || age <= 0 || color.equals("") || weight <= 0) {
                        System.out.println("Not all details entered so animal will not be saved");

                    } else if (type.equalsIgnoreCase("Eagle")) {
                        System.out.println("WingSpan: ");
                        double wingSpan = scan.nextDouble();   // User Input for Unique Characteristics for each animmal
                        scan.nextLine();

                        animals.add(new Eagle(name, age, color, weight, wingSpan));
                        System.out.println("Eagle Saved!");

                    } else if (type.equalsIgnoreCase("Swan")) {
                        System.out.println("WingSpan: ");
                        double wingSpan = scan.nextDouble();
                        scan.nextLine();

                        animals.add(new Swan(name, age, color, weight, wingSpan));
                        System.out.println("Swan Saved!");

                    } else if (type.equalsIgnoreCase("Fish")) {
                        System.out.println("Water Type: ");
                        String waterType = scan.nextLine();

                        animals.add(new Fish(name, age, color, weight, waterType));
                        System.out.println("Fish Saved!");
                    }
                }

            } else if (userChoice == 2) {
                System.out.println("ZooTopic Report");// Report Section for the Zoo
                System.out.println("---------------");

                int flyCount = 0;
                int swimCount = 0;     //Variables For counting the different Types of Animals
                int swimFlyCount = 0;

                int eagleCount = 0;
                int swanCount = 0;
                int fishCount =0 ;

                String dominant;
                int brownCount = 0;
                int whiteCount = 0;         // Variables for counting the different colours of animals
                int blueCount = 0;
                int otherCount = 0;

                for (int i = 0; i < animals.size(); i++) {
                    Animal animal = animals.get(i);

                    if (animal instanceof Flyable && animal instanceof Swimmable) {
                        swimFlyCount++;
                    } else if (animal instanceof Flyable) {
                        flyCount++;                                         // Each of these increment their respective counts through the for loop
                    } else if (animal instanceof Swimmable) {
                        swimCount++;
                    }

                    if (animal.color.equalsIgnoreCase("brown")) {
                        brownCount++;
                    } else if (animal.color.equalsIgnoreCase("white")) {
                        whiteCount++;                                           // Same as above but for animal Colour
                    } else if (animal.color.equalsIgnoreCase("blue")) {
                        blueCount++;
                    } else {
                        otherCount++;
                    }

                    if(animal instanceof Eagle) {
                        eagleCount++;
                    }else if (animal instanceof Swan) {
                        swanCount++;
                    }else if(animal instanceof Fish) {
                        fishCount++;
                    }
                }
                int highest = brownCount;
                dominant = "Brown";

                if (whiteCount > highest) {
                    highest = whiteCount;
                    dominant = "White";
                }

                if (blueCount > highest) {
                    highest = blueCount;
                    dominant = "Blue";
                }

                if (otherCount > highest) {
                    dominant = "Other";
                }

                System.out.println("Flying Animals: " + flyCount);
                System.out.println("Swimming Animals: " + swimCount);
                System.out.println("Swimming and Flying Animals: " + swimFlyCount);
                System.out.println("Brown Animals: " + brownCount);                      // Displays the Results on the Report
                System.out.println("White Animals: " + whiteCount);
                System.out.println("Blue Animals: " + blueCount);
                System.out.println("Other Colour Animals: " + otherCount);
                System.out.println("Eagles: " + eagleCount);
                System.out.println("Swans: " + swanCount);
                System.out.println("Fish: " + fishCount);
                System.out.println("Dominant Colour: " + dominant);

            } else if (userChoice == 3) {           // Search Section of Report
                System.out.print("Enter Animal Name: ");
                String editName = scan.nextLine();       // Takes user input in the form of a Name

                boolean animalFound = false;

                for (int i = 0; i < animals.size(); i++) {
                    Animal animal = animals.get(i);

                    if (animal.name.equalsIgnoreCase(editName)) {
                        animalFound = true;

                        System.out.println("Enter New Animal Name: ");
                        animal.name = scan.nextLine();                  // Once Name is Found options appear for the user to edit all characterisitcs of that animal

                        System.out.println("Enter New Animal Age: ");
                        animal.age = scan.nextInt();
                        scan.nextLine();

                        System.out.println("Enter New Animal Color: ");
                        animal.color = scan.nextLine();

                        System.out.println("Enter New Animal Weight: ");
                        animal.weight = scan.nextDouble();
                        scan.nextLine();

                        System.out.println("Animal Updated!");
                        break;
                    }
                }

                if (!animalFound) {             // If the animal is not found the system indicates to the user it does not exist
                    System.out.println("Animal Not Found!");
                }

            } else if (userChoice == 4) {       // Deletion Section of the Interface
                System.out.println("To Delete All Animals enter (X)"); // Deleting all animals
                System.out.println("To Delete A Specific Animal enter their Name"); // Deleting specific animals
                String userDelete = scan.nextLine();

                if (userDelete.equalsIgnoreCase("X")) {
                    animals.clear();           // .clear is used to remove all instances of animals found in the animimal details file
                    System.out.println("Animals Deleted Successfully!");

                } else {
                    boolean animalFound = false;

                    for (int i = 0; i < animals.size(); i++) {   // For loop cycles through Animal data to locate specific Animal name for deletion
                        if (animals.get(i).name.equalsIgnoreCase(userDelete)) {
                            animals.remove(i);
                            animalFound = true;
                            System.out.println("Animal Deleted Successfully!");
                            break;
                        }
                    }

                    if (!animalFound) {
                        System.out.println("Animal Was not found!");
                    }
                }

            } else if (userChoice == 5) {  // Daily Care Section
                System.out.println("1: Perform a General Check");
                System.out.println("2: Perform a Specific Check");
                int careCheck = scan.nextInt();     // Takes in user input to decide what type of check is to be performed
                scan.nextLine();

                if (careCheck == 1) {
                    System.out.println("Perform Care Check For:");   // General Care Check Interface
                    System.out.println("1: Flying animals");
                    System.out.println("2: Swimming animals");
                    System.out.println("3: Swimming and Flying Animals");

                    int generalCheck = scan.nextInt();
                    scan.nextLine();

                    for (int i = 0; i < animals.size(); i++) {
                        Animal animal = animals.get(i);

                        if (generalCheck == 1 && animal instanceof Flyable) {
                            Flyable f = (Flyable) animal;
                            System.out.println(f.wingCheck());                          // Locates the Type of Each Animal
                            System.out.println(f.talonCheck());

                        } else if (generalCheck == 2 && animal instanceof Swimmable) {
                            Swimmable s = (Swimmable) animal;
                            System.out.println(s.depthCheck());
                            System.out.println(s.swimCheck());

                        } else if (generalCheck == 3 &&
                                animal instanceof Flyable &&
                                animal instanceof Swimmable) {

                            Flyable f = (Flyable) animal;
                            Swimmable s = (Swimmable) animal;

                            System.out.println(s.depthCheck());
                            System.out.println(s.swimCheck());
                            System.out.println(f.wingCheck());
                            System.out.println(f.talonCheck());
                        }
                    }

                } else if (careCheck == 2) {
                    System.out.println("Perform Care Check For:");         // Performs Care Check for specific animal

                    for (int i = 0; i < animals.size(); i++) {
                        System.out.println((i + 1) + ": " + animals.get(i).name);
                    }

                    int nameChoice = scan.nextInt();
                    scan.nextLine();

                    if (nameChoice >= 1 && nameChoice <= animals.size()) {
                        Animal animal = animals.get(nameChoice - 1);

                        System.out.println("Care Check for: " + animal.name);

                        if (animal instanceof Swimmable) {
                            Swimmable s = (Swimmable) animal;
                            System.out.println(s.depthCheck());     // Prints the Specific Animal Care to Console
                            System.out.println(s.swimCheck());
                        }

                        if (animal instanceof Flyable) {
                            Flyable f = (Flyable) animal;
                            System.out.println(f.wingCheck());
                            System.out.println(f.talonCheck());
                        }

                    } else {
                        System.out.println("Animal Not Found!");
                    }
                }

            } else if (userChoice == 6) {
                for (int i = 0; i < animals.size(); i++) {
                    System.out.println("Animal " + (i + 1) + ":");
                    animals.get(i).DisplayAnimal();                         // Displays all Animals
                    System.out.println(animals.get(i).makeSound());
                }

            }
             else if (userChoice == 7) { // Search section of interface
                System.out.print("Search (name or colour): ");
                String search = scan.nextLine();

                boolean found = false;

                for (int i = 0; i < animals.size(); i++) {
                    Animal a = animals.get(i);

                    if (a.name.equalsIgnoreCase(search) || a.color.equalsIgnoreCase(search)) {  // Allows user to search for Animals by either name or (||) colour
                        found = true;

                        System.out.println("Name: " + a.name);
                        System.out.println("Age: " + a.age);              // Displays results of Search
                        System.out.println("Color: " + a.color);
                        System.out.println("Weight: " + a.weight);

                        // THIS is what you want instead:
                        System.out.println(a.makeSound());

                        System.out.println("-------------------");
                    }
                }

                if (!found) {
                    System.out.println("No matching animal found.");
                }
            }
            else if (userChoice == 8) {  // Quit Section of User Interface
                try {
                    PrintWriter zooWriter = new PrintWriter(new FileWriter("ZooDetails.txt"));        // Uses Classes from java io import to export data to a text file
                    PrintWriter animalWriter = new PrintWriter(new FileWriter("AnimalDetails.txt"));

                    zooWriter.println("Zoo Name: ZooTopic");                        // This section is for Printing the Data about the zoo to the ZooDetails.txt files
                    zooWriter.println("Number of animals: " + animals.size());

                    for (int i = 0; i < animals.size(); i++) {
                        Animal animal = animals.get(i);

                        if (animal.name.length() > 0 &&
                                animal.color.length() > 0 &&
                                animal.age > 0 &&
                                animal.weight > 0) {

                            if (animal instanceof Eagle) {
                                Eagle e = (Eagle) animal;
                                animalWriter.println("Eagle," + e.name + "," + e.age + "," + e.color + "," + e.weight + "," + e.wingSpan);   // Prints to file seperated by commas

                            } else if (animal instanceof Swan) {
                                Swan s = (Swan) animal;
                                animalWriter.println("Swan," + s.name + "," + s.age + "," + s.color + "," + s.weight + "," + s.wingSpan);

                            } else if (animal instanceof Fish) {
                                Fish f = (Fish) animal;
                                animalWriter.println("Fish," + f.name + "," + f.age + "," + f.color + "," + f.weight + "," + f.waterType);
                            }
                        }
                    }

                    zooWriter.close();
                    animalWriter.close();

                    System.out.println("Zoo details saved to disk.");
                    System.out.println("Animal details saved to disk.");

                } catch (IOException e) {
                    System.out.println("Error saving files.");  // IO exception in case error occurs
                }

                System.out.println("Closing Program");
                running = false;

            } else {
                System.out.println("Invalid Option!");
            }
        }

        scan.close();
    }
}

