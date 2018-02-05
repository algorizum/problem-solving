class Solution {
    int n;
    private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }

    public void wiggleSort(int[] nums) {
        // shuffle(nums);
        n = nums.length;
        
        int left = 0, right = n - 1, kth = n / 2, t;
        if (n < 2) return;
        while (kth != right) {
            int i = left + 1, lt = left, gt = right, pivot = nums[left];
            while (i <= gt) {
                if (nums[i] < pivot) {
                    swap(nums, i++, lt++);
                } else if (nums[i] > pivot) {
                    swap(nums, i, gt--);
                } else i++;
            }
            
            if (kth == gt) break;
            else if (kth > gt) left = gt + 1;
            else right = gt - 1;
        }
        // for(int nu:nums)System.out.print(nu + " ");
        int i = 0, v = nums[kth];
        left = 0;
        right = n - 1;
        // System.out.println(v);
        while (i <= right) {
            if (nums[I(i)] > v) {
                swap(nums, I(i++), I(left++));
            } else if (nums[I(i)] < v) {
                swap(nums, I(i), I(right--));
            } else i++;
        }
    }
    
    private int I(int idx) {
        return ((idx * 2) + 1) % (n | 1);
    }
    
    private void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}
