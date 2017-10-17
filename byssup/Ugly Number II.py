class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        total = set([1])
        pre = set([1])

        while len(total) < 10000:
            temp = set()
            while pre:
                element = pre.pop()
                temp.add(element * 2 )
                temp.add(element * 3 )
                temp.add(element * 5 )
            total |= temp
            pre = temp
        total = list(total)
        total.sort()
        return total[n-1]