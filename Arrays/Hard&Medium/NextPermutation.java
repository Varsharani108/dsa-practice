package Arrays.level3;

public class NextPermutation {

    public static void nextPermutation(int[] arr) {

        int index = -1;
        int n = arr.length;

        // Step 1: Find the break point
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }

        // If no break point, reverse the whole array
        if (index == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        // Step 2: Find the next greater element and swap
        for (int i = n - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                swap(arr, i, index);
                break;
            }
        }

        // Step 3: Reverse the right half
        reverse(arr, index + 1, n - 1);
    }

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int start, int end) {

        while (start < end) {

            swap(arr, start, end);

            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 4, 3, 0, 0};

        nextPermutation(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}