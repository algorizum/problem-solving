# 187. Repeated DNA Sequences
# https://leetcode.com/problems/repeated-dna-sequences/description/

from collections import defaultdict


class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """

        idx = 0
        result = list()
        words = defaultdict(int)
        while idx <= len(s) - 10:
            words[s[idx:idx + 10]] += 1
            idx += 1

        for key, val in words.items():
            if val >= 2:
                result.append(key)
        return result


if __name__ == "__main__":
    # python2
    sol = Solution()
    print sol.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")
    print sol.findRepeatedDnaSequences("ACCCCCCCCCC")
    print sol.findRepeatedDnaSequences("AAAAAAAAAAA")
    print sol.findRepeatedDnaSequences("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC")
