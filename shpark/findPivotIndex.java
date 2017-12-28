
public class findPivotIndex {
	public int pivotIndex(int[] nums) {
		int left=0,right=0;
		for(int n:nums)right+=n;
		
		for(int i=0; i<nums.length;i++){
			right-=nums[i];
			if(left==right) return i;
			//else if(left>right)return -1;
			else{
				left+=nums[i];
			}
		}
		
		return -1;
	}
}
