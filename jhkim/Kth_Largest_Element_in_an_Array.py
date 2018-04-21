import heapq

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        h = []
        for value in nums:
            heapq.heappush(h, 100000-value)
        
        for i in range(k):
            res = heapq.heappop(h)
        
        return 100000-res
