class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        int x = 0, y = 0, z = 0;
        for (int i = 1; i < n; i++) {
            int nextNum = Math.min(nums.get(x) * 2, Math.min(nums.get(y) * 3, nums.get(z) * 5));
            nums.add(nextNum);
            if (nextNum == nums.get(x) * 2) x++;
            if (nextNum == nums.get(y) * 3) y++;
            if (nextNum == nums.get(z) * 5) z++;
        }
        return nums.get(nums.size() - 1);
    }
}