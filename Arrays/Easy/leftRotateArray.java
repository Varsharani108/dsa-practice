public class leftRotateArray {
    public static void leftRotate(int[] arr){
        int temp = arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length -1]=temp;
        
    }
    public static void main(String[] args){
        int[] arr = {3,2,4,6,8,7};
        leftRotate(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }

    }
    
}
