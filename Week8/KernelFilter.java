import java.awt.Color;

public class KernelFilter {
    private static Picture kernel(Picture picture, double[][] weights) {
//        for (int i = 0; i < weights.length; i++) {
//            for (int j = 0; j < weights.length; j++) {
//                StdOut.print(weights[i][j] + "  ");
//            }
//            StdOut.print("\n");
//        }
//        StdOut.println();

        int w = picture.width();
        int h = picture.height();
        int center = weights.length / 2;
        Picture pic = new Picture(w, h);
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                double red = 0;
                double green = 0;
                double blue = 0;
                for (int i = 0; i < weights.length; i++) {
                    for (int j = 0; j < weights[i].length; j++) {
                        int c = col + i - center;
                        if (c % w < 0) c = w + (c % w);
                        else c = c % w;
//                        if (c < 0) c = Math.max(c + w - 1, 0);
//                        if (c >= w) c = Math.min(c - w + 1, w - 1);
                        int r = row + j - center;
                        if (r % h < 0) r = h + (r % h);
                        else r = r % h;
//                        r = r % h;
//                        if (r < 0) r = Math.max(r + h - 1, 0);
//                        if (r >= h) r = Math.min(r - h + 1, h - 1);
                        Color colorNeighbor = picture.get(c, r);
                        red = red + weights[i][j] * colorNeighbor.getRed();
                        green = green + weights[i][j] * colorNeighbor.getGreen();
                        blue = blue + weights[i][j] * colorNeighbor.getBlue();
                    }
                }
                if (red > 255) red = 255;
                if (green > 255) green = 255;
                if (blue > 255) blue = 255;
                if (red < 0) red = 0;
                if (green < 0) green = 0;
                if (blue < 0) blue = 0;
                Color colorNew = new Color((int) Math.round(red), (int) Math.round(green), (int) Math.round(blue));
                pic.set(col, row, colorNew);
            }
        }
        return pic;
    }

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] identity = new double[3][3];
        identity[1][1] = 1;
        return kernel(picture, identity);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double coef = 1.0 / 16.0;
        double[][] gaussian = new double[3][3];
        for (int i = 0; i < gaussian.length; i++) {
            for (int j = 0; j < gaussian[i].length; j++) {
                if ((i + j) % 2 == 0) gaussian[i][j] = 1 * coef;
                else gaussian[i][j] = 2 * coef;
            }
        }
        gaussian[1][1] = 4 * coef;
        return kernel(picture, gaussian);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] sharpen = new double[3][3];
        for (int i = 0; i < sharpen.length; i++) {
            for (int j = 0; j < sharpen[i].length; j++) {
                if ((i + j) % 2 == 0) sharpen[i][j] = 0;
                else sharpen[i][j] = -1;
            }
        }
        sharpen[1][1] = 5;
        return kernel(picture, sharpen);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] laplacian = new double[3][3];
        for (int i = 0; i < laplacian.length; i++) {
            for (int j = 0; j < laplacian[i].length; j++) {
                laplacian[i][j] = -1;
            }
        }
        laplacian[1][1] = 8;
        return kernel(picture, laplacian);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] emboss = new double[3][3];
        for (int i = 0; i < emboss.length; i++) {
            for (int j = 0; j < emboss[i].length; j++) {
                emboss[i][j] = i + j - 2;
            }
        }
        emboss[1][1] = 1;
        return kernel(picture, emboss);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double coef = 1.0 / 9.0;
        double[][] motion = new double[9][9];
        for (int i = 0; i < motion.length; i++) {
            for (int j = 0; j < motion[i].length; j++) {
                if (i == j) motion[i][j] = 1 * coef;
            }
        }
        return kernel(picture, motion);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture source = new Picture("baboon.png");
        Picture target1 = identity(source);
        Picture target2 = gaussian(source);
        Picture target3 = sharpen(source);
        Picture target4 = laplacian(source);
        Picture target5 = emboss(source);
        Picture target6 = motionBlur(source);
        source.show();
        target1.show();
        target2.show();
        target3.show();
        target4.show();
        target5.show();
        target6.show();
    }
}
