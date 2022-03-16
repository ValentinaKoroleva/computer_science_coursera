public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int t = 0;
        int[] peopleEnter = new int[n + 2];
        while (t < trials) {
            boolean[] ba = new boolean[n];
            int person = 0;
            while (person < n + 2) {
                int bd = (int) (Math.random() * n);
                person++;
                if (!ba[bd]) ba[bd] = true;
                else break;
            }
            peopleEnter[person]++;
            t++;
        }
        int[] s = new int[n + 2];
        double share = 0.0;
        int k = 1;
        while (share < 0.5) {
            s[k] = s[k - 1] + peopleEnter[k];
            share = (double) s[k] / (double) trials;
            System.out.println(k + " " + peopleEnter[k] + " " + share);
            k++;
        }
    }
}
