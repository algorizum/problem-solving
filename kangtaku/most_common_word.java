class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> mp = new HashMap<>();
        for (String ban : banned) {
            mp.put(ban.toLowerCase(), -1);
        }
        char[] cs = paragraph.toCharArray();
        int n = cs.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(cs[i])) {
                sb.append(cs[i]);
            } else if (sb.length() != 0) {
                String key = sb.toString().toLowerCase();
                int v = mp.getOrDefault(key, 0);
                if (v != -1) {
                    mp.put(key, v + 1);
                }
                sb.setLength(0);
            }
        }
        if (sb.length() != 0) {
            String key = sb.toString().toLowerCase();
            int v = mp.getOrDefault(key, 0);
            mp.put(key, v + 1);
        }
        String ans = "";
        int max = -1;
        for (String k : mp.keySet()) {
            // System.out.println(k + ", " + mp.get(k));
            if (mp.get(k) > max) {
                max = mp.get(k);
                ans = k;
            }
        }
        return ans;
    }
}
