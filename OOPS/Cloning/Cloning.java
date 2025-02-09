package OOPS.Cloning;

// if Cloneable is not mentioned, error is throwen
public class Cloning implements Cloneable{
    String DNA;

    Cloning(String info){
        this.DNA = info;
    }

    Cloning(Cloning clone){
        this.DNA = clone.DNA;
    }

    String getDNA(){
        return this.DNA;
    }

    public Object clone() throws CloneNotSupportedException{
        // this is shallow copy!
        // only copies primitive and refer derivates (array) can result in modification of array
        return super.clone();
    }
}
