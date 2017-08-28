public class Solution {
  boolean isPossible(int[] nums) {
    boolean ans = true;
    Map<Integer, Integer> numMp = new HashMap<>();
    Map<Integer, Integer> lastNumMp = new HashMap<>();
    for (int num : nums) {
      numMp.put(num, numMp.getOrDefault(num,0) + 1);
    }
    for (int num : nums) {
      if (numMp.get(num) > 0) {
        numMp.put(num, numMp.get(num) - 1);
        if (lastNumMp.getOrDefault(num - 1, 0)  > 0) {
          lastNumMp.put(num - 1, lastNumMp.get(num - 1) - 1);
          lastNumMp.put(num, lastNumMp.getOrDefault(num, 0) + 1);
        } else if (numMp.getOrDefault(num + 1, 0) > 0
            && numMp.getOrDefault(num + 2, 0) > 0) {
          numMp.put(num + 1, numMp.get(num + 1) - 1);
          numMp.put(num + 2, numMp.get(num + 2) - 1);
          lastNumMp.put(num + 2, lastNumMp.getOrDefault(num + 2, 0) + 1);
        } else {
          ans = false;
          break;
        }
      }
    }
    return ans;
  }
}
