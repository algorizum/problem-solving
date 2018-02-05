class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        nn = [n for n in str(num)]
        for i, n in enumerate(nn):
            if not nn[i+1:]:
                continue

            max_val = max(nn[i+1:])
            if max_val > n:
                j = str(num).rfind(max_val)
                temp = nn[i]
                nn[i] = nn[j]
                nn[j] = temp
                return int(''.join(nn))
        return num