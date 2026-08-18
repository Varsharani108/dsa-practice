public class missingNumWithXOR {
     public static int misNum(int[] arr){
        int sum=0,i,sumNum=0,n=arr.length+1;
        for( i=0; i < arr.length; i++){
            sum^=arr[i];

        }
        for( i=1; i <= n; i++){
            sumNum^=i;

        }
        int mis=sumNum^sum;
        return mis;
    }
    public static void main(String[] args){
        int[] arr={1,2,3,4,6,5,7,9};
        System.out.println(misNum(arr));
    }
   
    
}
