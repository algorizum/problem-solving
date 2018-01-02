import java.util.*;

public class MergeIntervals {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

	public List<Interval> merge(List<Interval> intervals) {
		int[] starts=new int[intervals.size()];
		int[] ends=new int[intervals.size()];
		
		for(int i=0; i<intervals.size();i++){
			Interval interval=intervals.get(i);
			starts[i]=interval.start;
			ends[i]=interval.end;
		}
      
        Arrays.sort(starts);
		Arrays.sort(ends);
		
		List<Interval> result=new ArrayList<>();
		   
		for(int startIdx=0,endIdx=0; endIdx<ends.length;endIdx++){
			
			if(endIdx==ends.length-1||starts[endIdx+1]>ends[endIdx]){
				result.add(new Interval(starts[startIdx],ends[endIdx]));
				startIdx=endIdx+1;
			}

		}
		return result;
	
	}
}
