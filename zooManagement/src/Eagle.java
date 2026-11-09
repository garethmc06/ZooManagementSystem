public class Eagle extends Animal implements Flyable{


    double wingSpan;
    public Eagle(String name, int age, String color, double weight, double wingSpan) {
        super(name, age, color, weight);
        this.wingSpan = wingSpan;
    }
    public String wingCheck(){
        return name + "'s Wings are in Good Health";
    }
    public String talonCheck(){
        return name + "'s Talons are in Good Health";
    }

    @Override
    public String makeSound() {
        return "Caw! Caw! I am " + name + ", a " + age + " years old Eagle!";
    }

}
