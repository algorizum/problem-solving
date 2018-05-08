import java.util.AbstractMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map.Entry;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
    	int uglyNumbers[] = new int[n];
    	uglyNumbers[0] = 1;
        Queue<Entry<Integer, Integer>> candidate = new PriorityQueue<>( //prime, index
        		(a,b) -> (a.getKey() * uglyNumbers[a.getValue()]) - (b.getKey() * uglyNumbers[b.getValue()])); 
        for(int i = 0; i < primes.length; i++) {
        	candidate.add(new AbstractMap.SimpleEntry<>(primes[i], 0));
        }
        for(int i = 1; i < n; i++) {
        	Entry<Integer, Integer> uglyNumber = candidate.peek();
        	uglyNumbers[i] = uglyNumber.getKey() * uglyNumbers[uglyNumber.getValue()];
        	while(candidate.peek().getKey() * uglyNumbers[candidate.peek().getValue()] == uglyNumbers[i]) {
        		Entry<Integer, Integer> samllUglyNumber = candidate.poll();
        		candidate.add(new AbstractMap.SimpleEntry<>(samllUglyNumber.getKey(), samllUglyNumber.getValue()+1));
        	}
        }
        return uglyNumbers[n-1];
    }
    public static void main(String[] args) {
    	SuperUglyNumber solution = new SuperUglyNumber();
    	System.out.println(solution.nthSuperUglyNumber(12, new int[] {2,7,13,19})); //32
	}
}
