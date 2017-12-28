/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
bool func(const Interval& lhs, const Interval& rhs) {
    return lhs.start < rhs.start;
}
class Solution {
public:
    vector<Interval> merge(vector<Interval>& intervals) {
        if (intervals.size() == 0) return {};
        sort(intervals.begin(), intervals.end(), func);
        vector<Interval> result;
        result.push_back(intervals[0]);
        for (auto& interval : intervals) {
            if (result.back().end >= interval.start) {
                result.back().end = max(result.back().end, interval.end);
            } else {
                result.push_back(interval);
            }
        }
        return result;
    }
};
