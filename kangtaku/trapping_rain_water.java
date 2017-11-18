class Solution {
    public int trap(int[] height) {
        int i, n = height.length, max, ans = 0;
        int[] d1 = new int[n], d2 = new int[n];
        max = 0;
        for (i = 0; i < n; i++) {
            d1[i] = height[i];
            if (max < height[i]) max = height[i];
            else d1[i] = max;
        }
        max = 0;
        for (i = n - 1; i >= 0; i--) {
            d2[i] = height[i];
            if (max < height[i]) max = height[i];
            else d2[i] = max;
        }
        for (i = 0; i < n; i++) {
            ans += Math.min(d1[i], d2[i]) - height[i];
        }
        return ans;
    }
}
