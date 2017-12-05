class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> dq = new LinkedList<>();
        for (int ast : asteroids) {
            if (ast > 0) {
                if (dq.size() == 0 || dq.getLast() > 0 || dq.getLast() < 0) {
                    dq.add(ast);
                }
            } else {
                if (dq.size() == 0 || dq.getLast() < 0) {
                    dq.add(ast);
                } else {
                    while(dq.size() != 0) {
                        int lastAst = dq.getLast();
                        if (lastAst < 0 && ast < 0) {
                            break;
                        } else if (lastAst < ast * -1) {
                            dq.pollLast();
                        } else if (lastAst > ast * -1) { 
                            ast = 0;
                            break;
                        } else if (lastAst == ast * -1) {
                            ast = 0;
                            dq.pollLast();
                            break;
                        }
                    }
                    if (ast != 0) dq.add(ast);
                }
            }
        }
        int ansSize = dq.size();
        int[] ans = new int[ansSize];
        for (int i = 0; i < ansSize; i++) {
            ans[i] = dq.pollFirst();
        }
        return ans;
    }
}
