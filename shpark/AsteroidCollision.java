import java.util.*;

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
		//List<Integer> res=new LinkedList<>();
		int[] res=new int[asteroids.length];
		int idx=-1;
		for(int a:asteroids){
			if(idx<0 || res[idx]<0)res[++idx]=a;
			else{
				if(a>0)res[++idx]=a;
				else{
					while(true){
						if(idx<0 || res[idx]<0){res[++idx]=a;break;}
						
						int absIdx=Math.abs(res[idx]);
						if(Math.abs(a)==absIdx) {idx--;break;}
						else if(Math.abs(a)>absIdx) {idx--;}
						else if(Math.abs(a)<absIdx) break;			
					}
				}
			}
		}
		res=Arrays.copyOf(res, idx+1);
		return res;
	}
}
