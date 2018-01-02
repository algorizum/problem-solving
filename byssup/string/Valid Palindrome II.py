class Solution(object):
    def validPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        i, j = self.get_idx(s)
        if i > j:
            return True
        ii, jj = self.get_idx(s[:i] + s[i+1:])
        if ii > jj:
            return True
        ii, jj = self.get_idx(s[:j] + s[j+1:])
        if ii > jj:
            return True
        return False

    def get_idx(self, s):
        i, j = 0, len(s) - 1
        while i <= j:
            if s[i] != s[j]:
                break
            i += 1
            j -= 1
        return i, j