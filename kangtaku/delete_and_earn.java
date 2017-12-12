class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;
        HashMap<Integer, Integer> bucket = new HashMap<>();
        int min = 99999999, max = -1, ans = -1;
        for (int num : nums) {
            int cnt = bucket.getOrDefault(num, 0);
            bucket.put(num, cnt + 1);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] d = new int[max + 1];
        for (int i = min; i <= max; i++) {
            if (bucket.containsKey(i)) {
                d[i] = bucket.get(i) * i;
                if (i > 2) {
                    d[i] += Math.max(d[i - 2], d[i - 3]);
                } else if (i > 1) d[i] += d[i - 2];
                d[i] = Math.max(d[i - 1], d[i]);
            } else d[i] = d[i - 1];
            ans = Math.max(d[i], ans);
        }
        return d[max];
    }
}
