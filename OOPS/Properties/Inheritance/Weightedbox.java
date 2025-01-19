package Inheritance;

public class Weightedbox extends Box {
    double weight;

    Weightedbox(){
        super(null);
    }

    Weightedbox(double l, double b, double h, double w){
        super(l, b, h); 
        this.weight = w;
    }

    public void dimension(){
        System.out.println("["+this.l + ", "+ this.b + ", "+ this.h +"]");
    }
}
