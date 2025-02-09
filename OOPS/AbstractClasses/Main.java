package OOPS.AbstractClasses;

public class Main {
    public static void main(String[] args) {
        Parent son = new Son("Alex", 25);
        son.career();
        son.partner();

        System.out.println();

        Parent daughter = new Daughter("Sophia", 22);
        daughter.career();
        daughter.partner();
    }
}
