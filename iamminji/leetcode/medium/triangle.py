# 120. Triangle
# https://leetcode.com/problems/triangle/description/


class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """

        arr = triangle[-1]

        length = len(triangle[-1])
        if length == 1:
            return triangle[0][0]
        elif length == 2:
            return min(triangle[0][0] + triangle[1][1], triangle[0][0] + triangle[1][0])

        for idx in range(len(triangle) - 2, -1, -1):
            sub = triangle[idx]
            jdx = 0
            while jdx < length - 1:
                if jdx == 0:
                    arr[jdx] = min(sub[jdx] + arr[jdx], sub[jdx] + arr[jdx + 1])
                    jdx += 1
                    continue
                arr[jdx - 1] = min(sub[jdx - 1] + arr[jdx], arr[jdx - 1])
                arr[jdx] = min(sub[jdx] + arr[jdx], sub[jdx] + arr[jdx + 1])
                jdx += 1
            length = len(sub)

        return arr[0]


if __name__ == "__main__":
    sol = Solution()
    print sol.minimumTotal([[-1], [2, 3], [1, -1, -3]])
