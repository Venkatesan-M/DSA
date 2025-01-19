package OOPS.Classes;

public class singletonClass {
    // only one instance of this class be created
    private singletonClass(){

    }

    private static singletonClass singleton;
    public static singletonClass getInstance(){
        if(singleton == null){
            singleton = new singletonClass();
        }
        return singleton;
    }
}
