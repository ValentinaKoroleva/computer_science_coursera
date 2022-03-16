public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        double aMax = Math.cbrt(n);
        long a = 0;
        boolean result = false;
        for (long a1 = 1; a1 < aMax; a1++) {
            long aCube = a1 * a1 * a1;
            long bCube = n - aCube;
            long b1 = Math.round(Math.cbrt(bCube));
            if ((b1 * b1 * b1) + (a1 * a1 * a1) == n) {
                if (a == 0) {
                    a = a1;
                } else if (a != b1) {
                    result = true;
                }
            }
        }

        return result;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}
