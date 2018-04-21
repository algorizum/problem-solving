import java.util.*;

public class MajorityElement2 {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();
		 Arrays.sort(nums);
		int cnt = 0;
		Integer prep = nums.length > 1 ? nums[0] : null;
		for (int n : nums) {
			if (n != prep) {
				if (cnt > nums.length / 3)
					result.add(prep);
				cnt = 0;
				prep = n;
			}
			cnt++;
		}
		if (prep!=null &&cnt > nums.length / 3)
			result.add(prep);
		return result;
	}

}
