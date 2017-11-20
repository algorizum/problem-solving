
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> mp = new HashMap<>();
        HashMap<Integer, Set<String>> mps = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        for (String word : words) {
            Integer v = mp.getOrDefault(word, 0);
            mp.put(word, v + 1);
        }
        for (String key : mp.keySet()) {
            Integer value = mp.get(key);
            Set<String> st = mps.getOrDefault(value, new TreeSet<>());
            st.add(key);
            mps.put(value, st);
        }
        
        ArrayList<Integer> counts = new ArrayList<Integer>(mps.keySet());
        for (int i = counts.size() - 1; i >= 0; i--) {
            Set<String> st = mps.get(counts.get(i));
            for (String an : st) {
                ans.add(an);
                k--;
                if (k == 0) {
                    return ans;
                }
            }
        }
        return ans;
    }
}
