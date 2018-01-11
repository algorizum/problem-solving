class Solution {
    public int arrangeCoins(int n) {
        return (int)Math.floor((Math.sqrt((n*8.0)+1)-1)/2);
    }
}
