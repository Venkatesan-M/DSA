package Inheritance;


public class Inheritance{
    public static void main(String[] args) {
        Box bx1 = new Box(1, 2, 3);
        bx1.dimension();

        Box bx2 = new Box(5);
        bx2.dimension();

        Box bx = new Box(bx1);
        bx.dimension();

        Weightedbox wbx = new Weightedbox(1, 2, 3, 4);
        wbx.dimension();

        // type of the reference variable will determine the actual instance of the class that will be created 
        Box bxonly = new Weightedbox(2, 4, 6, 7);
        bxonly.dimension();
        // System.out.println(bxonly.weight);
    }
}