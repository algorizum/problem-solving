class Solution(object):
    def findComplement(self, num):
        """
        :type num: int
        :rtype: int
        """


        for n in range(1,33):
            if pow(2, n) - 1>= num:
                return num ^ pow(2, n) - 1