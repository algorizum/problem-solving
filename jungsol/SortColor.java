import java.util.Arrays;

@SuppressWarnings("unused")
public class SortColor {
    public void sortColors(int[] nums) {
    	int lo = 0, hi = nums.length-1, index = 0;
    	while(hi >= index) {
    		if(nums[index] == 0) {
    			swap(nums, index++, lo++);
    		} else if(nums[index] == 2) {
    			swap(nums, index, hi--);
    		} else {
    			index++;
    		}
    	}
//        System.out.println(Arrays.toString(nums));
    }
    
    private void swap(int[] arr, int i, int j) {
    	int tmp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = tmp;
    }
}
