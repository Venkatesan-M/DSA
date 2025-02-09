package OOPS.ExceptionalHandling;

public class ExceptionalHandling {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
    
        try{
            System.out.println(divide(a, b));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("this will executed regardless");
        }
    }

    static int divide(int a, int b) throws Exception{
        if(b == 0){
            throw new ArithmeticException("Please don't divide by zero!");
        }
        return a / b;
    }
}
