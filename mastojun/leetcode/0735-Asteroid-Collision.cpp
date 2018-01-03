class Solution {
public:
  vector<int> asteroidCollision(vector<int>& asteroids) {
    vector<int> result;
    int idx = 0;
    while (idx < asteroids.size()) {
      int num = asteroids[idx];
      if (result.empty() || *result.rbegin() < 0 || *result.rbegin() * num > 0) result.push_back(num);
      else if (*result.rbegin() + num == 0) result.pop_back();
      else if (*result.rbegin() + num < 0) {
        result.pop_back(); continue;
      }
      idx++;
    }
    return result;
  }
};
