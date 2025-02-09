package OOPS.Cloning;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cloning clone = new Cloning("GCTA");
        Cloning twin = new Cloning(clone);
    
        System.out.println(twin.getDNA());
        Cloning betterTwin = (Cloning) clone.clone();
        System.out.println(betterTwin.getDNA().equals(twin.getDNA()));
    }
}
