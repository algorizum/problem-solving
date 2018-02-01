public class LargestNumberAtLeastTwiceofOthers {
	
	/*two-pass
	 * public int dominantIndex(int[] nums) {
		int maxIdx=-1;
		
		for(int i=0;i<nums.length;i++) {
			if(maxIdx==-1 || max<nums[i]) 
				maxIdx=i;
			
		}
		for(int i=0;i<nums.length;i++) {
			if(i!=maxIdx && nums[i]*2>nums[maxIdx])return -1;
		}
		return maxIdx;
	}*/
	
	//one-pass
	public int dominantIndex(int[] nums) {
		int maxIdx=-1;
		int secIdx=-1;
		
		for(int i=0; i<nums.length;i++) {
			if(maxIdx<0 || nums[maxIdx]<=nums[i]) {
				secIdx=maxIdx;
				maxIdx=i;
			}else if(nums[i]*2>nums[maxIdx]) return -1;
		}
		if(secIdx>-1&& nums[secIdx]*2>nums[maxIdx]) return -1;
		return maxIdx;
	}
}
