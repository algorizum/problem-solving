class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Ele> pq = new PriorityQueue<>((x, y) -> x.val - y.val);
        int[] nums = new int[n + 1];
        int[] ele = new int[n + 1];
        nums[0] = 1;
        for (int prime : primes) {
            Ele ele = new Ele(0, prime, prime);
            pq.add(ele);
        }
        for (int i = 1; i < n; i++) {
            Ele ele = pq.poll();
            if (nums[i - 1] == ele.val) {
                i--;
            }
            nums[i] = ele.val;
            ele.val = ele.prime * nums[++ele.idx];
            pq.add(ele);
            //System.out.print(nums[i] + " ");
        }
        return nums[n - 1];
    }
}

class Ele {
    int idx, val, prime;
    public Ele(int idx, int prime, int val) {
        this.idx = idx;
        this.prime = prime;
        this.val = val;
    }
}
