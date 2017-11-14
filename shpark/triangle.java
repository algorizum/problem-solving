class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
		int size=triangle.size();
		for (int i = 0; i <size; i++) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				int cur = triangle.get(i).get(j);
				if (i > 0) {
					if(j==0){
						triangle.get(i).set(j, triangle.get(i - 1).get(j) + cur);
					}else if(j==i){
						triangle.get(i).set(j, triangle.get(i - 1).get(j - 1) + cur);
					}else{
						triangle.get(i).set(j,Math.min(triangle.get(i - 1).get(j - 1) + cur, triangle.get(i - 1).get(j) + cur));
					}
				}
			}
		}
		int min=Integer.MAX_VALUE;
		for(int i:triangle.get(size-1))min=Math.min(min, i);
		return min;
	}
}