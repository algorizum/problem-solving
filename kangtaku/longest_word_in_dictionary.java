class Solution {
    public String longestWord(String[] words) {
        HashSet<String> st = new HashSet<>();
        for (String word : words) {
            st.add(word);
        }
        Arrays.sort(words, (x, y) -> {
            if (y.length() == x.length()) {
                return x.compareTo(y);
            }
            
            return y.length() - x.length();
        });
        for (String word : words) {
            boolean isAns = true;
            String newWord = "";
            for (int i = 0; i < word.length(); i++) {
                newWord += word.charAt(i);
                if (!st.contains(newWord)) {
                    isAns = false;
                    break;
                }
            }
            if (isAns) return word;
        }
        return "";
    }
}
