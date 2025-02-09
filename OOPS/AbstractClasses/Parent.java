package OOPS.AbstractClasses;

abstract class Parent {
    String name;
    int age;

    Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Abstract methods must have a return type (void in this case)
    abstract void career();
    abstract void partner();
}
