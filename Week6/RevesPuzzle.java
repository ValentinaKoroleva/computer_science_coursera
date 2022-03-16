public class RevesPuzzle {
    private static void hanoi(int n, String from, String temp, String to, int k) {
        if (n == 0) return;
        hanoi(n - 1, from, to, temp, k);
        StdOut.println("Move disc " + (n + k) + " from " + from + " to " + to);
        hanoi(n - 1, temp, from, to, k);
    }

    // move n smallest discs from one pole to another, using the temp pole
    private static void reves(int n, String from, String temp1, String temp2, String to) {
        if (n == 0) return;
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
        reves(k, from, to, temp2, temp1);
        hanoi(n - k, from, temp2, to, k);
        reves(k, temp1, from, temp2, to);

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "B", "C", "D");
    }
}
