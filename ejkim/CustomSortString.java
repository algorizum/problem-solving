
public class CustomSortString {
  public String customSortString(String S, String T) {
    int[] alpha = new int[26];
    String result = "";
    for( int i = 0 ; i <  T.length() ; i++ ) {
      alpha[T.charAt(i) - 'a']++;
    }
    for( int i = 0 ; i <  S.length() ; i++ ) {
      int alphaCnt = alpha[S.charAt(i) - 'a'];
      if( alphaCnt > 0 ) {
        for( int j = 0 ; j < alphaCnt ; j++ ) {
          result += S.charAt(i);
        }
        alpha[S.charAt(i) - 'a'] = 0;
      }
    }
    for( int i = 0 ; i < alpha.length ; i++ ) {
      int alphaCnt = alpha[i];
      if( alphaCnt > 0 ) {
        for( int j = 0 ; j < alphaCnt ; j++ ) {
          result += (char)('a' + i);
        }
        alpha[i] = 0;
      }
    }
    return result;
  }
  public static void main(String[] args) {
    CustomSortString css = new CustomSortString();
    String S = "cba";
    String T = "abcd";
    System.out.println(css.customSortString(S, T));
  }
}
