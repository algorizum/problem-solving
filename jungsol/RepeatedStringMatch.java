public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder repeatedA = new StringBuilder(A);
        for(int i = 0; i < Math.ceil((B.length()-1)/(double)A.length()); i++) {
            repeatedA.append(A);
        }
        if(!repeatedA.toString().contains(B)) return -1;
        int aIndex = 0, bIndex = 0;
        while(bIndex < B.length()) {
            bIndex = (B.charAt(bIndex) == repeatedA.charAt(aIndex)) ? bIndex+1 : 0;
            aIndex++;
        }
        return ((aIndex-1)/A.length()) + 1;
    }
    
    public static void main(String[] args) {
        RepeatedStringMatch solution = new RepeatedStringMatch();
        System.out.println(solution.repeatedStringMatch("abcd", "cdabcdab")); //3
        System.out.println(solution.repeatedStringMatch("abd", "cccc")); //-1
        System.out.println(solution.repeatedStringMatch("a", "aa")); //2
        System.out.println(solution.repeatedStringMatch("abcabcabcabc", "abac")); //-1
        System.out.println(solution.repeatedStringMatch("abacababacab", "abcdabcdabcdabcd")); //-1
    }
}
