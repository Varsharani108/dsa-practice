package Arrays.level3;

public class StockBuyAndSell {

    public static int maxProfit(int[] arr) {

        int minPrice = arr[0];
        int maxProfit = 0;

        for (int i = 1; i < arr.length; i++) {

            int profit = arr[i] - minPrice;

            maxProfit = Math.max(maxProfit, profit);

            minPrice = Math.min(minPrice, arr[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] arr = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(arr));
    }
}