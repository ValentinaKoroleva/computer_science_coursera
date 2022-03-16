public class Clock {
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;

    private int hours, minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h >= HOURS_PER_DAY) throw new IllegalArgumentException("the hours must be between 0 and 23");
        if (m < 0 || m >= MINUTES_PER_HOUR) throw new IllegalArgumentException("the minutes must be between 0 and 59");
        hours = h;
        minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5) throw new IllegalArgumentException("Use the format HH:MM");
        if (!(s.substring(2, 3).equals(":")))
            throw new IllegalArgumentException("Use the format HH:MM");
        int hs = Integer.parseInt(s.substring(0, 2));
        if (hs < 0 || hs >= HOURS_PER_DAY) throw new IllegalArgumentException("Use the format HH:MM");
        int ms = Integer.parseInt(s.substring(3, 5));
        if (ms < 0 || ms >= MINUTES_PER_HOUR) throw new IllegalArgumentException("Use the format HH:MM");

        hours = Integer.parseInt(s.substring(0, 2));
        minutes = Integer.parseInt(s.substring(3, 5));
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String result = "";
        if (hours < 10) result = "0" + hours;
        else result = "" + hours;
        result = result + ":";
        if (minutes < 10) result = result + "0" + minutes;
        else result = result + minutes;
        return result;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (hours < that.hours) return true;
        else return hours == that.hours && minutes < that.minutes;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        minutes = minutes + 1;
        if (minutes == MINUTES_PER_HOUR) {
            hours = (hours + 1) % HOURS_PER_DAY;
            minutes = minutes % MINUTES_PER_HOUR;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException("Delta must not be negative");
        minutes = minutes + delta;
        if (minutes >= MINUTES_PER_HOUR) {
            hours = (hours + (minutes / MINUTES_PER_HOUR)) % HOURS_PER_DAY;
            minutes = minutes % MINUTES_PER_HOUR;
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        String s = args[2];
        Clock time1 = new Clock(h, m);
        Clock time2 = new Clock(s);
        StdOut.println(time1);
        StdOut.println("Is Time 1 earlier than Time 2? - " + time1.isEarlierThan(time2));
        StdOut.println("Is Time 2 earlier than Time 1? - " + time2.isEarlierThan(time1));
        time1.tic();
        StdOut.println(time1);
        time2.tic();
        StdOut.println(time2);
        time2.toc(145);
        StdOut.println(time2);
        time1.toc(145);
        StdOut.println(time1);

    }
}
