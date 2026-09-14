package Recursion.Basics;

public class LastOccurence {

    public static int Occurence(int[] arr, int key, int i) {

        if (i == arr.length) {
            return -1;
        }

        int isFound = Occurence(arr, key, i + 1);

        if (isFound != -1) {
            return isFound;
        }

        if (arr[i] == key) {
            return i;
        }

        return -1;
    }

    public static void main(String args[]) {

        int arr[] = {3, 2, 4, 2, 4, 5, 7, 6, 7, 8};

        System.out.println(Occurence(arr, 2, 0));
    }
}