package OOPS.Classes;

public class classes{
    public static void main(String[] args) {
        // A obj = new A("ans");
        // System.out.println(obj);
        // Human venkatesan = new Human(19, "Venkatesan", 'M', false);
        // System.out.println(venkatesan.population); // not the convention
        Human krishna = new Human(30, "Krinsha", 'M', true);
        System.out.println(krishna.name);
        // Human.population += 100;
        System.out.println(Human.population);
    }
}

class A {
    final int num = 10;
    String name;

    public A(String name){
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destoryed");
    }

    // @Override
    //     public String toString(){
    //         return this.name;
    //     }
}