package Recursion.Basics;

public class mergeSort {

    public static void divide(int arr[], int si, int ei) {

        // base case
        if (si >= ei) {
            return;
        }

        // middle
        int mid = si + (ei - si) / 2;

        // left part
        divide(arr, si, mid);

        // right part
        divide(arr, mid + 1, ei);

        // merge both sorted parts
        conquer(arr, si, mid, ei);
    }

    public static void conquer(int arr[], int si, int mid, int ei) {

        int merged[] = new int[ei - si + 1];

        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;

        // compare elements from both parts
        while (idx1 <= mid && idx2 <= ei) {

            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        // remaining elements of left part
        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        // remaining elements of right part
        while (idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        // copy merged array back
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void main(String args[]) {

        int arr[] = {6, 3, 9, 5, 2, 8};

        divide(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}