package OOPS.Interfaces;

public class Main {
    public static void main(String[] args) {
        // Engine myCar = new Car(); // also correct
        Car myCar = new Car(); 
        myCar.start();
        myCar.changeGear(3);
        myCar.showGear();
        myCar.stop();
    }
}
