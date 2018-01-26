class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, i = 0, j, ans = 0;
        while (i < n) {
            j = i;
            while (i != arr[i]) {
                if (arr[i] < i) break;
                i = arr[i];
            }
            while (j <= i) {
                if (arr[j] > i) i = arr[j];
                j++;
            }
            i++;
            ans++;
        }
        return ans;
    }
}
