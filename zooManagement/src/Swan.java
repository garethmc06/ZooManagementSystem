public class Swan extends Animal implements Flyable, Swimmable{
    double wingSpan;
    public Swan(String name, int age, String color, double weight, double wingSpan){
        super(name, age, color, weight);
        this.wingSpan = wingSpan;
    }
    @Override
    public String wingCheck(){
        return name + "'s Wings are in Good Health";
    };
    @Override
    public String talonCheck(){
        return name + "'s Talons are in Good Health";
    };
    @Override
    public String swimCheck(){
        return name + " can Swim well!";
    };

    @Override
    public String depthCheck(){
        return name + " cannot swim at different depths";
    }

    @Override
    public String makeSound(){
        return "Glock! Glock! I am " + name + ", a " + age + "years old Swan with a wingspan of " + wingSpan + " metres!";
    }
}
