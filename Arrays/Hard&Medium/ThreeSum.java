package Arrays.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] arr) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            // Skip duplicate i
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k) {

                int sum = arr[i] + arr[j] + arr[k];

                if (sum < 0) {
                    j++;
                }
                else if (sum > 0) {
                    k--;
                }
                else {

                    ans.add(Arrays.asList(
                            arr[i],
                            arr[j],
                            arr[k]
                    ));

                    j++;
                    k--;

                    // Skip duplicate j
                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }

                    // Skip duplicate k
                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {-1, 0, 1, 2, -1, -4};

        System.out.println(threeSum(arr));
    }
}