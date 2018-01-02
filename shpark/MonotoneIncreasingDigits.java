class Solution {
    public int monotoneIncreasingDigits(int N) {
		if(N<10)return N;
		char[] c=String.valueOf(N).toCharArray();
		int idx=0;
		boolean isSame=false;
		for(int i=0; i<c.length-1;i++){
			if(c[i]<c[i+1])idx=i+1;
			else if(c[i]==c[i+1])isSame=true;
            else {isSame=false;break;}
		}
		if(idx!=c.length-1 &&isSame==false){
			c[idx]--;
			for(int i=idx+1; i<c.length;i++)c[i]='9';
		}
        return Integer.valueOf(new String(c));
	}
}