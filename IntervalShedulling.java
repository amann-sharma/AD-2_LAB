//  Java implementation of GreedyAlgorithm Interval Scheduling 
import java.util.*;

class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class IntervalShedulling {
    public static List<Interval> intervalScheduling(List<Interval> intervals) {
        // Sort intervals based on their end times
        intervals.sort(Comparator.comparingInt(interval -> interval.end));
        
        List<Interval> selectedIntervals = new ArrayList<>();
        Interval lastSelected = null;
        
        // Iterate through each interval
        for (Interval interval : intervals) {
            // If current interval doesn't overlap with the last selected interval, select it
            if (lastSelected == null || interval.start >= lastSelected.end) {
                selectedIntervals.add(interval);
                lastSelected = interval;
            }
        }
        return selectedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 4));
        intervals.add(new Interval(3, 6));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(8, 9));
        intervals.add(new Interval(9, 11));

        List<Interval> selectedIntervals = intervalScheduling(intervals);

        System.out.println("Selected intervals are:");
        for (Interval interval : selectedIntervals) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }
}
