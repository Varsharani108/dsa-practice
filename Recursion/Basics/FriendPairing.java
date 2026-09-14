package Recursion.Basics;

public class FriendPairing {
    public static int pair(int n){
        if(n==1 || n==0){
            return 1;
        }
        //single
        int fnm1=pair(n-1);
        //pair
        int fnm2=pair(n-2);
        int pairways = (n-1) * fnm2;
        //totway
        int totways=fnm1 + pairways;
        return totways;
    }
    
}
