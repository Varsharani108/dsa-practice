package Arrays.level3;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public static List<Integer> majorityElement(int[] arr) {

        int n = arr.length;

        int ele1 = 0;
        int ele2 = 0;

        int cnt1 = 0;
        int cnt2 = 0;

        // Step 1: Find candidates
        for (int num : arr) {

            if (cnt1 == 0 && num != ele2) {
                ele1 = num;
                cnt1 = 1;
            }
            else if (cnt2 == 0 && num != ele1) {
                ele2 = num;
                cnt2 = 1;
            }
            else if (num == ele1) {
                cnt1++;
            }
            else if (num == ele2) {
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }

        // Step 2: Verify candidates
        cnt1 = 0;
        cnt2 = 0;

        for (int num : arr) {

            if (num == ele1) {
                cnt1++;
            }

            if (num == ele2) {
                cnt2++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if (cnt1 > n / 3) {
            ans.add(ele1);
        }

        if (cnt2 > n / 3) {
            ans.add(ele2);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 2, 1, 1};

        System.out.println(majorityElement(arr));
    }
}