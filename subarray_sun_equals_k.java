class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int now = 0, i, ans = 0;
        mp.put(0, 1);
        for (int num : nums) {
            now += num;
            if (mp.containsKey(now - k)) {
                ans += mp.get(now - k);
            }
            int v = mp.getOrDefault(now, 0);
            mp.put(now, v + 1);
        }
        return ans;
    }
}
