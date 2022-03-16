public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long k = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) k++;
            }
        }
        return k;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i;
        }
        long kEdit = k;
        int a = 0;
        int t1 = permutation[n - 1];
        for (int i = 0; i < n; i++) {
            if (kEdit >= n - i && i > 0) {
                int t2 = permutation[i - 1];
                permutation[i - 1] = t1;
                permutation[i] = t2;
                t1 = t1 - 1;
                kEdit = kEdit - n + i;
                a++;
            }
            else {
                permutation[i] = permutation[i] - a;
            }
        }
//        if (count(permutation) != k) {
//            StdOut.println(count(permutation));
//            StdOut.println("not cool");
//        }
        return permutation;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        if (k > 0.5 * n * (n - 1)) StdOut.println(null);
        else {
            int[] permutation = generate(n, k);
            for (int i = 0; i < permutation.length; i++) {
                StdOut.print(permutation[i] + " ");
            }
            StdOut.println();
        }
    }
}