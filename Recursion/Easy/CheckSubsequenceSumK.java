package Recursion.Easy;

public class CheckSubsequenceSumK {
    public static boolean exists(int[] arr, int index, int sum, int k) {
        if (index == arr.length) {
           if (sum == k) {
               return true;
           } else {
               return false;
           }
        }
        boolean take = exists(
                arr,
                index + 1,
                sum + arr[index],
                k
        );

        // Not take the current element
        boolean notTake = exists(
                arr,
                index + 1,
                sum,
                k
        );

        return take || notTake;


}
    


 public static void main(String[] args) {

        int[] arr = {1, 2, 1};
        int k = 2;

        boolean result = exists(arr, 0, 0, k);

        System.out.println(result);
    }
}
