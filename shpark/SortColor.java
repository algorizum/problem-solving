
public class SortColor {
	public void sortColors(int[] nums) {
		int[] colorCnt = new int[3];
		for (int n : nums)
			colorCnt[n]++;
		int i = 0;
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < colorCnt[j]; k++, i++)
				nums[i] = j;
		}
	}
}
