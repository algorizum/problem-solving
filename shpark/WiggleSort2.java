import java.util.*;

public class WiggleSort2 {
	public void wiggleSort(int[] nums) {
		int[] tmp=new int[nums.length];
		for(int i=0; i<nums.length;i++)tmp[i]=nums[i];
		
		Arrays.sort(tmp);
		int i=nums.length-1, j=(i/2);
		int idx=0;
		for(int t=j; i>t && j>=0;) {
			nums[idx++]=tmp[j--];
			nums[idx++]=tmp[i--];
		}
		if(j>-1)nums[idx]=tmp[j];
	}
}
