class Solution {
        char[] operations = new char[]{'+','-','*','/'};
        public boolean judgePoint24(int[] nums) {
            int i;
            double[] newNums = new double[4];
            for (i = 0; i < 4; i++) {
                newNums[i] = nums[i];
            }
            return solve(newNums, 0);
        }

        public boolean solve(double[] nums, int depth) {
            int i, j, k, n = nums.length;
            if (depth == 3) {
                for (i = 0; i < 4; i++) {
                    if (Double.isInfinite(nums[i]) || Double.isNaN(nums[i]) || nums[i] == Double.MAX_VALUE) continue;
                    if (Math.abs(24l - nums[i]) < 0.0001) {
                        return true;
                    }
                }
                return false;
            }
            for (i = 0; i < n; i++) {
                if (nums[i] == Double.MAX_VALUE) continue;
                for (j = 0; j < n; j++) {
                    if (i == j || nums[j] == Double.MAX_VALUE) continue;
                    for (k = 0; k < 4; k++) {
                        double[] newNums = makeNewNums(nums, i, j, operations[k]);
                        if (solve(newNums, depth + 1)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public double[] makeNewNums(double[] nums, int i, int j, char type) {
            double[] newNums = nums.clone();

            if (type == '+') {
                newNums[i] += newNums[j];
            } else if (type == '-') {
                newNums[i] -= newNums[j];
            } else if (type == '*') {
                newNums[i] *= newNums[j];
            } else {
                newNums[i] /= newNums[j];
            }
            newNums[j] = Double.MAX_VALUE;

            return newNums;
        }
    }
