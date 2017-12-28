class Solution {
    final static int SIZE = 26;
    String LAST = "";
    Map<String, Integer> cache = new HashMap<>();
    int n, m;
    String[] stickerKeys;
    
    public int minStickers(String[] stickers, String target) {
        String targetKey = "";
        n = stickers.length;
        int i, j;
        int[] count = new int[SIZE];
        stickerKeys = new String[n];
        for (char c : target.toCharArray()) {
            count[c - 'a']++;
        }
        for (i = 0; i < SIZE; i++) {
            if (count[i] != 0) {
                targetKey += String.valueOf(to16(count[i]));
            }
        }
        m = targetKey.length();
        for (i = 0; i < m; i++) {
            LAST += "0";
        }
        for (i = 0; i < n; i++) {
            String sticker = stickers[i];
            String stickerKey = "";
            int[] check = new int[SIZE];
            for (char c : sticker.toCharArray()) {
                if (count[c - 'a'] != 0) check[c - 'a']++;
            }
            for (j = 0; j < SIZE; j++) {
                if (count[j] > 0) {
                    stickerKey += String.valueOf(to16(check[j]));
                }
            }
            stickerKeys[i] = stickerKey;
        }
        return sol(targetKey);
    }
    
    public int sol(String target) {
        Queue<Target> q = new LinkedList<>();
        q.add(new Target(target, 0));
        
        while (!q.isEmpty()) {
            Target now = q.poll();
            for (int i = 0; i < n; i++) {
                String newTarget = "";
                String sticker = stickerKeys[i];
                for (int j = 0; j < sticker.length(); j++) {
                    if (to10(sticker.charAt(j)) == '0') {
                        newTarget += now.target.charAt(j);
                    } else {
                        newTarget += to16(now.target.charAt(j) - sticker.charAt(j));
                    }
                }
                if (newTarget.equals(now) || cache.containsKey(newTarget)) {
                    continue;
                }
                if (newTarget.equals(LAST)) return now.count + 1;
                cache.put(newTarget, now.count + 1);
                q.add(new Target(newTarget, now.count + 1));
            }
        }
        return -1;
    }
    
    public int to10(char c) {
        if (c >= 'a') return (int)(c - 'a') + 10;
        return (int)c - '0';
    }
    
    public char to16(int num) {
        if (num < 0) return '0';
        if (num > 9) return (char)(num - 10 + 'a');
        return (char)(num + '0');
    }
}

class Target {
    String target;
    int count;
    Target(String target, int count) {this.target = target; this.count = count;}
}
