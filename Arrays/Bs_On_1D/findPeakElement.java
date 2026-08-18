package Arrays.Bs_On_1D;

public class findPeakElement {

    public static int findPeak(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }

        return low;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,1};

        System.out.println(findPeak(arr));
    }
}