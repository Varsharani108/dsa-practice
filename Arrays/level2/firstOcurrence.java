package Arrays.level2;

public class firstOcurrence {
    public static int fstOcc(int[] arr, int target){
        int ans = -1,high=arr.length -1,low=0;

while(low <= high){

    int mid =(high+low)/2;

    if(arr[mid] == target){
        ans = mid;
        high=mid-1;
    }
    else if(arr[mid] < target){
        low=mid+1;
    }
    else{
        high=mid-1;
    }
}

return ans;

    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 8, 8, 11, 13 };
        System.out.println(fstOcc(arr, 8));
    }

}
