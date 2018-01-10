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
    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> all=new ArrayList<>();
        for(List<Interval> avail:avails){
            for(Interval in:avail){
                all.add(in);
            }
        }
        all.sort((x,y)->{
            if(x.start!=y.start){
                return x.start-y.start;
            }else if(x.end!=y.end){
                return x.end-y.end;
            }
            return 0;
        });
        int start=all.get(0).start,end=all.get(0).end;
        List<Interval> ans=new ArrayList<>();
        for(int i=1;i<all.size();i++){
            Interval in=all.get(i);
            if(end<in.start){
                ans.add(new Interval(end,in.start));
                start=in.start;
                end=in.end;
            }else{
                end=Math.max(end,in.end);
            }
        }
        return ans;
    }
}
