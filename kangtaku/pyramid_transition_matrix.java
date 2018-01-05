class Solution {
    int[][] g,d;
    int n;
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int m=allowed.size(),i,j;
        n=bottom.length();
        g = new int[26][26];
        d=new int[n][n];
        for(i=0;i<m;i++){
            char[] allow = allowed.get(i).toCharArray();
            g[allow[0]-'A'][allow[1]-'A']|=(1<<(allow[2]-'A'));
        }
        char[] bc=bottom.toCharArray();
        for(i=0;i<n;i++){
            d[0][i]=(1<<(bc[i]-'A'));
        }
        return canMake(1,0);
    }
    public int get(int v){
        for(int i=0;i<31;i++){
            if(((1<<i)&v)!=0){
                return i;
            }
        }
        return 0;
    }
    public boolean canMake(int x, int y) {
        if(x==n)return true;
        int a=get(d[x-1][y]);
        int b=get(d[x-1][y+1]);
        boolean res=false;
        for(int i=0;i<26;i++){
            int t=(1<<i)&g[a][b];
            if(t!=0){
                d[x][y]|=(1<<i);
                if(n-1-x==y) res|=canMake(x+1,0);
                else res|=canMake(x,y+1);
                if(res) return true;
                else{
                    d[x][y]&=~(1<<i);
                }
            }
        }
        return res;
    }
}
