package Polymorphism;

public class Triangle extends Shapes {
    Triangle(){
        super();
    }

    @Override
    void area() {
        System.out.println("I'm area of Triangle");
    }
}
