package Recursion.Basics;

public class PrintNumIncreOrder {
    public static void IncreOrder(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        IncreOrder(n-1);
        System.out.print(n+" ");

    }
    public static void main(String args[]){
        int n=10;
        IncreOrder(n);
    }
    
}
