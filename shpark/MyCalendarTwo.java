import java.util.*;


public class MyCalendarTwo {
	private List<Integer> starts;
	private List<Integer> ends;
	public MyCalendarTwo() {
		starts=new ArrayList<>();
		ends=new ArrayList<>();
	}
	public boolean isDuplicate(int left, int right, int start,int end) {
		//start-end가 left,right와 겹치는 부분이 있다면 true를 리턴!
		if((left>=start && left<end)||(left<=start && right>start))return true;
		return false;
	}
	public boolean book(int start, int end) {
	    int lastStart=Integer.MAX_VALUE,lastEnd=Integer.MIN_VALUE;
		for(int i=0; i<starts.size();i++) {
			int curStart=starts.get(i);
			int curEnd=ends.get(i);
			if(curStart>=end) break;
			
			if(isDuplicate(curStart,curEnd,start,end)) {
				if(isDuplicate(lastStart,lastEnd,curStart,curEnd))return false;
				else {lastStart=curStart;lastEnd=curEnd;}
			}
		}
		int idx=Collections.binarySearch(starts, start);
		idx=idx<0?-idx-1:idx;
		starts.add(idx,start);
		ends.add(idx,end);
		return true;
	}
}