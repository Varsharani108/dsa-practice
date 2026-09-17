package Recursion.Basics;

public class FirstOccurence {
    public static int Occurence(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            System.out.println(i);
            return i;
        }
        
         return Occurence(arr,key,i+1);

    }
    public static void main(String args[]){
        int arr[]={3,2,4,2,4,5,7,6,7,8};
        Occurence(arr,2,0);
    }
    
}
