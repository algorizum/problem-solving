# 773. Sliding Puzzle
# https://leetcode.com/problems/sliding-puzzle/description/

from queue import Queue
from copy import deepcopy


class Solution:
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    def get_key(self, board):
        return "".join([str(_) for _ in board[0]]) + "".join([str(_) for _ in board[1]])

    def swap_zero_status(self, board):

        new_board_list = list()

        x, y = -1, -1

        for i in range(2):
            find = False
            for j in range(3):
                if board[i][j] == 0:
                    x = j
                    y = i
                    find = True
                    break
            if find:
                break

        for d1, d2 in self.directions:
            new_board = deepcopy(board)
            if 0 <= d1 + x < 3 and 0 <= d2 + y < 2:
                new_board[d2 + y][d1 + x], new_board[y][x] = new_board[y][x], new_board[d2 + y][d1 + x]
                new_board_list.append(new_board)

        return new_board_list

    def slidingPuzzle(self, board):
        """
        :type board: List[List[int]]
        :rtype: int
        """
        queue = Queue()
        move = dict()
        key = self.get_key(board)
        move[key] = 0

        queue.put(board)
        while not queue.empty():
            board = queue.get()
            k = self.get_key(board)
            if k == "123450":
                break
            new_board_list = self.swap_zero_status(board)
            for nb in new_board_list:
                key = self.get_key(nb)
                if key not in move:
                    queue.put(nb)
                    move[key] = move[k] + 1
        return move.get("123450", -1)
