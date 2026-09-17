package Recursion.Basics;

public class TillingProblem {
    public static int ways(int n){   //n is a total width of board
        if(n==0 ||n==1){
            return 1;
        }
        //vertical
        int fnm1=ways(n-1);
        //horizontal
        int fnm2=ways(n-2);
        int totWays=fnm1 + fnm2;

        return totWays;
    }
    public static void main(String args[]){
        System.out.println(ways(4));

    }
    
    
}
