public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        double c1 = Math.sin(((x2 - x1)/2.0)) * Math.sin(((x2 - x1)/2.0));
        double c2 = Math.cos(x1) * Math.cos(x2) * Math.sin(((y2 - y1)/2.0)) * Math.sin(((y2 - y1)/2.0));
        double c = Math.sqrt(c1 + c2);
        double distanceInRad = 2 * 6371.0 * Math.asin(c);
        double distance = distanceInRad;
        System.out.println(distance + " kilometers");
    }
}