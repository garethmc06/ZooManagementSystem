import java.sql.SQLOutput;

public class Animal {


    // Animal  class Instance Variables
    public String name;
    public int age;
    public String color;
    public double weight;

    // Constructor for Animal Class
    public Animal(String name, int age, String color, double weight) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;

    }

    // Simply Displays Animals in Animal Array
    public void DisplayAnimal(){
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Color: " + this.color);
        System.out.println("Weight: " + this.weight);
    }

    public String makeSound(){
        return "sound ... I am" + name + ", a" + age + " year old animal";
    }

}
