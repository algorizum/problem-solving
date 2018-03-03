class Solution {
    public String customSortString(String S, String T) {
        char[] t = T.toCharArray();
        char[] c = S.toCharArray();
        int n = t.length, i, j;

        for(i=0;i<n;i++){
            for(j=i+1;j<n;j++){
                int xi=-1, yi=-1;
                for(int k=0;k<c.length;k++) {
                    if(c[k]==t[i]) {
                        xi=k;
                        break;
                    }
                    if (c[k]==t[j]){
                        yi=k;
                        break;
                    }
                }
                if(xi<yi){
                    char tt=t[i];
                    t[i]=t[j];
                    t[j]=tt;
                }
            }
        }
        return String.valueOf(t);
    }
}
