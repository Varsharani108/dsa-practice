import java.util.ArrayList;

public class unionTwoSortedArr {
    public static ArrayList<Integer> union(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != arr1[i])
                    ans.add(arr1[i]);
                i++;

            } else if (arr1[i] > arr2[j]) {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != arr2[j])
                    ans.add(arr2[j]);
                j++;

            } else {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != arr2[j])
                    ans.add(arr2[j]);
                j++;
                i++;

            }

        }
        while (i < arr1.length) {
            
            if (ans.size() == 0 || ans.get(ans.size() - 1) != arr1[i])
                ans.add(arr1[i]);
                i++;
        }

        while (j < arr2.length) {
            if (ans.size() == 0 || ans.get(ans.size() - 1) != arr2[j])
                ans.add(arr2[j]);
                j++;

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = { 4, 4, 7 };
        int[] arr2 = { 3, 6, 8, 9, 10 };
        ArrayList<Integer> result = union(arr1, arr2);

        System.out.println(result);

    }

}
