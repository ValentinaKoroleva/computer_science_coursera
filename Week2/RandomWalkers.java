public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int totalSteps = 0;
        for (int i = 0; i < trials; i++) {
            int x = 0;
            int y = 0;
            int steps = 0;
            while (((Math.abs(x) + Math.abs(y)) < r)) {
                int step1 = (int) (Math.round(Math.random()) * 2 - 1.0);
                int step2 = (int) (Math.round(Math.random()));
                if (step2 == 1) {
                    x = x + step1;
                } else {
                    y = y + step1;
                }
                steps++;
            }
            totalSteps = totalSteps + steps;
        }
        double averageSteps = (double) totalSteps / (double) trials;
        System.out.println("average number of steps = " + averageSteps);
    }
}
