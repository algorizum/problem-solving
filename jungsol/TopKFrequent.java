import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map.Entry;

public class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
    	Map<String,Integer> wordCounter = new HashMap<>();
        Queue<Entry<String, Integer>> sortedWords = new PriorityQueue<>(
        		(a,b) -> ((b.getValue() - a.getValue() == 0) 
        				? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()));
        for(String word : words) {
        	wordCounter.put(word, wordCounter.getOrDefault(word, 0)+1);
        }
        
        for(Entry<String, Integer> entry : wordCounter.entrySet()) {
        	sortedWords.add(entry);
        	if(sortedWords.size() > k) {
        		sortedWords.poll();
        	}
        }
        List<String> topKFrequentList = new ArrayList<>();
        while(!sortedWords.isEmpty()) {
            topKFrequentList.add(0, sortedWords.poll().getKey());
        }
        return topKFrequentList;
    }
    
    public static void main(String[] args) {
    	TopKFrequent solution = new TopKFrequent();
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"}; // i love
        List<String> result1 = solution.topKFrequent(words1, 2);
        for(String str : result1) {
            System.out.print(str + " ");
        }
    }
}
