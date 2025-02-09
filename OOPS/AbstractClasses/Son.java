package OOPS.AbstractClasses;

class Son extends Parent {
    
    Son(String name, int age) {
        super(name, age);
    }

    @Override
    void career() {
        System.out.println(name + " wants to be an Engineer.");
    }

    @Override
    void partner() {
        System.out.println(name + " wants a caring partner.");
    }
}
