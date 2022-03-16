public class ColorHSB {
    private final int hue, saturation, brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h >= 360) throw new IllegalArgumentException("the hue must be between 0 and 359");
        if (s < 0 || s > 100) throw new IllegalArgumentException("the saturation must be between 0 and 100");
        if (b < 0 || b > 100) throw new IllegalArgumentException("the brightness must be between 0 and 100");
        hue = h;
        saturation = s;
        brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return saturation == 0 || brightness == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException("that is null");
        int hd1 = (hue - that.hue);
        int hd2 = (360 - Math.abs(hue - that.hue));
        int sd = (saturation - that.saturation);
        int bd = (brightness - that.brightness);
        return Math.min(hd1 * hd1, hd2 * hd2) + sd * sd + bd * bd;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h1 = Integer.parseInt(args[0]);
        int s1 = Integer.parseInt(args[1]);
        int b1 = Integer.parseInt(args[2]);
        ColorHSB baseColor = new ColorHSB(h1, s1, b1);
        String baseColorName = "";
        ColorHSB resultColor = new ColorHSB(0, 0, 0);
        int distance = 0;
        while (!StdIn.isEmpty()) {
            String colorName = StdIn.readString();
            int h2 = StdIn.readInt();
            int s2 = StdIn.readInt();
            int b2 = StdIn.readInt();
            ColorHSB color = new ColorHSB(h2, s2, b2);
            if (distance > baseColor.distanceSquaredTo(color) || baseColorName.equals("")) {
                distance = baseColor.distanceSquaredTo(color);
                baseColorName = colorName;
                resultColor = color;
            }
        }
        StdOut.println(baseColorName + " " + resultColor);
//        StdOut.println(baseColor.isGrayscale());
//        StdOut.println(resultColor.isGrayscale());
    }
}
