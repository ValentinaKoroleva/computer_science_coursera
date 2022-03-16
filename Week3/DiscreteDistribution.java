public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] a = new int[args.length - 1];
        int[] s = new int[args.length];
        for (int i = 1; i < args.length; i++) {
            a[i - 1] = Integer.parseInt(args[i]);
            s[i] = s[i - 1] + a[i - 1];
        }
        int k = 0;
        while (k < m) {
            int r = (int) (Math.random() * s[s.length - 1]);
            int j = s[0];
            for (int i = 1; i < s.length; i++) {
                if (r >= s[i - 1]) j = i;
            }
            System.out.print(j + " ");
            k++;
        }
        System.out.println();
    }
}
