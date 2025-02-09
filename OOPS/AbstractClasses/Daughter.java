package OOPS.AbstractClasses;

class Daughter extends Parent {
    
    Daughter(String name, int age) {
        super(name, age);
    }

    @Override
    void career() {
        System.out.println(name + " wants to be a Doctor.");
    }

    @Override
    void partner() {
        System.out.println(name + " wants a supportive partner.");
    }
}
