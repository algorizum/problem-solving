class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length, i;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (i = 0; i < n; i++) {
            while (st.size() != 0 && temperatures[st.peek()] < temperatures[i]) {
                int befIdx = st.pop();
                ans[befIdx] = i - befIdx;
            }
            st.push(i);
        }
        return ans;
    }
}
