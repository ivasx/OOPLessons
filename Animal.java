public class Animal {

    protected String name;
    protected kindAnimal kind;
    protected int age;
    protected double weight;
    protected int hungerLevel;
    protected String location;

    public Animal(String name, kindAnimal kind, int age, double weight, int hungerLevel, String location) {
        this.name = name;
        this.kind = kind;
        this.age = age;
        this.weight = weight;
        this.hungerLevel = hungerLevel;
        this.location = location;
    }


    public void makeSound(){
        System.out.println(name + "видала звук.");
    }

    public void feeding(){}

    public void moves(){
        System.out.println("Тварина рухається.");
    }

    public String returnInfo(){
        return "Назва           : " + name + "/n" +
               "Вид             : " + kind + "/n" +
               "Вік             : " + age + "/n" +
               "Вага            : " + weight + "/n" +
               "Голод           : " + weight + "/n" +
               "Місцезнаходження: " + weight + "/n";
    }

}
