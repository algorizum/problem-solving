class Solution(object):
    def kthGrammar(self, N, K):
        """
        :type N: int
        :type K: int
        :rtype: int
        """
        if N==1:
            return 0
        
        cur_len = 2**(N-1)
        if K < cur_len/2+1:
            return self.kthGrammar(N-1, K)
        else:
            return 1-self.kthGrammar(N-1, K-int(cur_len/2))
