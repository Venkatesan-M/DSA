package FileHandling;

import java.math.BigDecimal;
import java.math.BigInteger;

public class LargeNumerals {
    public static void main(String[] args) {
        int a = 30; int b = 33;

        BigInteger A = BigInteger.valueOf(a); // no new keyword is used as
        BigInteger B = BigInteger.valueOf(b); // valueof() is a static function which returns a BigInteger;

        BigInteger C = BigInteger.ONE; // ZERO, TWO etc

        BigInteger sum = A.add(B);
        System.out.println(sum.subtract(C));

        BigDecimal bd = BigDecimal.valueOf(0.011);

        System.out.println(bd.negate());

    }
}
