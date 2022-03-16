public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        boolean[][] mines = new boolean[m][n];
        int[][] map = new int[m][n];
        int j = 0;
        while (j < k) {
            int x = (int) (Math.random() * m);
            int y = (int) (Math.random() * n);
            if (!mines[x][y]) {
                mines[x][y] = true;
                for (int c = -1; c < 2; c++) {
                    for (int d = -1; d < 2; d++) {
                        if (x + c >= 0 && x + c < m && y + d >= 0 && y + d < n && !mines[x + c][y + d]) {
                            map[x + c][y + d]++;
                        }
                    }
                }
                j++;
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int p = 0; p < map[i].length; p++) {
                if (!mines[i][p]) System.out.print(map[i][p] + "  ");
                else System.out.print("*  ");
            }
            System.out.println();
        }
    }
}
