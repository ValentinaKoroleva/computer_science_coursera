public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] aNew = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            aNew[i] = alpha * a[i];
        }
        return aNew;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] aNew = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            aNew[i] = a[a.length - 1 - i];
        }
        return aNew;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] abMerge = new double[a.length + b.length];
        int k = 0;
        int i = 0;
        while (k < abMerge.length) {
            if (k < a.length) {
                abMerge[k] = a[k];
            } else {
                abMerge[k] = b[i];
                i++;
            }
            k++;
        }
        return abMerge;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] aNew;
        double[] bNew;
        if (a.length > b.length) {
            aNew = new double[a.length];
            bNew = new double[a.length];
        } else {
            aNew = new double[b.length];
            bNew = new double[b.length];
        }
        double[] abSum = new double[aNew.length];
        for (int i = 0; i < abSum.length; i++) {
            if (i < a.length) {
                aNew[i] = a[i];
            }
            if (i < b.length) {
                bNew[i] = b[i];
            }
            abSum[i] = aNew[i] + bNew[i];
        }
        return abSum;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int newLength = (int) (a.length / alpha);
        double[] aNew = new double[newLength];
        for (int i = 0; i < newLength; i++) {
            int index = (int) (i * alpha);
            aNew[i] = a[index];
        }
        return aNew;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        String[] fileList = {"beatbox.wav", "buzzer.wav", "chimes.wav", "cow.wav", "dialup.wav",
                "exposure.wav", "harp.wav", "piano.wav", "scratch.wav", "silence.wav", "singer.wav"};
        int indexA = (int) (Math.random() * fileList.length);
        int indexB = (int) (Math.random() * fileList.length);
        double[] a = StdAudio.read(fileList[indexA]);
        double[] b = StdAudio.read(fileList[indexB]);
//        StdOut.println("a:" + fileList[indexA]);
//        StdOut.println("b:" + fileList[indexB]);
//        StdOut.println("Amplify");
        StdAudio.play(amplify(a, 0.5));
//        StdOut.println("Reverse");
        StdAudio.play(reverse(a));
//        StdOut.println("Merge");
        StdAudio.play(merge(a, b));
//        StdOut.println("Mix");
        StdAudio.play(mix(a, b));
//        StdOut.println("Change Speed");
        StdAudio.play(changeSpeed(a, 0.5));
    }
}
