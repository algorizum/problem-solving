#include <iostream>
#include <vector>
#include <map>
#include <string>
#include <algorithm>
#include <functional>
using namespace std;

vector<string> topKFrequent(vector<string>& words, int k) {
	vector<string> result;
	map<string, int> m;
	multimap<int, string, greater<int>> tmpM;

	// 1. 단어별로 빈도수 조사
	for (int i = 0; i < words.size(); i++) {
		if (m.find(words[i]) != m.end()) {	// map에 존재할 경우
			m[words[i]]++;
		}
		else {
			m.insert(make_pair(words[i], 1));
		}
	}

	// 2. 빈도수 별로 정렬 (내림차순)
	// => 같은 빈도수일 경우 사전순으로 정렬
	for (auto it = m.begin(); it != m.end(); it++) {
		tmpM.insert(make_pair(it->second, it->first));
	}

	// 3. k 개 만큼 단어 출력 (사전순으로)
	int cnt = 0;
	for (auto it = tmpM.begin(); it != tmpM.end(); it++) {
		if (cnt == k) break;
		result.push_back(it->second);
		cnt++;
	}

	return result;
}
int main() {
	vector<string> v = { "i", "love", "leetcode", "i", "love", "coding" };
	int k = 2;
	vector<string> r = topKFrequent(v, k);
	for (int i = 0; i < r.size(); i++) {
		cout << r[i] << " ";
	}
}