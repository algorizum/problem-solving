
public class ReachANumber {
	public int reachNumber(int target) {
		int even=target%2==0?1:-1;
		int flag=1;
		int max=0;
		for(int i=0; ;i++){
			max+=i;
			if(flag==even && Math.abs(target)<max)return i;
			if(i%2==0)flag*=-1;
		}
	}
}
