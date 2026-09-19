package ArrayList;

import java.util.ArrayList;

public class containerWithMostWater {

    public static int maxWater(ArrayList<Integer> height) {

        int lp = 0;
        int rp = height.size() - 1;

        int maxWater = 0;

        while (lp < rp) {

            int width = rp - lp;
            int ht = Math.min(height.get(lp), height.get(rp));

            int currWater = width * ht;

            maxWater = Math.max(maxWater, currWater);

            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {

        ArrayList<Integer> height = new ArrayList<>();

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(maxWater(height));
    }
}
