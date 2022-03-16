import java.util.Arrays;

public class Bar implements Comparable<Bar> {
    private final String barName;
    private final int barValue;
    private final String barCategory;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        if (name == null) throw new IllegalArgumentException("Name is null");
        if (value < 0) throw new IllegalArgumentException("Value is negative");
        if (category == null) throw new IllegalArgumentException("Category is null");

        barName = name;
        barValue = value;
        barCategory = category;
    }

    // Returns the name of this bar.
    public String getName() {
        return barName;
    }

    // Returns the value of this bar.
    public int getValue() {
        return barValue;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return barCategory;
    }

    // Compare two bars by value.
    public int compareTo(Bar that) {
        if (that == null) throw new NullPointerException("Argument is null");
        if (barValue < that.barValue) return -1;
        else if (barValue == that.barValue) return 0;
        else return 1;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String fileName = args[0];
        In in = new In(fileName);
        int n = in.readInt();
        in.readLine();
        Bar[] bars = new Bar[n];
        for (int i = 0; i < n; i++) {
            String row = in.readLine();
            String[] cols = row.split(",");
            bars[i] = new Bar(cols[1], Integer.parseInt(cols[3]), cols[4]);
        }
        Arrays.sort(bars);
        for (int i = 0; i < 2; i++) {
            StdOut.print(bars[i].barName + "  " + bars[i].barValue + "\n");
        }
    }
}
