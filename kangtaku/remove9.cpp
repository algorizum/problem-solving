#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int newInteger(int n) {
        int i, ans = 0, jari = 1, t;
        while (n > 8) {
            t = n % 9;
            n /= 9;
            ans += (jari * t);
            jari *= 10;
        }
        ans += jari * n;
        return ans;
    }
};

int main() {
    Solution solution;
    vector<pair<int, int> > inputArr;

    inputArr.push_back(make_pair(9, 10));
    inputArr.push_back(make_pair(10, 11));

    for (int i = 0; i < inputArr.size(); i++) {
        pair<int, int> input = inputArr[i];
        
        int actual = solution.newInteger(input.first);
        int expected = input.second;
        if (actual == expected) {
            cout << "corrected" << endl;
        }
    }
    cout << solution.newInteger(9);
    return 0;
}