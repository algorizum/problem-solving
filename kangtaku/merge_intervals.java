/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if (intervals.size() == 0) return ans;
        Collections.sort(intervals, (x, y) -> {
            if (x.start != y.start) return x.start - y.start;
            // if (x.end != y.end) return x.end - y.end;
            return 0;
        });
        
        Interval interval = intervals.get(0);
        int n = intervals.size(), start = interval.start, end = interval.end;
        for (int i = 1; i < n; i++) {
            interval = intervals.get(i);
            if (end < interval.start) {
                ans.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            } else {
                end = Math.max(end, interval.end);
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }
}
