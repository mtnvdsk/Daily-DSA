import java.util.*;

class Solution {
    public static String frequencySort(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        HashMap<Character, Integer> positionMap = new HashMap<>();
        int n=s.length();
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);

            if (frequencyMap.containsKey(currentChar)) {
                frequencyMap.put(currentChar, frequencyMap.get(currentChar) + 1);
            } else {
                frequencyMap.put(currentChar, 1);
                positionMap.put(currentChar, i);
            }
        }
        Character[] charArray = new Character[n];
        for (int i = 0; i < n; i++) {
            charArray[i] = s.charAt(i);
        }
        Arrays.sort(charArray, new Comparator<Character>() {
            public int compare(Character c, Character d) {
                int f1 = frequencyMap.get(c);
                int f2 = frequencyMap.get(d);

                if (f1 != f2) {
                    return f2 - f1;
                } else {
                    return positionMap.get(c) - positionMap.get(d);
                }
            }
        });
        StringBuilder result = new StringBuilder();
        for (Character character : charArray) {
            result.append(character);
        }
        return result.toString();
    }
}