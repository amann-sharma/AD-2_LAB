import java.util.*;

public class WeightedIntervalScheduling {
    static class Interval {
        int start, end, weight;

        public Interval(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static int weightedIntervalScheduling(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.end));
        int n = intervals.length;
        int[] dp = new int[n];
        dp[0] = intervals[0].weight;

        for (int i = 1; i < n; i++) {
            int include = intervals[i].weight;
            int latestNonConflict = findLatestNonConflict(intervals, i);
            if (latestNonConflict != -1)
                include += dp[latestNonConflict];
            dp[i] = Math.max(include, dp[i - 1]);
        }
        return dp[n - 1];
    }

    private static int findLatestNonConflict(Interval[] intervals, int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (intervals[i].end <= intervals[index].start)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(1, 4, 5),
                new Interval(3, 6, 7),
                new Interval(2, 8, 6),
                new Interval(5, 7, 4),
                new Interval(6, 9, 2),
                new Interval(8, 10, 9)
        };
        int maxWeight = weightedIntervalScheduling(intervals);
        System.out.println("Maximum Weighted Schedule: " + maxWeight);
    }
}
