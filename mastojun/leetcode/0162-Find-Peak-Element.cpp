class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        return peak(nums, 0, nums.size() - 1);
    }
private:
    int peak(vector<int>& nums, int left, int right) {
        if (left == right) return left;
        int mid = (left + right) / 2;
        if (nums[mid] >= nums[mid + 1]) return peak(nums, left, mid);
        return peak(nums, mid + 1, right);
    }
};
