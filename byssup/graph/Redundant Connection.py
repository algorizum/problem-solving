class Solution(object):
    def findRedundantConnection(self, edges):
        """
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        ans = None
        i = 0
        points = [-1 for _ in range(1001)]
        groups = [set() for _ in range(1001)]
        for edge in edges:
            head, tail = edge[0], edge[1]
            if points[head] == -1 and points[tail] == -1:
                points[head] = i
                points[tail] = i
                groups[i].add(head)
                groups[i].add(tail)
                i += 1
            else:
                if points[head] == points[tail]:
                    ans = edge
                elif points[head] != -1 and points[tail] == -1:
                    points[tail] = points[head]
                    groups[points[head]].add(tail)
                elif points[head] == -1 and points[tail] != -1:
                    points[head] = points[tail]
                    groups[points[tail]].add(head)
                else:
                    for point in groups[points[tail]]:
                        groups[points[head]].add(point)
                        points[point] = points[head]
        return ans

if __name__ == '__main__':
    sol = Solution()
    print sol.findRedundantConnection([[3,7],[1,4],[2,8],[1,6],[7,9],[6,10],[1,7],[2,3],[8,9],[5,9]])