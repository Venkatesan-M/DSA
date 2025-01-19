package OOPS.Classes;

public class Human {
    int age;
    String name;
    boolean married;
    char gender;
    static long population;

    static {
        // you can initialize static variables in static block only
        // this will run excalty once when the class is loaded,.
        population  = 100000;
    }

    public Human(int age, String name, char gender, boolean married){
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.married = married;
        Human.population += 1;
    }

    // inner class can be static
    // eye class is depended on human if it was not defined as static
    // meaning you can't create a class instance without creating the human class if it was not static
    static class eye{
        static boolean rightEye;
        static boolean leftEye;
        boolean blind;

        static {
            rightEye = true; leftEye = true;
        }
    }
}
