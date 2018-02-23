import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;


public class SwapAdjacentInLRString {

	@Test
	public void test() {
		assertTrue(canTransform("XXXLXXXXXX","XXXLXXXXXX"));
		assertFalse(canTransform("XLLR","LXLX"));
		assertFalse(canTransform("LXX","XXL"));
		assertFalse(canTransform("LXX","XLX"));
		assertTrue(canTransform("RXXLRXRXL", "XRLXXRRLX"));
	}

	public boolean canTransform(String start, String end) {
		char[] s=start.toCharArray(),e=end.toCharArray();
		Queue<Character> q=new LinkedList<>();
		for(int k=0;k<start.length();k++) {
			if(e[k]=='R'){
				q.add(e[k]);
				int l=k;
				while(l>=0) {
					if(s[l]=='R') {
						s[l]='X';
						break;
					}else if(s[l]=='L')
						return false;
					l--;
				}
				if(l<0)return false;
			}else if(e[k]=='L'){
				q.add(e[k]);
				int r=k;
				while(r<end.length()) {
					if(s[r]=='L') {
						s[r]='X';
						break;
					}else if(s[r]=='R')
						return false;
					r++;
				}
				if(r==end.length() )return false;
			}
		}
		s=start.toCharArray();
		for(int i=0; i<s.length;i++) {
			if(s[i]!='X') {
				char val=q.isEmpty()?'X':q.poll();
				if(val!=s[i])return false;
			}
		}
		return true;
	}
}
