public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
    	if(nums.length == 0) return -1;
    	int lo = 0, hi = nums.length-1;
    	while(lo < hi) {
    		int mid = (hi-lo) / 2 + lo;
    		if(nums[lo] <= nums[mid]) {
    			if(nums[lo] <= target && nums[mid] >= target) {
    				hi = mid;
    			} else {
    				lo = mid+1;
    			}
    		} else {
    			if(nums[mid] < target && nums[lo] > target) {
    				lo = mid+1;
    			} else {
    				hi = mid;
    			}
    		}
    	}
    	return (nums[lo] == target) ? lo : -1;
    }
}
