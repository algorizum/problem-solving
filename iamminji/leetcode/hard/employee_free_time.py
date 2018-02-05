# 759. Employee Free Time
# https://leetcode.com/problems/employee-free-time/description/


# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

    def __str__(self):
        return "start=%s, end=%s" % (self.start, self.end)


class Solution(object):
    def employeeFreeTime(self, schedule):
        """
        :type schedule: List[List[Interval]]
        :rtype: List[Interval]
        """

        sorted_schedule = list()
        for emp_list in schedule:
            for s in emp_list:
                sorted_schedule.append(s)

        sorted_schedule = sorted(sorted_schedule, key=lambda x: (x.start, -x.end))
        result = list()
        end_time = sorted_schedule[0].end
        for idx in range(1, len(sorted_schedule)):
            if end_time >= sorted_schedule[idx].end:
                continue
            if end_time < sorted_schedule[idx].start:
                result.append(Interval(end_time, sorted_schedule[idx].start))
            end_time = sorted_schedule[idx].end

        return result


if __name__ == "__main__":
    """
    Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
    Output: [[5,6],[7,9]]
    """

    emp1 = [Interval(1, 3), Interval(6, 7)]
    emp3 = [Interval(2, 5), Interval(9, 12)]
    emp2 = [Interval(2, 4)]

    sol = Solution()
    res = sol.employeeFreeTime([emp1, emp2, emp3])
    for r in res:
        print r

    """
    Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
    Output: [[3,4]]
    """

    emp1 = [Interval(1, 2), Interval(5, 6)]
    emp3 = [Interval(1, 3)]
    emp2 = [Interval(4, 10)]

    sol = Solution()
    res = sol.employeeFreeTime([emp1, emp2, emp3])
    for r in res:
        print r
