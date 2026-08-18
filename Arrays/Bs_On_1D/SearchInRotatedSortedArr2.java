package Arrays.Bs_On_1D;

public class SearchInRotatedSortedArr2 {

    public static boolean search(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return true;
            }

            // Duplicate case
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }

            // Left sorted
            if (arr[low] <= arr[mid]) {

                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }

            // Right sorted
            else {

                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr = {2,5,6,0,0,1,2};

        System.out.println(search(arr, 0)); // true
        System.out.println(search(arr, 3)); // false
    }
}