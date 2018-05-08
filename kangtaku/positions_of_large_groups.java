class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        S = S + "@";
        char[] cs = S.toCharArray();
        int cnt = 1;
        char now = cs[0];
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] != now) {
                if (cnt > 2) {
                    List<Integer> group = new ArrayList<>();
                    group.add(i - cnt);
                    group.add(i - 1);
                    ans.add(group);
                }
                cnt = 1;
                now = cs[i];
            } else {
                cnt++;
            }
        }
        return ans;
    }
}
