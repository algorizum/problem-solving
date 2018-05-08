class Solution:
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        sums = [0]
        exist_cnt = dict()
        exist_cnt[0] = 1
        all_cnt = 0
        
        for i in range(len(nums)):
            sums.append(sums[-1] + nums[i])
            
            if sums[-1]-k in exist_cnt:
                all_cnt += exist_cnt[sums[-1]-k]
                
            if sums[-1] in exist_cnt:
                exist_cnt[sums[-1]] += 1
            else:
                exist_cnt[sums[-1]] = 1
                
        return all_cnt
