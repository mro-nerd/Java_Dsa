public class abstractClass{
    public static void main(String[] args) {
        Horse h1 =new Horse();
        h1.eat();
        h1.walk();
        Chicken c1 =new Chicken();
        c1.eat();
        c1.walk();
        

    }
}
abstract class Animal{
    String color;
    Animal()//abstract class cant have obj ,but they can have constructor for intialising anything,also since its constructor of base class so it will be called first
    {
        color="white";
       System.out.println("color is white");
    }
    void eat(){
        System.out.println("animal eats");

    }

    abstract void walk();//abstract fn giving idea but not implimentation
}

class Horse extends Animal{
    void walk(){
        System.out.println("walks on 4 legs");
    }
    void changeColor(){
        color="dark brown";
        System.out.println("color is white");
    }
}
class Chicken extends Animal{
void walk(){
    System.out.println("walks on 2 legs");
}
void changeColor(){
    color="red";
    System.out.println("color is white"); }
}
