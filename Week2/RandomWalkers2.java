public class RandomWalkers2 {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int totalSteps = 0;
        for (int i = 0; i < trials; i++) {
            int x = 0;
            int y = 0;
            int steps = 0;
            while (((Math.abs(x) + Math.abs(y)) < r)) {
                double step = Math.random();
                if (step <= 0.25) x++;
                else if (step <= 0.50) x--;
                else if (step <= 0.75) y++;
                else if (step <= 1.00) y--;
                steps++;
            }
            totalSteps = totalSteps + steps;
        }
        double averageSteps = (double) totalSteps / (double) trials;
        System.out.println("average number of steps = " + averageSteps);
    }
}
