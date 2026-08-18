package Arrays.level3;

public class RearrangeArrayBySign {

    public static int[] rearrange(int[] arr) {

        int[] ans = new int[arr.length];

        int posIndex = 0;
        int negIndex = 1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > 0) {
                ans[posIndex] = arr[i];
                posIndex += 2;
            } else {
                ans[negIndex] = arr[i];
                negIndex += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {3,1,-2,-5,2,-4};

        int[] ans = rearrange(arr);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}