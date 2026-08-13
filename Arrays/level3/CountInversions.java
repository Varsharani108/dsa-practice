package Arrays.level3;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {

    public static int countInversions(int[] arr) {

        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int low, int high) {

        int count = 0;

        if (low < high) {

            int mid = low + (high - low) / 2;

            // Count inversions in left half
            count += mergeSort(arr, low, mid);

            // Count inversions in right half
            count += mergeSort(arr, mid + 1, high);

            // Count inversions between both halves
            count += merge(arr, low, mid, high);
        }

        return count;
    }

    public static int merge(int[] arr, int low, int mid, int high) {

        List<Integer> temp = new ArrayList<>();

        int i = low;
        int j = mid + 1;

        int count = 0;

        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {

                temp.add(arr[i]);
                i++;

            } else {

                // All remaining elements in left
                // are greater than arr[j]
                count += (mid - i + 1);

                temp.add(arr[j]);
                j++;
            }
        }

        // Remaining elements of left half
        while (i <= mid) {

            temp.add(arr[i]);
            i++;
        }

        // Remaining elements of right half
        while (j <= high) {

            temp.add(arr[j]);
            j++;
        }

        // Put sorted elements back into array
        for (int k = low; k <= high; k++) {

            arr[k] = temp.get(k - low);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {5, 3, 2, 1, 4};

        System.out.println("Inversions = " + countInversions(arr));
    }
}