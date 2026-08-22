public class KthMissingPositive {

    public static int findKthPositive(int[] arr, int k) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Missing numbers before arr[mid]
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                // Need to go right
                low = mid + 1;
            } else {
                // Go left
                high = mid - 1;
            }
        }

        return low + k;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        System.out.println(findKthPositive(arr, k));
    }
}