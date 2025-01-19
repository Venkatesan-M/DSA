package Polymorphism;

public class Shapes {
    Shapes(){

    }
    static void discription(){
        System.out.println("I'm describing shape");
    }

    // you can use final to prevent Overriding
    // like final void area()
    void area() {
        System.out.println("I'm area of shape");
    }
}
