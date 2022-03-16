public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] a = new boolean[n];
        for (int i = 1; i < a.length; i++) {
            if (i % 2 == 0) {
                a[i] = a[i / 2];
            } else {
                a[i] = !a[i - 1];
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    System.out.print("+  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}
