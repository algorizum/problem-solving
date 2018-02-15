class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx != tx || sy != ty) {
            if (sx > tx || sy > ty) return false;
            if (sx == tx) return (ty - sy) % tx == 0;
            if (sy == ty) return (tx - sx) % ty == 0;
            if (tx > ty) tx = tx % ty;
            else ty = ty % tx;
        }
        return false;
    }
}
