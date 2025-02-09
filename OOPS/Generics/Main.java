package OOPS.Generics;


public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.printList();
        
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Size of list: " + list.size());


        CustomArrayList<String> list1 = new CustomArrayList<>();
        list1.add("hello");
        list1.add("hello");
        list1.add("baby");
        list1.add("nee");
        list1.printList();

        NumberArrayList<Integer> intList = new NumberArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        intList.printList();

        NumberArrayList<Double> doubleList = new NumberArrayList<>();
        doubleList.add(5.5);
        doubleList.add(7.7);
        doubleList.add(9.9);
        doubleList.printList();

        // Using wildcard method
        NumberArrayList.printNumbers(intList);
        NumberArrayList.printNumbers(doubleList);
    }
}
