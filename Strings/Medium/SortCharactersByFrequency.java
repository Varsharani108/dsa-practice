package Strings.Medium;

import java.util.*;

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {

        // Count frequency of each character
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Store characters in a list
        List<Character> characters = new ArrayList<>(map.keySet());

        // Sort characters by frequency (highest first)
        characters.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder result = new StringBuilder();

        // Add each character according to its frequency
        for (char ch : characters) {

            int frequency = map.get(ch);

            for (int i = 0; i < frequency; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "tree";

        System.out.println(frequencySort(s));
    }
}