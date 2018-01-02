import copy


class Solution(object):
    def cutOffTree(self, forest):
        """
        :type forest: List[List[int]]
        :rtype: int
        """
        pos_list = []
        distance_list = []
        for i, row in enumerate(forest):
            distance_list.append([])
            for j, col in enumerate(row):
                if col > 1:
                    pos_list.append((i, j, col))
                if col == 0:
                    distance_list[-1].append(-1)
                else:
                    distance_list[-1].append(99999)

        pos_list.sort(key=lambda item: item[2])
        pos_list.insert(0, (0, 0, 0))
        step = 0
        for i in range(len(pos_list) - 1):
            src, dest = pos_list[i], pos_list[i + 1]
            temp = self.get_distance(copy.deepcopy(distance_list), src)
            if temp[dest[0]][dest[1]] == 99999:
                return - 1
            step += temp[dest[0]][dest[1]]
        return step

    def get_distance(self, distance_list, pos):
        y_pos, x_pos, _ = pos
        distance_list[y_pos][x_pos] = 0
        height, width = len(distance_list), len(distance_list[0])
        cur_pos = set([(y_pos, x_pos)])
        while cur_pos:
            y_pos, x_pos = cur_pos.pop()
            if y_pos - 1 >= 0 and distance_list[y_pos - 1][x_pos] == 99999:
                distance_list[y_pos - 1][x_pos] = distance_list[y_pos][x_pos] + 1
                cur_pos.add((y_pos - 1, x_pos))

            if y_pos + 1 < height and distance_list[y_pos + 1][x_pos]== 99999:
                distance_list[y_pos + 1][x_pos] = distance_list[y_pos][x_pos] + 1
                cur_pos.add((y_pos + 1, x_pos))

            if x_pos - 1 >= 0 and distance_list[y_pos][x_pos - 1] == 99999:
                distance_list[y_pos][x_pos - 1] = distance_list[y_pos][x_pos] + 1
                cur_pos.add((y_pos, x_pos - 1))

            if x_pos + 1 < width and distance_list[y_pos][x_pos + 1] == 99999:
                distance_list[y_pos][x_pos + 1] = distance_list[y_pos][x_pos] + 1
                cur_pos.add((y_pos, x_pos + 1))
        return distance_list