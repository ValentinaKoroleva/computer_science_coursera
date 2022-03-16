public class TrinomialBrute {
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        long result;
        if (n == 0 && k == 0) {
            result = 1;
        } else if (Math.abs(k) > n) {
            result = 0;
        } else {
            result = trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1);
        }
        return result;
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));

    }
}
