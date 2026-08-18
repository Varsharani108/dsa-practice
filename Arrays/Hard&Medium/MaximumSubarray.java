package Arrays.level3;

public class MaximumSubarray {
    public static void PrintMaximumSubArray(int[] arr){
        int start=0,indexStart=-1,indexEnd=-1,maxi=Integer.MIN_VALUE,sum=0;
        for(int i=0;i<arr.length;i++){
            if(sum==0){
                start=i;
            }
            
            sum+=arr[i];
            if (sum > maxi) {
                maxi = sum;
                indexStart = start;
                indexEnd = i;
            }
            if(sum<0){
                sum=0;
            }
            
        }
        System.out.println("Maximum="+maxi);
        for(int i=indexStart;i<=indexEnd;i++){
            System.out.print(arr[i]+ " ");
        }
    }
    public static void main(String[] args) {

        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        PrintMaximumSubArray(arr);
    }
    
}
