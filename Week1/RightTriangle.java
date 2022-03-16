public class RightTriangle {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        boolean check1 = a > 0 && b > 0 && c > 0;
        double aSqr = a * a;
        double bSqr = b * b;
        double cSqr = c * c;

        boolean check2 = (aSqr == (bSqr+cSqr)) || (bSqr == (aSqr+cSqr)) || (cSqr == (aSqr+bSqr));
        System.out.println(check1 && check2);
    }
}