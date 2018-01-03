#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

vector<int> topKFrequent(vector<int>& nums, int k) {
	// 1. 각 숫자의 빈도수를 찾음
	map<int, int> m;
	int maxVal = 0;
	for (int i = 0; i < nums.size(); i++) {
		m[nums[i]]++;
		maxVal = max(maxVal, m[nums[i]]);
	}
	cout << "max = " << maxVal << endl;
	// 2. 빈도수 별로 각 index를 저장
	vector<vector<int>> freq(maxVal+1, vector<int>(0));
	for (auto it = m.begin(); it != m.end(); it++) {
		freq[it->second].push_back(it->first);
	}
	// 3. k개만큼 찾음
	vector<int> result;
	for (int i = freq.size()-1; i >= 0; i--) {
		for (int j = 0; j < freq[i].size(); j++) {
			result.push_back(freq[i][j]);
			if (result.size() == k)
				return result;
		}
	}
	return result;
}
int main() {
	vector<int> v = {1, 1, 1, 2, 2, 3};
	int k = 2;
	vector<int> r =	topKFrequent(v, 2);
	for (int i = 0; i < r.size(); i++)
		cout << r[i] << " ";
	cout << endl;
	return 0;
}
