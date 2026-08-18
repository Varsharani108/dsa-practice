package Arrays.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {

            // No overlap
            if (ans.isEmpty() || interval[0] > ans.get(ans.size() - 1)[1]) {

                ans.add(new int[]{interval[0], interval[1]});

            }
            // Overlap
            else {

                int[] last = ans.get(ans.size() - 1);

                last[1] = Math.max(last[1], interval[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void printIntervals(int[][] intervals) {

        for (int[] interval : intervals) {
            System.out.println(
                    "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
    }

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] result = merge(intervals);

        printIntervals(result);
    }
}