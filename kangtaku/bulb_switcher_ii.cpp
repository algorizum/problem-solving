class Solution {
public:
    int flipLights(int n, int m) {
        int ans = 0;
        if (m == 0 || n == 0) ans = 1;
        else if (n == 1) ans = 2;
        else if (n == 2) ans = m == 1? 3:4;
        else if (m == 1) ans = 4;
        else ans = m == 2 ? 7 : 8;
        return ans;
    }
};
