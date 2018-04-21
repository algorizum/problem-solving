import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KthLargestElement {
	private int ll,rr;
	public void sort(int[] arr,int l, int r,int n) {
		if(l>=r)return;
		ll=rr=-1;
		partition(arr,l,r);
		
		if(n<ll && n>l)sort(arr,l,ll,n);
		else if(n>=rr && n<=r)sort(arr,rr,r,n);
	}
	public void partition(int[] arr,int l,int r) {
		if(r-l<=1) {
			if(arr[r]<arr[l])swap(arr,r,l);
			ll=l;
			rr=r;
			return;
		}
		int m=l;
		int pivot=arr[r];
		while(m<=r) {
			if(arr[m]<pivot) {
				swap(arr,l++,m++);
			}else if(arr[m]==pivot)m++;
			else swap(arr,m,r--);
		}
		
		//update ll and rr
		ll=l-1;
		rr=m;
	}
	public void swap(int[] arr, int i, int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	public int findKthLargest(int[] nums, int k) {
		/*Arrays.sort(nums);
		return nums[nums.length-k];
		*/
		sort(nums,0,nums.length-1,nums.length-k);
		return nums[nums.length-k];
	}
	@Test
	public void test() {
		assertEquals(5,new KthLargestElement().findKthLargest(new int[] {3,2,1,5,6,4}, 2));
	}
}
