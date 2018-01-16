class MyCalendar {
    TreeMap<Integer, Integer> tm;
    public MyCalendar() {
        tm = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer p = tm.floorKey(start);
        Integer n = tm.ceilingKey(start);
        System.out.println(p + ", " + n);
        if ((p == null || tm.get(p) <= start) && (n == null || end <= n)) {
            tm.put(start, end);
            return true;
        }
        return false;
    }
}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
