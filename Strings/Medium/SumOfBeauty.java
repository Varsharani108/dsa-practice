package Strings.Medium;

public class SumOfBeauty {

    public static int beautySum(String s) {

        int totalBeauty = 0;

        for (int i = 0; i < s.length(); i++) {

            int[] frequency = new int[26];

            for (int j = i; j < s.length(); j++) {

                char ch = s.charAt(j);

                frequency[ch - 'a']++;

                int maxFrequency = 0;
                int minFrequency = Integer.MAX_VALUE;

                // Find max and min frequency
                for (int k = 0; k < 26; k++) {

                    if (frequency[k] > 0) {

                        maxFrequency = Math.max(
                                maxFrequency,
                                frequency[k]
                        );

                        minFrequency = Math.min(
                                minFrequency,
                                frequency[k]
                        );
                    }
                }

                totalBeauty += maxFrequency - minFrequency;
            }
        }

        return totalBeauty;
    }

    public static void main(String[] args) {

        String s = "aabcb";

        System.out.println(beautySum(s));
    }
}