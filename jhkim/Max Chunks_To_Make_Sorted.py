class Solution(object):
    def maxChunksToSorted(self, arr):
        return self.maxChuckRecur(arr, 0)
        
    def maxChuckRecur(self, arr, start):
        """
        :type arr: List[int]
        :rtype: int
        """
        if len(arr)==0:
            return 0
        
        max_val = -1
        for i in range(len(arr)):
            if arr[i]-start > max_val:
                max_val = arr[i]-start
            
            if max_val==i:
                return self.maxChuckRecur(arr[i+1:], start+i+1)+1
            
        return 0
