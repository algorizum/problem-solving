class Solution {
    public int numRabbits(int[] answers) {
        int n=answers.length,i;
        if(n==0)return 0;
        int[] mp=new int[1000];
        for(i=0;i<n;i++){
            mp[answers[i]]++;
        }
        if (n==1) return answers[0] + 1;
        int res=0;
        for(i=0;i<=999;i++){
            if(mp[i]==0)continue;
            res+=(i+1)*Math.ceil((double)mp[i]/(i+1));
        }
        return res;
    }
}
