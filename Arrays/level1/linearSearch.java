public class linearSearch {

    public static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                return i;
            }

        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {3, 5, 2, 8, 10};
        int target = 8;

        System.out.println(linearSearch(arr, target));
    }
}