package Arrays.Bs_On_1D;

public class searchInsertPosition {
    public static int search(int[] arr, int target){
        int low=0,high=arr.length-1,ans=arr.length;
        
        while (low <= high) {
            int mid=(high+low)/2;
            if(target <= arr[mid]){
                ans=mid;

                high=mid-1;
            }
            else{
                low=mid+1;
                
            }
    
        }
        return ans;

    }
    public static void main(String[] args) {
        int arr[]={1,4,8,9,12,23};
        System.out.println(search(arr,12));
        
    }
}
