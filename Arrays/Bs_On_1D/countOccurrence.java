package Arrays.Bs_On_1D;

public class countOccurrence { 
    public static int fstOcc(int[] arr, int target) {
        int ans = -1, high = arr.length - 1, low = 0;

        while (low <= high) {

            int mid = (high + low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;

    }
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
    public static int count(int[] arr, int target){

    int first = fstOcc(arr, target);
    int last = lastOcc(arr, target);

    if(first == -1){
        return 0;
    }

    return last - first + 1;
}
    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 8, 8, 11, 13 };
        System.out.println(count(arr, 8));
    }
    
}
