class MyCalendar {

	private List<Integer> startlist;
	private List<Integer> endlist;
	public MyCalendar() {
		startlist=new LinkedList<>();
		endlist=new LinkedList<>();
	}

	public boolean book(int start, int end) {
		
		int i=Collections.binarySearch(startlist, start);
		int j=Collections.binarySearch(endlist, end);
			
		if(i>=0 || i!=j) return false;
		
		i=(i*-1)-1;
		j=(j*-1)-1;
		
		if(i<1 || start>=endlist.get(i-1)){
            if(endlist.size()>i && endlist.get(i)>end && startlist.get(i)<end)return false;
			startlist.add(i, start);
			endlist.add(j, end);
			return true;
		}
		return false;
	}
}