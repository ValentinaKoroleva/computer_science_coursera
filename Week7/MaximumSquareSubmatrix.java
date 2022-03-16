public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int size = 0;
        int[][] sub = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                sub[i][j] = a[i][j];
            }
        }
        for (int i = 0; i < sub.length; i++) {
            for (int j = 0; j < sub[i].length; j++) {
                if (sub[i][j] > size) size = sub[i][j];
                if ((i + 1 < a.length) && (j + 1 < a.length) && (sub[i + 1][j + 1] > 0)) {
                    sub[i + 1][j + 1] = Math.min(Math.min(sub[i + 1][j], sub[i][j + 1]), sub[i][j]) + 1;
                    if (size < sub[i + 1][j + 1]) size = sub[i + 1][j + 1];
                }
            }
        }
        return size;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = StdIn.readInt();
            }
        }
        StdOut.println(size(matrix));
    }
}
