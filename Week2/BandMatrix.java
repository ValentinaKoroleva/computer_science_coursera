public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        for (int i = 0; i < n; i++) {
            String row = "";
            for (int j = 0; j < n; j++) {
                int k = Math.abs(i - j);
                if (k > width) {
                    row = row + "0  ";
                } else {
                    row = row + "*  ";
                }
            }
            System.out.println(row);
        }
    }
}
