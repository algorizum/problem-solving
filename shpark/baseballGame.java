package test;

public class baseballGame {
	public int calPoints(String[] ops) {
		int sum = 0;
		int[] intarr = new int[ops.length];
		int lastpoint = -1;

		for (String s : ops) {

			switch (s) {
			case "+":
				intarr[++lastpoint] = intarr[lastpoint - 1] + intarr[lastpoint - 2];
				sum += intarr[lastpoint];
				break;
			case "D":
				intarr[++lastpoint] = intarr[lastpoint - 1] * 2;
				sum += intarr[lastpoint];
				break;
			case "C":
				sum -= intarr[lastpoint--];
				break;
			default:
				intarr[++lastpoint] = Integer.parseInt(s);
				sum += intarr[lastpoint];
			}

		}
		return sum;
	}
}
