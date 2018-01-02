class Solution(object):
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """

        def get_count(i, j, s):
            count, left, right = 0, i, j
            while left >= 0 and right < len(s) and s[left] == s[right]:
                count += 1
                left -= 1
                right += 1
            return count

        count = 0
        for i in range(len(s)):
            count += get_count(i, i, s)
            count += get_count(i, i + 1, s)
        return count