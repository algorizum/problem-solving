import java.util.*;
public class KthSmallestPrimeFraction {
	public int[] kthSmallestPrimeFraction(int[] A, int K) {
		int n=A.length-1;
		PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				int v1=A[o1[0]]*A[o2[1]];
				int v2=A[o2[0]]*A[o1[1]];
				return v1-v2;
			}
		});
		for(int i=0; i<n;i++){
			pq.add(new int[]{i,n});
		}
		
		for(int i=0;i<K-1;i++){
			int[] tmp=pq.poll();
			if(tmp[1]-1>tmp[0]){
				tmp[1]--;
				pq.offer(tmp);
			}
		}
		int[] res=pq.peek();
		return new int[]{A[res[0]],A[res[1]]};
	}
}
