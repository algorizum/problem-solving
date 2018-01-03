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

	// 1. �ܾ�� �󵵼� ����
	for (int i = 0; i < words.size(); i++) {
		if (m.find(words[i]) != m.end()) {	// map�� ������ ���
			m[words[i]]++;
		}
		else {
			m.insert(make_pair(words[i], 1));
		}
	}

	// 2. �󵵼� ���� ���� (��������)
	// => ���� �󵵼��� ��� ���������� ����
	for (auto it = m.begin(); it != m.end(); it++) {
		tmpM.insert(make_pair(it->second, it->first));
	}

	// 3. k �� ��ŭ �ܾ� ��� (����������)
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