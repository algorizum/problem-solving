package december_2017;

import java.util.*;

public class DailyTemperature {
	public int[] dailyTemperatures(int[] temperatures) {
		if (temperatures.length < 2)return new int[] { 0 };
		int[] result = new int[temperatures.length];
		Deque<Integer> stack=new ArrayDeque<>();
		stack.push(0);
		for (int i = 1; i < temperatures.length; i++) {
			while(!stack.isEmpty()){
			int idx=stack.peek();
			if(temperatures[idx]<temperatures[i]){result[idx]=i-idx;stack.pop();}
			else{break;}
			}
			stack.push(i);
		}
		return result;

	}
}
