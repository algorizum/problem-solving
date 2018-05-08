# 731. My Calendar II
# https://leetcode.com/problems/my-calendar-ii/description/


class MyCalendarTwo:
    def __init__(self):
        self.double_booked = list()
        self.schedule = list()

    def book(self, start, end):
        """
        :type start: int
        :type end: int
        :rtype: bool
        """
        for s, e in self.double_booked:
            if start < e and end > s:
                return False

        # check if already booked
        for s, e in self.schedule:
            if start < e and end > s:
                self.double_booked.append((max(start, s), min(end, e)))

        self.schedule.append((start, end))
        return True
