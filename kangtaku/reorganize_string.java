
class Solution {
    public String reorganizeString(String S) {
        int i, n = S.length(), extra;
        int[] cnt=new int[26];
        char[] cs = S.toCharArray();
        for (char c : cs) cnt[c - 'a']++;
        PriorityQueue<P> pq = new PriorityQueue<>((x, y) -> y.cnt - x.cnt);
        for (i = 0; i < 26; i++){
            if (cnt[i] != 0) pq.add(new P((char)('a'+i),cnt[i]));
        }
        P top = pq.poll();
        extra = n - top.cnt;
        if (top.cnt - 1 > n - top.cnt) return "";
        StringBuilder sb=new StringBuilder();
        while(sb.length() != S.length()){
            sb.append(String.valueOf(top.c));
            top.cnt--;
            while (!pq.isEmpty()) {
                if (pq.peek().c == sb.charAt(sb.length() - 1)) break;
                P now = pq.poll();
                sb.append(String.valueOf(now.c));
                now.cnt--;
                extra--;
                if (now.cnt != 0) pq.add(now);
                if (top.cnt > extra) break;
            }
        }
        return sb.toString();
    }
}

class P {
    char c;int cnt; P(char c,int cnt) {this.c=c;this.cnt=cnt;}
}
