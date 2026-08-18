package Arrays.Bs_On_1D;

public class ceilAndfloor {
    public static int floor(int[] arr, int target){
         int low=0,high=arr.length-1,ans=-1;
        
        while (low <= high) {
            int mid=(high+low)/2;
            if(target >= arr[mid]){
                
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
               
                
            }
    
        }
        return arr[ans];

    }

    public static int ceil(int[] arr, int target) {
        int low=0,high=arr.length-1,ans=-1;
        
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
        return arr[ans];

    }
    public static void main(String[] args) {
        int arr[]={1,4,8,9,12,23};
        System.out.println("Floor"+floor(arr,12));
        System.out.println("Ceil"+ceil(arr,12));
    }

}
