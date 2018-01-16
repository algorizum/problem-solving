
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		if (nums.length < 1)
			return -1;
		return getIndex(nums, 0, nums.length - 1, target);
	}

	public int getIndex(int[] nums, int l, int r, int target) {
		int mid = (l + r) / 2;
		if (target == nums[mid])
			return mid;
        else if(r==l)return -1;
        
		if(nums[l]>nums[r]){
			if(target>=nums[l] ||target<=nums[r])return Math.max(getIndex(nums, l, mid, target), getIndex(nums, mid + 1, r, target));
        }else if(target>=nums[l] && target<nums[mid]){
            return getIndex(nums, l, mid, target);
        }else if(target>nums[mid] && target<=nums[r]) {
            return getIndex(nums, mid + 1, r, target);
        }
		return -1;
	}
}
