class Solution {
    public boolean canTransform(String start, String end) {
        String s1 = "", s2 = "";
        char[] sc = start.toCharArray();
        int n = sc.length;
        int[] sci = new int[n];
        int[] eci = new int[n];
        char[] ec = end.toCharArray();
        int i=0, j=0;
        while (i < n && j < n) {
            // System.out.println(i+","+j);
            while (i<n&&sc[i] == 'X') {
                i++;
            }
            while (j<n&&ec[j] == 'X') {
                j++;
            }
            if ((i == n && j < n )||(i < n && j == n ))return false;
            if (i ==n && j == n) return true;
            if(sc[i]!=ec[j]) return false;
            if(sc[i]=='R'&&i>j) {
                return false;
            }
            if(sc[i]=='L'&&i<j) {
                return false;
            }
            i++;
            j++;
        }
        
        return true;
    }
}
