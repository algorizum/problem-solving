class Solution {
    int[] cache = new int[1 << 16 + 1];
    int allUse;
    int goal;
    int n;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int i;
        n = nums.length;
        for (i = 0; i < n; i++) {
            sum += nums[i];
        }
        
        if (sum % k != 0) return false;
        
        allUse = (1 << n) - 1;
        goal = sum / k;
        
        return canMake(nums, 0, 0) > 0;
    }
    
    public int canMake(int[] nums, int used, int sum) {
        if (used == allUse) {
            return 1;
        }
        
        if (cache[used] != 0) {
            return cache[used];
        }
        
        int i, n = nums.length;
        int ans = -1;
        for (i = 0; i < n; i++) {
            if ((used & (1 << i)) == 0 && sum + nums[i] <= goal) {
                used |= (1 << i);
                if (sum + nums[i] == goal) {
                    ans = Math.max(ans, canMake(nums, used, 0));
                } else {
                    ans = Math.max(ans, canMake(nums, used, sum + nums[i]));
                }
                if (ans == 1) {
                    return 1;
                }
                used = used & ~(1 << i);
            }
        }
        cache[used] = ans;
        return ans;
    }
}
