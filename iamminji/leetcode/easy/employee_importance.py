# 690. Employee Importance
# https://leetcode.com/problems/employee-importance/description/


"""
# Employee info
class Employee:
    def __init__(self, id, importance, subordinates):
        # It's the unique id of each node.
        # unique id of this employee
        self.id = id
        # the importance value of this employee
        self.importance = importance
        # the id of direct subordinates
        self.subordinates = subordinates
"""


class Solution:
    def helper(self, visited, subs, employees):
        res = 0
        if not subs:
            return res

        for sub_id in subs:
            if sub_id in visited:
                return visited[sub_id]

            for emp in employees:
                if emp.id == sub_id:
                    res += emp.importance + self.helper(visited, emp.subordinates, employees)
                    visited[sub_id] = res
        return res

    def getImportance(self, employees, id):
        """
        :type employees: Employee
        :type id: int
        :rtype: int
        """
        visited = dict()
        res = 0
        for emp in employees:
            if emp.id == id:
                visited[emp.id] = True
                res = emp.importance + self.helper(visited, emp.subordinates, employees)
        return res
