class MapSum {
    class Trie {
        Map<Character, Trie> childrens;
        boolean isTerminal;
        int val;
        Trie() {
            childrens = new HashMap<>();
            isTerminal = false;
            val = 0;
        }
    }
    
    Trie trie;

    /** Initialize your data structure here. */
    public MapSum() {
        trie = new Trie();
    }
    
    public void insert(String key, int val) {
        Trie cur = trie;
        int n = key.length(), i;
        for (i = 0; i < n; i++) {
            Character c = key.charAt(i);
            if (!cur.childrens.containsKey(c)) {
                cur.childrens.put(c, new Trie());
            }
            cur = cur.childrens.get(c);
        }
        cur.isTerminal = true;
        cur.val = val;
    }
    
    public int sum(String prefix) {
        Trie cur = trie;
        for (char c : prefix.toCharArray()) {
            if (cur.childrens.containsKey(c)) {
                cur = cur.childrens.get(c);
            } else {
                return 0;
            }
        }
        return findAll(cur);
    }
    
    public int findAll(Trie cur) {
        int sum = 0;
        for (Character c : cur.childrens.keySet()) {
            sum += findAll(cur.childrens.get(c));
        }
        return sum + cur.val;
    }
}
/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */