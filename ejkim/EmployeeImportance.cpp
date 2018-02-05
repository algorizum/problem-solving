#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Employee {
public:
	int id;
	int importance;
	vector<int> subordinates;
	Employee(int id, int importance, vector<int> subordinates) {
		this->id = id;
		this->importance = importance;
		this->subordinates = subordinates;
	};
};

class Solution {
public:
	int getImportance(vector<Employee*> employees, int id) {
		int sum = 0;
		queue<int> subord;

		// 1. 가장 상위의 employee를 찾는다
		for (int i = 0; i < employees.size(); i++) {
			if (id == employees[i]->id) {
				sum += employees[i]->importance;
				for (int j = 0; j < employees[i]->subordinates.size(); j++) {
					subord.push(employees[i]->subordinates[j]);
				}
				break;
			}
		}
		
		// 2. 상위의 employee부터 하단의 employee의 importance를 차례로 찾아 더해준다
		while (subord.size() != 0) {
			for (int j = 0; j < employees.size(); j++) {
				if (subord.front() == employees[j]->id) {
					sum += employees[j]->importance;
					subord.pop();
					for (int k = 0; k < employees[j]->subordinates.size(); k++) {
						subord.push(employees[j]->subordinates[k]);
					}
					break;
				}
			}
		}
		return sum;
	}
};

int main() {
	Solution solution;
	vector<Employee*> employees = { new Employee(1, 5, {2, 3}), new Employee(2, 3, {}), new Employee(3, 3, {}) };
	int id = 1;
	cout << solution.getImportance(employees, id) << endl;
	return 0;
}