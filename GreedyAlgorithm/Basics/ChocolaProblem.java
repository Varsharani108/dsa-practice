package GreedyAlgorithm.Basics;

import java.util.*;

public class ChocolaProblem {

    public static void main(String[] args) {

        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costHor[] = {4, 1, 2};

        // Descending order
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0;
        int v = 0;

        int hp = 1; // horizontal pieces
        int vp = 1; // vertical pieces

        int cost = 0;

        while (h < costHor.length && v < costVer.length) {

            if (costVer[v] >= costHor[h]) {

                // Vertical cut
                cost += costVer[v] * hp;
                vp++;
                v++;

            } else {

                // Horizontal cut
                cost += costHor[h] * vp;
                hp++;
                h++;
            }
        }

        // Remaining horizontal cuts
        while (h < costHor.length) {
            cost += costHor[h] * vp;
            hp++;
            h++;
        }

        // Remaining vertical cuts
        while (v < costVer.length) {
            cost += costVer[v] * hp;
            vp++;
            v++;
        }

        System.out.println("Minimum cost = " + cost);
    }
}