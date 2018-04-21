public class MaxChunksToMakeSorted {
	public int maxChunksToSorted(int[] arr) {
		int right=0;
		int maxChunks=0;
		for(int i=0; i<arr.length;) {
			int left=i;
			for(;left<=right;left++) {
				if(arr[left]>right)
					right=arr[left];
			}
			i=left;
			right++;
			maxChunks++;
		}
		return maxChunks;
	}
}
