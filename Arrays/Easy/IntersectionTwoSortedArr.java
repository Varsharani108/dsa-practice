import java.util.ArrayList;

public class IntersectionTwoSortedArr {
    
    public static ArrayList<Integer> Intersection (int[] arr1, int[] arr2){
        int i=0,j=0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<arr1.length && j< arr2.length){
            if(arr1[i]<arr2[j]){
                i++;
            }
            else if (arr1[i] > arr2[j]  ) {
                j++;

            } else {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != arr2[j])
                    ans.add(arr2[j]);
                j++;
                i++;

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = { 4, 4, 7 };
        int[] arr2 = { 3, 4, 7, 9, 10 };
        ArrayList<Integer> result = Intersection(arr1, arr2);

        System.out.println(result);

    }
}
