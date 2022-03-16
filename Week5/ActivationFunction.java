public class ActivationFunction {
    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        double heavisideX = 0.0;
        if (x > 0.0) {
            heavisideX = 1;
        } else if (x == 0) {
            heavisideX = 0.5;
        } else if (Double.isNaN(x)) {
            heavisideX = Double.NaN;
        }
        return heavisideX;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        double sigmoidX = 1.0 / (1.0 + Math.exp(-x));
        return sigmoidX;
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        double tanhX = (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
        if (x > 20) {
            tanhX = 1.0;
        } else if (x < -20) {
            tanhX = -1.0;
        }
        return tanhX;
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        double softsignX = x / (1.0 + Math.abs(x));
        if (x == Double.POSITIVE_INFINITY) {
            softsignX = 1.0;
        } else if (x == Double.NEGATIVE_INFINITY) {
            softsignX = -1.0;
        }
        return softsignX;
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        double sqnlX = x + x * x / 4;
        if (x <= -2) {
            sqnlX = -1.0;
        } else if (x >= 2) {
            sqnlX = 1.0;
        } else if (x >= 0) {
            sqnlX = x - x * x / 4;
        }
        return sqnlX;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
//        StdOut.println(heaviside(Double.NEGATIVE_INFINITY));
        if (Double.isNaN(x)) {
            StdOut.println("heaviside(" + x + ") = " + x);
            StdOut.println("  sigmoid(" + x + ") = " + x);
            StdOut.println("     tanh(" + x + ") = " + x);
            StdOut.println(" softsign(" + x + ") = " + x);
            StdOut.println("     sqnl(" + x + ") = " + x);
        } else {
            StdOut.println("heaviside(" + x + ") = " + heaviside(x));
            StdOut.println("  sigmoid(" + x + ") = " + sigmoid(x));
            StdOut.println("     tanh(" + x + ") = " + tanh(x));
            StdOut.println(" softsign(" + x + ") = " + softsign(x));
            StdOut.println("     sqnl(" + x + ") = " + sqnl(x));
        }
    }
}
