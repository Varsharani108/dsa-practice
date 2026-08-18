package Arrays.Bs_On_1D;

public class lastOccurrence {
    public static int lastOcc(int[] arr, int target) {
        int ans = -1, high = arr.length - 1, low = 0;

        while (low <= high) {

            int mid = (high + low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;

    }
    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 8, 8, 11, 13 };
        System.out.println(lastOcc(arr, 8));
    }
    
}
