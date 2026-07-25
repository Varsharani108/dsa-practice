package Arrays.level2;
public class binarySearch {
    public static int search(int[] arr, int target){
        int low=0,high=arr.length-1,index;
        
        while (low <= high) {
            int mid=(high+low)/2;
            if(target <arr[mid]){
                high=mid-1;
            }
            else if(target> arr[mid]){
                low=mid+1;
            }
            else{
                return mid;
            }
    
        }
        return -1;

    }
    public static void main(String[] args) {
        int arr[]={1,4,8,9,12,23};
        System.out.println(search(arr,12));
        
    }
    
}
