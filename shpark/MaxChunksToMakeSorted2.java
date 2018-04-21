
import java.util.Stack;


public class MaxChunksToMakeSorted2 {
	public int maxChunksToSorted(int[] arr) {
		Stack<Integer>maxs=new Stack<>();
		Stack<Integer>mins=new Stack<>();
		
		for(int a:arr) {
			if(maxs.isEmpty() || a>=maxs.peek()) {
				maxs.push(a);
				mins.push(a);
			}else if(a<mins.peek()) {
				int max=maxs.peek();
				int min=a;
				while(!mins.isEmpty() && (mins.peek()>a || a<maxs.peek())) {
					maxs.pop();
					min=Math.min(min, mins.pop());
				}
				maxs.push(max);
				mins.push(min);
			}
		}
		return maxs.size();
	}
}
