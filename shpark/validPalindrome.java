class validPalindrome {
    public boolean validPalindrome(String s) {
		char[] ss=s.toCharArray();
		int sLen=s.length();
		boolean onedel=true;
		for(int l=0; l<sLen/2;l++){
			int r=sLen-1-l;
			if(ss[l]!=ss[r]){
				onedel=isPalindrome(ss,l,r-1) || isPalindrome(ss,l+1,r);
				break;
			}
		}
		
		return onedel;
	}
	public boolean isPalindrome(char[] s, int start, int end){
		boolean ispalin=true;
		int mid=(end-start)/2+start;
		for(int l=start,r=end; l<=mid;l++,r--){
			if(s[l]!=s[r]){
				ispalin=false;
				break;
			}
		}
		return ispalin;
	}
    /*
    public boolean validPalindrome(String s) {
		boolean onedel=true;
		for(int l=0; l<s.length()/2;l++){
			int r=s.length()-1-l;
			if(s.charAt(l)!=s.charAt(r)){
				onedel=isPalindrome(s.substring(l, r)) || isPalindrome(s.substring(l+1,r+1));
				break;
			}
		}
		
		return onedel;
	}
	public boolean isPalindrome(String s){
		boolean ispalin=true;
		for(int l=0; l<s.length()/2;l++){
			if(s.charAt(l)!=s.charAt(s.length()-1-l)){
				ispalin=false;
				break;
			}
		}
		return ispalin;
	}
	*/
}