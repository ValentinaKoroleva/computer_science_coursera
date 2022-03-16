import java.util.Arrays;

public class BarChartRacer {
    // Sample client (see below).
    public static void main(String[] args) {
//        StdAudio.loop("soundtrackA.wav");
//        StdAudio.loop("soundtrackB.wav");
//        StdAudio.loop("soundtrackC.wav");
//        StdAudio.loop("soundtrackD.wav");
//        StdAudio.loop("soundtrackE.wav");
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1000, 700);

        String fileName = args[0];
        In in = new In(fileName);
        int k = Integer.parseInt(args[1]);
        // create the bar chart
        String title = in.readLine();
        String xAxisLabel = in.readLine();
        String source = in.readLine();

        BarChart chart = new BarChart(title, xAxisLabel, source);
        while (in.hasNextLine()) {
            in.readLine();
            int n = Integer.parseInt(in.readLine());
//            StdOut.println(n);
            String date = "";
            // add the bars to the bar chart
            Bar[] bars = new Bar[n];
            for (int i = 0; i < n; i++) {
                String row = in.readLine();
                String[] cols = row.split(",");
                if (date.isEmpty()) {
                    date = cols[0].split("-")[0];
                    chart.setCaption(date);
                }
                bars[i] = new Bar(cols[1], Integer.parseInt(cols[3]), cols[4]);
            }
            Arrays.sort(bars);
            for (int i = 0; i < k; i++) {
                chart.add(bars[bars.length - 1 - i].getName(),
                        bars[bars.length - 1 - i].getValue(),
                        bars[bars.length - 1 - i].getCategory());
            }
            // draw the bar chart
            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            chart.reset();
        }
    }
}
