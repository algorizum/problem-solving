#include <iostream>
#include <string>
using namespace std;

int compareString(string A, string B, int loop) {
	int result = -1;
	string compVal1 = "";
	string compVal2 = "";
	for (int i = 0; i < loop; i++) {
		if (i < loop - 1)
			compVal1 += A;
		compVal2 += A;
	}
	result = (compVal1.find(B) != string::npos) ? loop - 1 : (compVal2.find(B) != string::npos ? loop : -1);
	return result;
}
int repeatedStringMatch(string A, string B) {
	if ( A.length() >= B.length() ) {	// A�� A'������ ���캽

	} else {
		if ( B.find(A) != string::npos ) {
			int loop = B.length() / A.length() + 1;
			return compareString(A, B, loop);
		} else {	// B�ȿ� A�� ���Ե������� ���
			return -1;
		}
	}
	return -1;
}
int main() {
	string a = "abcd";
	string b = "cdabcdab";
	cout << repeatedStringMatch(a, b) << endl;
	return 0;
}