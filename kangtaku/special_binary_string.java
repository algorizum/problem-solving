class Solution {
    public String makeLargestSpecial(String S) {
        if (S.length() == 0) return "";
        int first = 0, n = S.length(), cnt = 0;
        List<String> arr = new ArrayList<>();
        // System.out.println(S);
        for (int end = 0; end < n; end++) {
            cnt += S.charAt(end) == '1' ? 1 : -1;
            // System.out.println(cnt);
            if (cnt == 0) {
                String t = "1" + makeLargestSpecial(S.substring(first + 1, end)) + "0";
                // System.out.println("t = " + t);
                arr.add(t);
                first = end + 1;
            }
        }
        String res = "";
        Collections.sort(arr, Collections.reverseOrder());
        for (String part : arr) {
            // System.out.print(part + " ");
            res += part;
        }
        return res;
    }
}
