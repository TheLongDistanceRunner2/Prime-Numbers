import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Vector;
import java.math.*;

import static java.lang.Math.*;

public class IsPrime {
    private Vector<BigInteger> numbers;
    private static Vector<Integer> powers;

    public IsPrime() { };

    public IsPrime(Vector<BigInteger> numbers, Vector<Integer> powers) {
        //initialize vector:
        this.numbers = new Vector<>();
        this.powers = new Vector<>();

        // add values to numbers:
        for (int i = 0; i < numbers.size(); i++) {
            this.numbers.add(numbers.elementAt(i));
        }

        // add values to powers:
        for (int i = 0; i < powers.size(); i++) {
            this.powers.add(powers.elementAt(i));
        }
    }

    public void showInputNumbers() {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.elementAt(i));
        }
    }

    private String isPrimeTrialDivision(BigInteger inumber) {
        // convert BigInteger to BigDecimal:
        BigDecimal number = new BigDecimal(inumber);

        BigDecimal Sqrt = number.sqrt(MathContext.DECIMAL64);
        BigDecimal lSqrt = Sqrt.setScale(0, RoundingMode.UP);

        BigDecimal _sqrt = lSqrt.add(BigDecimal.ONE);

        for (BigDecimal i = new BigDecimal(2); !i.equals(_sqrt); i = i.add(BigDecimal.ONE)) {
            // if this number has a divisor:
            if(number.remainder(i).compareTo(BigDecimal.ZERO) == 0) {
                // it's complex, so it isn't prime number:
                return "no";
            }
        }

        // if it is prime:
        return "yes";
    }

    private String isPrimeLucasLehmer(BigInteger number, int power) {
        BigInteger M = number;
        int p = power;
        int needed = p - 2;

        final BigInteger two = new BigInteger("2");
        final BigInteger one = new BigInteger("1");

        BigInteger s0 = new BigInteger("4");
        BigInteger tmp = new BigInteger("14");
        BigInteger s = tmp.remainder(M);

        // if exponenet doesn't equal 2:
        if (needed != 0) {
            // calculate s up to p-2 (except s0):
            for (int i = 1; i < needed; i++) {
                s = s.pow(2);
                s = s.subtract(new BigInteger("2"));
                s = s.remainder(M);
            }
        }

        // if it's prime number:
        if(s.remainder(M).compareTo(BigInteger.ZERO) == 0 /*|| p-2 == 0 */) {
            return "yes";
        }
        // if complex:
        else {
            return "no";
        }
    }

    public void showOutcomes() {
        System.out.println("Number:     Trial Division:      Lucas-Lehmer test: " );
        String leftAlignFormat = "%-18d | %-16s | %-4s |%n";

        for (int i = 0; i < numbers.size(); i++) {
            System.out.format(leftAlignFormat, numbers.elementAt(i), isPrimeTrialDivision(numbers.elementAt(i)),
                    isPrimeLucasLehmer(numbers.elementAt(i), powers.elementAt(i)));
        }
    }

    public long howManyPrimes(BigInteger start, BigInteger end) {
        long counter = 0;

        BigInteger _end = end.add(BigInteger.ONE);

        for (BigInteger i = start; !i.equals(_end); i = i.add(BigInteger.ONE)) {
            if (isPrimeTrialDivision(i) == "yes") {
                counter++;
            }
        }

        return counter;
    }

    public static void main(String args[]) {
        IsPrime isPrime1 = new IsPrime();

        long number = 2 ^ 9 - 1;

        System.out.println(isPrime1.isPrimeTrialDivision(BigInteger.valueOf(number)));
    }
}
