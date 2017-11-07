"""
# Employee info
class Employee(object):
    def __init__(self, id, importance, subordinates):
        # It's the unique id of each node.
        # unique id of this employee
        self.id = id
        # the importance value of this employee
        self.importance = importance
        # the id of direct subordinates
        self.subordinates = subordinates
"""


class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: Employee
        :type id: int
        :rtype: int
        """
        temp = [0] * 2001
        for emp in employees:
            temp[emp.id] = (emp.importance, emp.subordinates)
        return self.get_imp(temp, id)

    def get_imp(self, employess, id):
        if not employess[id][1]:
            return employess[id][0]

        imp = employess[id][0]
        for sub_id in employess[id][1]:
            imp += self.get_imp(employess, sub_id)
        return imp