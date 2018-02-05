#include <iostream>
#include <vector>
using namespace std;
bool isPalindrome(int x) {
	if (x < 0) return false;
	vector<int> v;
	while (x > 0) {
		int n = x % 10;
		v.push_back(n);
		x /= 10;
	}
	//bool odd = (v.size() % 2 == 1) ? true : false;
	int half = v.size() / 2;
	int begin = 0;
	int end = v.size() - 1;
	int cnt = 0;
	for (int i = 0; i < half; i++) {
		if (v[begin + i] == v[end - i]) {
			cnt++;
		}
	}
	return (cnt == half) ? true : false;
}
int main() {
	cout << isPalindrome(1) << endl;
	return 0;
}