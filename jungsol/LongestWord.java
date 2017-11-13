import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWord {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> check = new HashSet<>();
        String longestWord = "";
        for(String word : words) {
            if(word.length() == 1 || check.contains(word.substring(0, word.length()-1))) {
                check.add(word);
                if(longestWord.length() < word.length()) {
                    longestWord = word;
                }
            }
        }
        return longestWord;
    }
	public static void main(String[] args) {
		LongestWord solution = new LongestWord();
		System.out.println(solution.longestWord(new String[]{"w","wo","wor","worl", "world"})); //world
	}
}
