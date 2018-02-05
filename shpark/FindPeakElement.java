public class FindPeakElement {
	public int findPeakElement(int[] nums){
		return helper(nums,0,nums.length-1);
	}
	public int helper(int[] nums, int r, int l){
		if(l-r<2)return nums[r]>nums[l]?r:l;
		int max=0;
		int target=(l-r)/2+r;
		if(nums[target-1]<nums[target] && nums[target+1]<nums[target]){
			max=nums[max]<nums[target]?target:max;
		}else{
			int rIdx=helper(nums,r,target);
			int lIdx=helper(nums,target,l);
			int subMax=nums[rIdx]>nums[lIdx]?rIdx:lIdx;
			max=nums[max]>nums[subMax]?max:subMax;
		}
		return max;
	}
}
