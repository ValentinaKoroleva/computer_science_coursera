public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int maxCAG = 0;
        int counter = 0;
        for (int i = 0; i < dna.length() - 2; i++) {
            String codon = dna.substring(i, i + 3);
            if (codon.equals("CAG")) {
                counter++;
            }
            else if (!(codon.equals("AGC") || codon.equals("GCA"))) {
                if (counter > maxCAG) maxCAG = counter;
                counter = 0;
            }
        }
        if (counter > maxCAG) maxCAG = counter;

        return maxCAG;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String sCopy = s;
        sCopy = sCopy.replace(" ", "");
        sCopy = sCopy.replace("\n", "");
        sCopy = sCopy.replace("\t", "");
//        StdOut.println(sCopy);
        return sCopy;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        String d = "not human";
        if (maxRepeats <= 9) d = "not human";
        else if (maxRepeats <= 35) d = "normal";
        else if (maxRepeats <= 39) d = "high risk";
        else if (maxRepeats <= 180) d = "Huntington's";
        return d;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String fileName = args[0];
        In in = new In(fileName);
        String seq = in.readAll();
        String seqClean = removeWhitespace(seq);
        int maxCAG = maxRepeats(seqClean);
        StdOut.println("max repeats = " + maxCAG);
        StdOut.println(diagnose(maxCAG));
    }
}
