class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> dq = new LinkedList<>();
        for (int ast : asteroids) {
            while(dq.size() != 0 && ast < 0 && dq.getLast() > 0) {
                int lastAst = dq.getLast();
                if (lastAst < ast * -1) {
                    dq.pollLast();
                } else if (lastAst > ast * -1) { 
                    ast = 0;
                } else if (lastAst == ast * -1) {
                    ast = 0;
                    dq.pollLast();
                }
            }
            if (ast != 0) dq.add(ast);
        }
        int ansSize = dq.size();
        int[] ans = new int[ansSize];
        for (int i = 0; i < ansSize; i++) {
            ans[i] = dq.pollFirst();
        }
        return ans;
    }
}
