class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int i,j,n=ghosts.length;
        for(i=0;i<n;i++){
            int[] ghost = ghosts[i];
            int dis1=Math.abs(target[0]-ghost[0]) + Math.abs(target[1]-ghost[1]);
            if(Math.abs(target[0])+Math.abs(target[1])>=dis1){
                return false;
            }
        }
        return true;
    }
}
