class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0)return -1;
        int n=nums.length,lo=0,hi=n-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==target)return mid;
            if(nums[0]>nums[n-1]&&target<=nums[n-1]&&nums[n-1]<=nums[mid])lo=mid+1;
            else if(nums[0]>nums[n-1]&&target>=nums[0]&&nums[n-1]>=nums[mid])hi=mid-1;
            else if(nums[mid]>target)hi=mid-1;
            else if(nums[mid]<target)lo=mid+1;
        }
        return -1;
    }
}
