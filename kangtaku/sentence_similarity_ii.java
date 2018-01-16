class Solution {
    int[] parents, sizes, rank;
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        int pairLength = pairs.length, i, j, n = 0;
        Map<String, Integer> mp = new HashMap<>();
        
        for (i = 0; i < words1.length; i++) {
            if (!mp.containsKey(words1[i])) {
                mp.put(words1[i], n++);
            }
        }
        for (i = 0; i < words2.length; i++) {
            if (!mp.containsKey(words2[i])) {
                mp.put(words2[i], n++);
            }
        }
        
        for (String[] pair : pairs) {
            if (!mp.containsKey(pair[0])) {
                mp.put(pair[0], n++);
            }
            if (!mp.containsKey(pair[1])) {
                mp.put(pair[1], n++);
            }
        }
        
        parents = new int[mp.size()];
        rank = new int[mp.size()];
        
        for (i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        for (String[] pair : pairs) {
            if (mp.containsKey(pair[0]) && mp.containsKey(pair[1])) {
                int left = mp.get(pair[0]), right = mp.get(pair[1]);
                union(left, right);
            }
        }
        
        for (i = 0; i < words1.length; i++) {
            boolean isOkay = false;
            for (j = 0; j < words2.length; j++) {
                if (words2[j].equals("")) continue;
                int left = mp.get(words1[i]), right = mp.get(words2[j]);
                if (find(left) == find(right)) {
                    isOkay = true;
                    words1[i] = "";
                    words2[j] = "";
                    break;
                }
            }
            if (!isOkay) return false;
        }
        return true;
    }
    
    public int find(int p) {
        if (parents[p] == p) return p;
        else return parents[p] = find(parents[p]);
    }
    
    public void union(int left, int right) {
        left = find(left);
        right = find(right);
        if (rank[left] < rank[right]) {
            parents[left] = right;
        } else parents[right] = left;
        if (rank[left] == rank[right]) rank[left]++;
    }
}
