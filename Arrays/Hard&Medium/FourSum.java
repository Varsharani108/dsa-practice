package Arrays.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] arr, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        int n = arr.length;

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {

            // Skip duplicate i
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {

                // Skip duplicate j
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    long sum = (long) arr[i]
                            + arr[j]
                            + arr[k]
                            + arr[l];

                    if (sum < target) {
                        k++;
                    }
                    else if (sum > target) {
                        l--;
                    }
                    else {

                        ans.add(Arrays.asList(
                                arr[i],
                                arr[j],
                                arr[k],
                                arr[l]
                        ));

                        k++;
                        l--;

                        // Skip duplicate k
                        while (k < l && arr[k] == arr[k - 1]) {
                            k++;
                        }

                        // Skip duplicate l
                        while (k < l && arr[l] == arr[l + 1]) {
                            l--;
                        }
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {1, 0, -1, 0, -2, 2};

        int target = 0;

        System.out.println(fourSum(arr, target));
    }
}