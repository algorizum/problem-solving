from collections import defaultdict

class Solution(object):
    def topKFrequent(self, words, k):
        """
        :type words: List[str]
        :type k: int
        :rtype: List[str]
        """
        count_dict = defaultdict(lambda: 0)
        for word in words:
            count_dict[word] += 1
        count_items = count_dict.items()
        count_items.sort(lambda x, y: -cmp(x[1], y[1]) or cmp(x[0], y[0]))
        answer = [count_item[0] for count_item in count_items[:k]]
        return answer
