package Polymorphism;

public class Circle extends Shapes {
    Circle(){
        super();
    }
    
    // static methoeds can't be overrided, they are depended on class not objects
    // overriding happens only with objects
    // @Override
    // void discription(){

    // }

    @Override
    void area() {
        System.out.println("I'm area of Circle");
    }
}
