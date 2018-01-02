import java.util.*;
public class topKFrequentElements347 {
	 public List<Integer> topKFrequent(int[] nums, int k) {
			Map<Integer,Integer> freq=new HashMap<>();

			int maxfreq=Integer.MIN_VALUE;
			for(int num:nums){
				if(freq.containsKey(num)){
					freq.put(num, freq.get(num)+1);
				}else{
					freq.put(num, 1);
				}
			}
			Map<Integer,List<Integer>> elements=new HashMap<>();
			for(int val:freq.keySet()){
				int key=freq.get(val);
				maxfreq=Math.max(maxfreq, key);
				if(!elements.containsKey(key)){
					elements.put(key, new ArrayList<>());
				}
				elements.get(key).add(val);
			}
			List<Integer> res=new ArrayList<>();
			while(true){
	           if(elements.containsKey(maxfreq)){
				for(int n:elements.get(maxfreq)){
					res.add(n);
	                k--;
					if(k<=0)return res;
				}}
				maxfreq--;
			}
			
		}
}
