class Solution {
public:
    int monotoneIncreasingDigits(int N) {
        string s = to_string(N);
        int p = 1;
        while (p < s.length() && s[p - 1] <= s[p]) p++;
        if (p >= s.length()) return N;
        while (p > 0 && s[p - 1] > s[p] - 1) p--;
        s[p++]--;
        while (p < s.length()) s[p++] = '9';
        
        return stoi(s);
    }
};
