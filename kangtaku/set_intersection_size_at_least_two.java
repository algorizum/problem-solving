class Solution {
    public int intersectionSizeTwo(int[][] inters) {
        int i,n=inters.length;
        Arrays.sort(inters,(x,y) -> {
            return x[1]!=y[1]?x[1]-y[1]:
                        x[0]!=y[0]?y[0]-x[0]:
                        0;
        });
        Set<Integer> st = new HashSet<>();
        int end=inters[0][1],start=end-1;
        st.add(start);
        st.add(end);
        for(i=1;i<n;i++){
            int[] inter=inters[i];
            if(start>=inter[0]&&end<=inter[1]){
                continue;
            }else if(start<inter[0]&&end<inter[0]){
                end=inter[1];
                start=end-1;
                st.add(start);
                st.add(end);
            }else{
                start=end;
                end=inter[1];
                st.add(end);
            }
        }
        return st.size();
    }
}
