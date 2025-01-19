package Polymorphism;

public class Polymorphism {
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Circle circle = new Circle();
        Triangle triangle = new Triangle();
        shape.area();
        circle.area();
        triangle.area();

        // this will call circle's area function
        Shapes circleShape = new Circle();
        circleShape.area();
    }
}
