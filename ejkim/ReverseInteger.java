/*
*  https://leetcode.com/problems/reverse-integer/description/
*
*  ex.
*  Input: 123
*  Output: 321
*
*  Input: -123
*  Output: -321
*
*  input값을 string으로 변환해 i번째 index는 string길이 - i -1 번째의 값을 변경한다.
*  양수/음수의 경우 변수를 둬 따로 분리한다음 마지막에 붙인다.
*  만약에 reverse값이 int의 값을 넘거나 -를 +로 바꿨을 경우 범위를 넘었을 경우 0을 리턴
*
* */
public class ReverseInteger {
  public int reverse(int x) {
    int positive = 1;
    if( x < 0 ) {
      if( (x * -1L) >= Integer.MAX_VALUE ) {
        return 0;
      }
      x *= -1;
      positive = -1;
    }
    String strX = x + "";
    int strLen = strX.length();
    char[] charX = new char[strLen];
    for( int i = 0 ; i < strLen / 2 ; i++ ) {
      charX[i] = strX.charAt(strLen - i - 1);
      charX[strLen - i - 1] = strX.charAt(i);
    }
    if( strLen % 2 == 1 ) {
      int half = strLen / 2;
      charX[half] = strX.charAt(half);
    }
    String revStrX = "";
    for( int i = 0 ; i < charX.length ; i++ ) {
      revStrX += Character.toString(charX[i]);
    }
    System.out.println(Long.parseLong(revStrX));
    Long chkResult = Long.parseLong(revStrX) * positive;
    if ( Integer.MAX_VALUE < chkResult || Integer.MIN_VALUE > chkResult ) {
      return 0;
    }
    return positive * Integer.parseInt(revStrX);
  }
  public static void main(String[] args) {
    ReverseInteger reverseInteger = new ReverseInteger();
    //System.out.println(reverseInteger.reverse(1534236469));
    System.out.println(reverseInteger.reverse(-2147483648));
  }
}
