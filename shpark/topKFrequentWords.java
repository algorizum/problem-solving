class Solution {
    public List<String> topKFrequent(String[] words, int k) {

		int max = 0;
		Map<Integer, List<String>> appearFreq = new HashMap<>();

		Map<String, Integer> wordInfo = new HashMap<>();
		for (String w : words) {
			if (!wordInfo.containsKey(w)) {
				wordInfo.put(w, 0);
			}
			int freq = wordInfo.get(w);
			wordInfo.put(w, ++freq);
			max = Math.max(freq, max);
			if (!appearFreq.containsKey(freq)) {
				appearFreq.put(freq, new LinkedList<>());
			}
			if (appearFreq.get(freq - 1) != null && appearFreq.get(freq - 1).contains(w)) {
				appearFreq.get(freq - 1).remove(w);
			}
			appearFreq.get(freq).add(w);
		}
		List<String> result = new ArrayList<>();
		for (int i = max; k > 0; i--) {
			List<String> l = appearFreq.get(i);
			Collections.sort(l);
			for (String s : l) {
				result.add(s);
				k--;
				if (k <= 0)
					break;
			}
		}

		return result;
	}
}