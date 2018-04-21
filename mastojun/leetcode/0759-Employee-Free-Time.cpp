/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */

class Solution {
public:
    vector<Interval> employeeFreeTime(vector<vector<Interval>>& schedule) {
        vector<Interval> all_intervals;
        for (auto s : schedule) {
            all_intervals.insert(all_intervals.end(), s.begin(), s.end());
        }
        sort(all_intervals.begin(), all_intervals.end(),
             [](const Interval& l, const Interval& r) {
                if (l.start == r.start) return l.end < r.end;
                return l.start < r.start;
        });
        vector<Interval> result;
        Interval current = *all_intervals.begin();
        for (auto interval : all_intervals) {
            if (current.end >= interval.start) {
                current.end = max(current.end, interval.end);
            } else {
                result.push_back(Interval(current.end, interval.start));
                current = interval;
            }
        }
        
        return result;
        
    }
};
