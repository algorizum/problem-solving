class Solution(object):
    def judgeCircle(self, moves):
        """
        :type moves: str
        :rtype: bool
        """
        x_pos, y_pos = 0, 0
        for c in moves:
            if c == 'R':
                x_pos += 1
            elif c == 'L':
                x_pos -= 1
            elif c == 'U':
                y_pos += 1
            else:
                y_pos -= 1
            if x_pos == 0 and y_pos == 0:
                return True
        return False