#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int n = arr.size(), i, idx, min = INT_MAX;
        for (i = 0; i < n; i++) {
            if (abs(arr[i] - x) < min) {
                min = abs(arr[i] - x);
                idx = i;
            }
        }
        int l = idx, r = idx;
        k--;
        while (k != 0) {
            if (l == 0) {
                r++;
            } else if (r == n - 1) {
                l--;
            } else {
                if (abs(arr[l - 1] - x) > abs(arr[r + 1] - x)) {
                    r++;
                } else if (abs(arr[l - 1] - x) <= abs(arr[r + 1] - x)) {
                    l--;
                }
            }
            k--;
        }
        vector<int> ans;
        for (i = l; i <= r; i++) {
            ans.push_back(arr[i]);
        }
        return ans;
    }
};

int main() {
    Solution solution;
    vector<int> inputArr;
    inputArr.push_back(1);
    inputArr.push_back(2);
    inputArr.push_back(3);
    inputArr.push_back(4);
    inputArr.push_back(5);
    solution.findClosestElements(inputArr, 4, 3);

}