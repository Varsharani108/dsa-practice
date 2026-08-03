package Arrays.level3;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {

    public static ArrayList<Integer> leaders(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();

        int maxi = Integer.MIN_VALUE;

        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] >= maxi) {
                ans.add(arr[i]);
                maxi = arr[i];
            }
        }

        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {10,22,12,3,0,6};

        System.out.println(leaders(arr));
    }
}