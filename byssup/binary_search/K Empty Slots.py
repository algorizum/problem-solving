import bisect


class Solution(object):
    def kEmptySlots(self, flowers, k):
        """
        :type flowers: List[int]
        :type k: int
        :rtype: int
        """
        pos_list = []
        for i, pos in enumerate(flowers):
            if not pos_list:
                pos_list.append(pos)
            else:
                j = bisect.bisect_left(pos_list, pos)
                if j == 0:
                    if pos_list[0] - pos - 1 == k:
                        return i + 1
                elif j == len(pos_list):
                    if pos - pos_list[-1] - 1 == k:
                        return i + 1
                elif pos - pos_list[j - 1] - 1 == k or pos_list[j] - pos - 1 == k:
                    return i + 1
                pos_list.insert(j, pos)
        return -1
