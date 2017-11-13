class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        prev_total_row = triangle[0]
        for row in triangle[1:]:
            cur_total_row = [99999 for _ in row]
            for i, num in enumerate(row):
                if i == 0:
                    cur_total_row[0] = prev_total_row[0] + num
                elif i == len(row) - 1:
                    cur_total_row[-1] = prev_total_row[-1] + num
                else:
                    cur_total_row[i] = min(prev_total_row[i - 1] + num, prev_total_row[i] + num)
            prev_total_row = cur_total_row
        return min(prev_total_row)

if __name__ == '__main__':
    solution = Solution()
    print solution.minimumTotal([[2], [3,4], [6,5,7],[4,1,8,3]])