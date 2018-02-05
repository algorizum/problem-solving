#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int minCostClimbingStairs(vector<int>& cost) {
	if (cost.size() == 2) {
		return min(cost[0], cost[1]);
	}
	vector<int> d(cost.size());
	d[0] = cost[0];
	d[1] = cost[1];
	for (int i = 2; i < cost.size(); i++) {
		d[i] = min(cost[i] + d[i-1], cost[i] + d[i-2]);
	}
	return min(d[cost.size() - 1], d[cost.size() - 2]);
}

int main() {
	vector<int> v = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
	cout << minCostClimbingStairs(v) << endl;
	return 0;
}