package Arrays.level3;

public class KadanesAlgorithm {

    public static int maxSubArray(int[] arr) {

        int sum = 0;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            maxi = Math.max(maxi, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return maxi;
    }

    public static void main(String[] args) {

        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(arr));
    }
}