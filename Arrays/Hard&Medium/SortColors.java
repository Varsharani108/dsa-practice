package Arrays.level3;

public class SortColors {

    public static void sortColors(int[] arr) {

        // Count 0, 1 and 2
        int zero = 0;
        int one = 0;
        int two = 0;

        // Step 1: Count
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                zero++;
            }
            else if(arr[i]==1){
                one++;
            }
            else{
                two++;
            }
        }

        // Step 2: Fill 0s
        int index = 0;

while (zero > 0) {
    arr[index] = 0;
    index++;
    zero--;
}

        // Step 3: Fill 1s
        

while (one > 0) {
    arr[index] = 1;
    index++;
    one--;
}

        // Step 4: Fill 2s
        

while (two > 0) {
    arr[index] = 2;
    index++;
    two--;
}

    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {

        int[] arr = {2, 0, 2, 1, 1, 0};

        sortColors(arr);

        printArray(arr);
    }
}