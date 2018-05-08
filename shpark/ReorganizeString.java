import java.util.*;

public class ReorganizeString {
	public String reorganizeString(String S) {
		
		int can=(S.length() / 2 + S.length() % 2);
		Map<Character, Integer> appears = new HashMap<>();
		for (char key : S.toCharArray()) {
			int val = appears.getOrDefault(key, 0) + 1;
			if (val > can)return "";
			appears.put(key, val);
		}

		LinkedList<Character> sortedKeys = new LinkedList<>(appears.keySet());

		for (int i = sortedKeys.size()-1; i >=0 ; i--) {
			boolean flag=true;
			for (int j = 0; j < i; j++) {
				char c = sortedKeys.get(j), d = sortedKeys.get(j + 1);
				if (appears.get(c) < appears.get(d)) {
					sortedKeys.set(j, d);
					sortedKeys.set(j + 1, c);
					flag=false;
				}
			}
			if(flag)break;
		}

		StringBuilder result = new StringBuilder();

		char lastkey = '-';

		while (sortedKeys.size() > 1) {
			
			char key = sortedKeys.get(0);
			char nextkey = sortedKeys.get(1);
			
			if (key == lastkey) {
				char tmp = nextkey;
				nextkey = key;
				key = tmp;
			}

			while (appears.get(key) > 0 && appears.get(nextkey) > 0) {
				result.append(key);
				result.append(nextkey);
				lastkey = nextkey;
				appears.put(key, appears.get(key) - 1);
				appears.put(nextkey, appears.get(nextkey) - 1);

			}
			if (appears.get(key) == 0){
				appears.remove(key);
				sortedKeys.remove((Character)key);
			}
			if (appears.get(nextkey) == 0){
				appears.remove(nextkey);
				sortedKeys.remove((Character)nextkey);
			}
		}
		
		if(sortedKeys.size()==1) {
			char key=sortedKeys.get(0);
			int idx=0;
			while (appears.get(key) > 0) {
				if (lastkey == key) {
					result.insert(idx, key);
					idx += 2;
				} else
					result.append(key);
				appears.put(key, appears.get(key) - 1);
			}
        }

		return result.toString();
	}
}
