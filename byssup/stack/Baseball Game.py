class Solution(object):
    def calPoints(self, ops):
        """
        :type ops: List[str]
        :rtype: int
        """
        total = 0
        points = []
        for op in ops:
            if op == 'C':
                last = points.pop()
                total -= last
            elif op == 'D':
                total += points[-1] * 2
                points.append(points[-1] * 2)
            elif op == '+':
                total += points[-1] + points[-2]
            else:
                total += int(op)
                points.append(int(op))
        return total