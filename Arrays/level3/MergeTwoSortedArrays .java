package Arrays.level3;

public class MergeTwoSortedArrays {

    public static void merge(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int m = arr2.length;

        int gap = (n + m + 1) / 2;

        while (gap > 0) {

            int left = 0;
            int right = left + gap;

            while (right < n + m) {

                // Both elements are in arr1
                if (left < n && right < n) {

                    if (arr1[left] > arr1[right]) {
                        swap(arr1, left, arr1, right);
                    }
                }

                // One element in arr1, one in arr2
                else if (left < n && right >= n) {

                    if (arr1[left] > arr2[right - n]) {
                        swap(arr1, left, arr2, right - n);
                    }
                }

                // Both elements are in arr2
                else {

                    if (arr2[left - n] > arr2[right - n]) {
                        swap(arr2, left - n, arr2, right - n);
                    }
                }

                left++;
                right++;
            }

            if (gap == 1) {
                gap = 0;
            } else {
                gap = (gap + 1) / 2;
            }
        }
    }

    public static void swap(
            int[] arr1, int index1,
            int[] arr2, int index2) {

        int temp = arr1[index1];
        arr1[index1] = arr2[index2];
        arr2[index2] = temp;
    }

    public static void printArray(int[] arr) {

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 4, 8, 10};
        int[] arr2 = {2, 3, 9};

        merge(arr1, arr2);

        printArray(arr1);
        printArray(arr2);
    }
}