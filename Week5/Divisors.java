public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        int gcdAB = 0;
        a = Math.abs(a);
        b = Math.abs(b);
        int t = a;
        while (b > 0) {
            a = b;
            b = t % b;
            t = a;
        }
        gcdAB = a;
        return gcdAB;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        int lcmAB = 0;
        if (gcd(a, b) > 0) {
            lcmAB = (int) (((long) Math.abs(a) * (long) Math.abs(b)) / gcd(a, b));
        }
        return lcmAB;
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        boolean arePrime = false;
        if (gcd(a, b) == 1) {
            arePrime = true;
        }
        return arePrime;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        int totientN = 0;
        for (int i = 1; i < n + 1; i++) {
            if (areRelativelyPrime(n, i)) {
                totientN++;
            }
        }
        return totientN;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        StdOut.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        StdOut.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        StdOut.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        StdOut.println("totient(" + a + ") = " + totient(a));
        StdOut.println("totient(" + b + ") = " + totient(b));
    }
}
