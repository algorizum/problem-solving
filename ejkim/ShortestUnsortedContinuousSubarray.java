import java.util.Arrays;

/*
*  https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
*
*  ex1.
*  Input: [2,6,4,8,10,9,15]
*  Output: 5
*
*  ex2.
*  Input: [1,3,2,2,2]
*  Output: 4
* */

public class ShortestUnsortedContinuousSubarray {
  public int findUnsortedSubarray(int[] nums) {
    int begin = -1, end = -1;
    int len = nums.length;
    int[] tmp = new int[len];
    // 1. nums와 같은 배열을 copy해 오름차순으로 정렬
    System.arraycopy( nums, 0, tmp, 0, len );
    Arrays.sort(tmp);
    // 2. nums와 tmp를 비교해 다른값일경우 sorting된 경우이므로 그 길이 체크
    for( int i = 0 ; i < len ; i++ ) {
      if( tmp[i] != nums[i] ) {
        if( begin == -1 ) {
          begin = i;
        } else {
          end = i;
        }
      }
    }
    return (begin == end) ? 0 : (end - begin + 1);
  }
  public static void main(String[] args) {
    int[] nums = {2, 6, 4, 8, 10, 9, 15};
    ShortestUnsortedContinuousSubarray shortestUnsortedContinuousSubarray = new ShortestUnsortedContinuousSubarray();
    System.out.println(shortestUnsortedContinuousSubarray.findUnsortedSubarray(nums));
  }
}
