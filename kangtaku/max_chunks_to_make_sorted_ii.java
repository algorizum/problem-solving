class Solution {
    public int maxChunksToSorted(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        int i, n = arr.length, j, ans = 0, v;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        for (i = 0; i < n; i++) mp.putIfAbsent(sorted[i], i);
        
        j = -1;
        v = -1;
        for (i = 0; i < n; i++) {
            if (v == arr[i]) j++;
            else if (j < mp.get(arr[i])) {
                j = mp.get(arr[i]);
                v = arr[i];
            }
            if (i >= j) ans++;
        }
        
        return ans;
    }
}
