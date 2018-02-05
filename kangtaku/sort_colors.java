class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length,lo=0,hi=n-1,idx=0,t;
        while(idx<=hi&&lo<hi){
            if(lo<idx&&nums[idx]==0){
                t=nums[idx];
                nums[idx]=nums[lo];
                nums[lo]=t;
                lo++;
            }else if(hi>idx&&nums[idx]==2){
                t=nums[idx];
                nums[idx]=nums[hi];
                nums[hi]=t;
                hi--;
            }else idx++;
        }
    }
}
