import static java.lang.Math.*;
import java.math.BigInteger;
import java.util.Vector;

public class Main {
    private static Vector<BigInteger> numbers = new Vector<>();
    private static Vector<Long> powers = new Vector<>();

    private static void initializeVectors(Vector<BigInteger> numbers, Vector<Integer> powers) {
        powers.add(2);
        powers.add(3);
        powers.add(5);
        powers.add(7);
        powers.add(11);
        powers.add(13);
        powers.add(17);
        powers.add(19);
        powers.add(23);
        powers.add(29);
        powers.add(31);
        powers.add(32);

        final BigInteger two = new BigInteger("2");
        final BigInteger one = new BigInteger("1");

        // 2 ^ 2 - 1:
        BigInteger tmp = two.pow(powers.elementAt(0));
        numbers.add(tmp.subtract(one));

        // 2 ^ 3 - 1:
        tmp = two.pow(powers.elementAt(1));
        numbers.add(tmp.subtract(one));

        // 2 ^ 5 - 1:
        tmp = two.pow(powers.elementAt(2));
        numbers.add(tmp.subtract(one));

        // 2 ^ 7 - 1:
        tmp = two.pow(powers.elementAt(3));
        numbers.add(tmp.subtract(one));

        // 2 ^ 11 - 1:
        tmp = two.pow(powers.elementAt(4));
        numbers.add(tmp.subtract(one));

        // 2 ^ 13 - 1:
        tmp = two.pow(powers.elementAt(5));
        numbers.add(tmp.subtract(one));

        // 2 ^ 17 - 1:
        tmp = two.pow(powers.elementAt(6));
        numbers.add(tmp.subtract(one));

        // 2 ^ 19 - 1:
        tmp = two.pow(powers.elementAt(7));
        numbers.add(tmp.subtract(one));

        // 2 ^ 23 - 1:
        tmp = two.pow(powers.elementAt(8));
        numbers.add(tmp.subtract(one));

        // 2 ^ 29 - 1:
        tmp = two.pow(powers.elementAt(9));
        numbers.add(tmp.subtract(one));

        // 2 ^ 31 - 1:
        tmp = two.pow(powers.elementAt(10));
        numbers.add(tmp.subtract(one));

        // 2 ^ 64 - 1:
        tmp = two.pow(powers.elementAt(11));
        numbers.add(tmp.subtract(one));
    }

    // =====================================================================================
    public static void main (String args[]) {
        // create and initialize vector with input numbers:
        Vector<BigInteger> numbers = new Vector<>();
        Vector<Integer> powers = new Vector<>();
        initializeVectors(numbers, powers);

        System.out.println("    -> Is this prime number?");

        IsPrime isPrime1 = new IsPrime(numbers, powers);
        isPrime1.showOutcomes();

        System.out.println("===================================================");
        System.out.println("From 7.000.000 to 8.000.000 there are: "
                + isPrime1.howManyPrimes(new BigInteger("7000000"),
                                         new BigInteger("8000000"))
                + " prime numbers!");
    }
}
