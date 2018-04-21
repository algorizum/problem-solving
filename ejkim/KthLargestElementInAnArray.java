import java.util.Arrays;
import java.util.Collections;

public class KthLargestElementInAnArray {
  public static int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    int cnt = 1;
    for( int i = nums.length - 1 ; i >= 0  ; i-- ) {
      if( cnt == k ) return nums[i];
      cnt++;
    }
    return 0;
  }
  public static void main(String[] args) {
    int[] num = {3, 2, 1, 5, 6, 4};
    int k = 2;
    int result = findKthLargest(num, k);
    System.out.println(result);
  }
}
