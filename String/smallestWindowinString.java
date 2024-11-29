import java.util.HashMap;

class Solution {
    // Function to find the smallest window in the string s1 consisting
    // of all the characters of string s2.
    public static String smallestWindow(String s1, String s2) {
        // Your code here
        HashMap<Character, Integer> map = new HashMap<>();

        // Populate the map with the frequency of characters in s2
        for (int i = 0; i < s2.length(); i++) {
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) + 1);
        }

        int n = s1.length();
        int i = 0, j = 0; // Pointers for sliding window
        int minLength = Integer.MAX_VALUE; // To track the minimum length
        int count = map.size(); // Track the number of distinct characters to match
        String result = "-1"; // Final result string

        while (j < n) {
            char endChar = s1.charAt(j);

            // If the character exists in s2, reduce its frequency in the map
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) {
                    count--; // Character is completely matched
                }
            }

            // When all characters are matched, try shrinking the window
            while (count == 0) {
                // Update result if the current window is smaller
                if (j - i + 1 < minLength) {
                    minLength = j - i + 1;
                    result = s1.substring(i, j + 1);
                }

                // Remove the start character from the window
                char startChar = s1.charAt(i);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0) {
                        count++; // A character is now unmatched
                    }
                }
                i++; // Shrink the window from the left
            }
            j++; // Expand the window from the right
        }

        return result;
    }
}
