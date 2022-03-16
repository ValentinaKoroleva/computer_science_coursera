public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] a = new int[m];
        int n = 0;
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            a[x - 1]++;
            n++;
        }
        double h = 0.0;
        for (int i = 0; i < a.length; i++) {
            double p = (double) a[i] / n;
            if (p > 0.0) {
                h += -(p * Math.log(p) / Math.log(2));
            }
        }
        StdOut.printf("%.4f\n", h);
    }
}

