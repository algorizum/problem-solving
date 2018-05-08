# 347. Top K Frequent Elements
# https://leetcode.com/problems/top-k-frequent-elements/description/

from collections import defaultdict


class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """

        my_map = defaultdict(list)
        count_dict = defaultdict(int)

        max_count = -1

        for num in nums:
            count_dict[num] += 1

        for num, count in count_dict.items():
            max_count = max(count, max_count)
            my_map[count].append(num)

        result = list()

        while k > 0 and max_count > 0:
            if max_count not in my_map:
                max_count -= 1
                continue

            for num in my_map[max_count]:
                result.append(num)
                k -= 1
            max_count -= 1

        return result


if __name__ == "__main__":
    sol = Solution()
    print sol.topKFrequent([1, 1, 1, 2, 2, 3], 2)
