public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int steps = 0;
        System.out.println("(" + x + ", " + y + ")");
        while (((Math.abs(x) + Math.abs(y)) < r)) {
            int step1 = (int) (Math.round(Math.random()) * 2 - 1.0);
            int step2 = (int) (Math.round(Math.random()));
            if (step2 == 1) {
                x = x + step1;
            } else {
                y = y + step1;
            }
            System.out.println("(" + x + ", " + y + ")");
            steps++;
        }
        System.out.println("steps = " + steps);
    }
}
