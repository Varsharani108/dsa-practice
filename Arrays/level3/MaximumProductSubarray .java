package Arrays.level3;

public class MaximumProductSubarray {

    public static int maxProduct(int[] arr) {

        int maxi = arr[0];
        int mini = arr[0];

        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int current = arr[i];

            // Negative number can change max to min
            if (current < 0) {
                int temp = maxi;
                maxi = mini;
                mini = temp;
            }

            maxi = Math.max(current, maxi * current);

            mini = Math.min(current, mini * current);

            answer = Math.max(answer, maxi);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, -2, 4};

        System.out.println("Maximum Product = " + maxProduct(arr));
    }
}