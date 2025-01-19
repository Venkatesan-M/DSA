package Inheritance;

public class Box {
    double l;
    double b;
    double h;

    Box(double l, double b, double h){
        this.l = l; this.b = b; this.h = h;
    }

    Box(double a){
        this.l = a; this.b = a; this.h = a;
    }

    Box(Box bx){
        this.l = bx.l; this.b = bx.b; this.h = bx.h;
    }

    public void dimension(){
        System.out.println("["+this.l + ", "+ this.b + ", "+ this.h +"]");
    }
}