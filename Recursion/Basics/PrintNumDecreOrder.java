package Recursion.Basics;

public class PrintNumDecreOrder {
    public static void DecreOrder(int n){
        if(n==1){
            System.out.print(n);
            return;
        }
        System.out.println(n+" ");
        DecreOrder(n-1);

    }
    public static void main(String args[]){
        int n=10;
        DecreOrder(n);
    }
    
}
