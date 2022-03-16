public class TrinomialDP {
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        k = Math.abs(k);
        long[][] t = new long[n + 1][n + 2];
        t[0][0] = 1;
        if (k > n) return 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                t[i][j] = t[i - 1][Math.abs(j - 1)] + t[i - 1][j] + t[i - 1][j + 1];
            }
        }
        return t[n][k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }

}
