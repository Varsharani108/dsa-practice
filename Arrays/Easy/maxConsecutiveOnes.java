public class maxConsecutiveOnes {
    public static int maxOnes(int[] arr){
        int count=0,maxCount=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                count++;
                maxCount = Math.max(maxCount, count);
            }
            else{
                count=0;
            }
            
        }
        return maxCount;
    }
    public static void main(String[] args){
        int[] arr = {1,1,0,1,1,1,0,0,1};
       
        System.out.println(maxOnes(arr));
    }
    
}
