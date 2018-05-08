package easy;

/**
 * Created by minji on 2017-09-19.
 */
public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1, false);
    }

    public boolean isPalindrome(String s, int idx, int jdx, boolean invalid) {
        while (idx <= jdx) {
            if (s.charAt(idx) != s.charAt(jdx)) {
                if (invalid) {
                    return false;
                }
                return isPalindrome(s, idx + 1, jdx, true) || isPalindrome(s, idx, jdx - 1, true);
            }
            idx += 1;
            jdx -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome2 vp = new ValidPalindrome2();
        System.out.println(vp.validPalindrome("bbaabb"));
    }
}
