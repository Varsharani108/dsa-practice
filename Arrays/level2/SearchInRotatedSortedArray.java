package Arrays.level2;

public class SearchInRotatedSortedArray {

    public static int search(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            //left sorted
            else if(arr[mid]>=arr[low]){
                if (target >= arr[low] && target <= arr[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
                 
            }
            //right sorted
            else{
                if (target <= arr[high] && target > arr[mid]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                    
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {4,5,6,7,0,1,2};

        System.out.println(search(arr,0));
    }
}