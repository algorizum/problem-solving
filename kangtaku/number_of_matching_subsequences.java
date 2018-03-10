class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        char[] s = S.toCharArray();
        int n = s.length;
        TreeSet<Integer>[] mp = new TreeSet[26];
        Set<String> has = new HashSet<>();
        Set<String> nohas = new HashSet<>();
        int ans = 0, i, j;
        for(i=0;i<26;i++)mp[i]=new TreeSet<>();
        for(i = 0; i < n; i++) {
            mp[s[i] - 'a'].add(i);
        }
        for (String word : words) {
            if (has.contains(word)) {
                ans++;
                continue;
            }
            if (nohas.contains(word)) {
                continue;
            }
            int idx = -1;
            boolean isOkay = true;
            for (char c : word.toCharArray()) {
                int cIdx = c-'a';
                Integer next = mp[cIdx].higher(idx);
                if (next == null) {
                    isOkay=false;
                    break;
                }
                idx = next;
            }
            if(isOkay) {
                has.add(word);
                ans++;
            } else {
                nohas.add(word);
            }
        }
        
        return ans;
    }
}
