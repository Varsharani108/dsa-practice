// public class fixesSizeSlidingWindow {
//     public static int fixedSize(int[] arr,int k){
//         int max=0;
//         for(int i=0;i<arr.length-k-1;i++){
//             int sum=0;
//             for(int j=i;j<k+i;j++){
//                 sum+=arr[j];
//             }
//             max=Math.max(sum, max);

//         }
//         return max;
//     }
//      public static void main(String[] args) {
//         int arr[] = { 1, 1, 2, 3, 4, 5, 2, 2, 1, 3 };
//         fixedSize(arr, 4);

//     }
// }
public class fixesSizeSlidingWindow {
    public static int fixedSize(int[] arr,int k){
        int max=0;int sum=0;
        for(int i=0;i<k;i++){
            sum += arr[i];
            max=sum;
        }
        for(int i = k; i < arr.length; i++){
            sum = sum - arr[i-k] + arr[i];
            max = Math.max(max, sum);
        }


        
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3, 4, 5, 2, 2, 1, 3 };
        fixedSize(arr, 4);

    }
}
