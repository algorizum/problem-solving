
public class EmployeeFreeTime {

	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<Interval>result=new ArrayList<>();
		Map<Integer,Integer> employeeTimes=new TreeMap<>();
		
		for(List<Interval> s:schedule){
			for(Interval i:s){
				int endTime=i.end;
				if(employeeTimes.containsKey(i.start)){
					endTime=Math.max(endTime, employeeTimes.get(i.start));
				}
				employeeTimes.put(i.start, endTime);
			}
		}
		int start=Integer.MAX_VALUE;
		int end=0;
		for(int startTime:employeeTimes.keySet()){
			start=Math.min(start, startTime);
			if(start!=startTime &&startTime>end){
				result.add(new Interval(end,startTime));
				start=startTime;
			}
			end=Math.max(end, employeeTimes.get(startTime));
			
		}
		return result;
	}
}
