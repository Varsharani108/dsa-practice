public class SecondLargestElement {

    public static int secondLargest(int[] arr) {

        int lar = Integer.MIN_VALUE;
        int seclar = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {

            if(arr[i] > lar) {
                seclar = lar;
                lar = arr[i];
            }
            else if(arr[i] > seclar && arr[i] != lar) {
                seclar = arr[i];
            }
        }

        return seclar;
    }

    public static void main(String[] args) {

        int[] arr = {12,2,45,32,23,6};

        System.out.println("Second largest element : " + secondLargest(arr));
    }
}