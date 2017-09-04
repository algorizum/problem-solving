class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1) return true;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp1 = nums[i + 1];
                int temp2 = nums[i];
                
                nums[i + 1] = temp2;
                boolean isOkay = true;
                for (int j = 0; j < n - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        isOkay = false;
                        break;
                    }
                }
                if (isOkay) {
                    return true;
                }
                isOkay = true;
                nums[i] = temp1;
                nums[i + 1] = temp1;
                for (int j = 0; j < n - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        isOkay = false;
                        break;
                    }
                }
                if (isOkay) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }
}
