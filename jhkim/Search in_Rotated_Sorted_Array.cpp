class Solution {
public:
    int search(vector<int>& nums, int target) {
        int start = 0;
        int end = nums.size()-1;
        int mid = 0;
                
        while(true) {
            if(end<start)
                return -1;
            
            mid = (end+start)/2;
            
            if(nums[mid]==target)
                return mid;
            else if(nums[start]<nums[mid]) {
                if(start!=mid && nums[start]<=target && nums[mid-1]>=target)
                    end = mid-1;
                else
                    start = mid+1;
            }
            else {
                if(mid!=end && nums[mid+1]<=target && nums[end]>=target)
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
    }
};
