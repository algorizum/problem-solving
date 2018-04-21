import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morses = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> uniqueMorseRepresentationSet = new HashSet<>();
        for(String word : words) {
        	StringBuilder morseRepresentation = new StringBuilder();
        	for(char c : word.toCharArray()) {
        		morseRepresentation.append(morses[c-'a']);
        	}
        	uniqueMorseRepresentationSet.add(morseRepresentation.toString());
        }
        return uniqueMorseRepresentationSet.size();
    }
    public static void main(String[] args) {
    	UniqueMorseCodeWords solution = new UniqueMorseCodeWords();
		System.out.println(solution.uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"})); //2
	}
}
