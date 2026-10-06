package GreedyAlgorithm.Basics;
import java.util.*;

public class MinimumSumAbsoluteDiffPairs {
    public static void main(String []args){
        int A[]={1,3,5,2};
        int B[]={5,4,6,2};
        Arrays.sort(A);
        Arrays.sort(B);
        int mindiff=0;
        for(int i=0;i<A.length;i++){
            mindiff+=Math.abs(A[i]-B[i]);
        }
        System.out.println(mindiff);
    }
}
