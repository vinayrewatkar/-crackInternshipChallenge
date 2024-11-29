class Solution {
    public String reverseWords(String s) {
        // Trim leading and trailing spaces and split by spaces
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        // Traverse the array of words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
