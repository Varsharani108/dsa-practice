package Recursion.Basics;

public class FirstOccurence {
    public static int Occurence(int arr[],int key,int i){
        if(arr[i]==key){
            System.out.println(i);
            return i;
        }
        
        Occurence(arr,key,i+1);
        
    return 0;

    }
    public static void main(String args[]){
        int arr[]={3,2,4,2,4,5,7,6,7,8};
        Occurence(arr,2,0);
    }
    
}
