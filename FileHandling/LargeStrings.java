package FileHandling;

import java.text.DecimalFormat;
import java.util.Random;

public class LargeStrings {
    

    public static void main(String[] args) {
        // Mutable unlike strings, no duplicates are created for each string object creation
        // Efficient and Thread Safe
        StringBuffer buffer = new StringBuffer("");
        buffer.append("hello world");
        buffer.insert(0, "Hello");
        buffer.replace(1, 5, "potty");
        buffer.reverse();
        buffer.delete(1, 2);
        String str = buffer.toString();
        System.out.println(str);

        StringBuffer sb = new StringBuffer(30); // capacity limited
        sb.append("");

        Random random = new Random();
        System.out.println(random.nextBoolean());
        System.out.println(random.nextFloat());
        System.out.println(random.nextInt(200));

        DecimalFormat df = new DecimalFormat("0.000");

        System.out.println(df.format(random.nextFloat()));
    }
}
