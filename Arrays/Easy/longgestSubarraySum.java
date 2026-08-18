public class longgestSubarraySum {
    public static int subarraySum(int[] arr, int k) {
        int right = 0, left = 0, maxLen = 0, sum = 0;
        while (right < arr.length) {
            sum += arr[right];
            while (sum > k) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3, 4, 5, 2, 2, 1, 3 };
        subarraySum(arr, 4);

    }

}
