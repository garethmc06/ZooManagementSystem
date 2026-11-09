public class Fish extends Animal implements Swimmable{
    String waterType;
    public Fish(String name, int age, String colour, double weight, String waterType){
        super(name, age, colour, weight);
        this.waterType = waterType;
    }
    @Override
    public String swimCheck(){
        return name + " can Swim well!";
    };

    @Override
    public String depthCheck(){
        return name + " can Swim at different depths";
    }
    @Override
    public String makeSound(){
        return "Glug! Glug! I am " + name + ", a " + age + " years old Fish! I swim in " + waterType + "water!";
    }
}
