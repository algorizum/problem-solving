
public class MaxChunksToMakeSorted {
	public int maxChunksToSorted(int[] arr) {
		int maxChunks=0;
		int max=Integer.MIN_VALUE;
		for(int i=0; i<arr.length;){
			max=Math.max(max, arr[i]);
			if(arr[i]!=i){
				int tmp=arr[i];
				arr[i]=arr[tmp];
				arr[tmp]=tmp;
			}else{
				if(arr[i]==max)	maxChunks++;
				i++;
			}
		}
		return maxChunks;
	}
}
