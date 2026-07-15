public class LargestElement{
    public static int le(int[] arr){
        int lar=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>lar){
                lar=arr[i];
            }
            
        }
        return lar;

    }
    public static void main(String[]args){
        int[] arr={10,5,20,7,30};
        int largest = le(arr);
        System.out.println("Largest:"+ largest);
    }
}