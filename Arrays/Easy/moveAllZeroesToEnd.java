public class moveAllZeroesToEnd {
    public static void moveZeroes(int[] arr) {
        int i = -1;

        for (int k = 0; k < arr.length; k++) {
            if (arr[k] == 0) {
                i = k;
                break;
            }
        }
        for (int j = i+1; j < arr.length; j++) {
            if (arr[j] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 0, 3, 12 };

        moveZeroes(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
