/*
* x와 y의 bit가 다른것을 찾는 문제이다.
* xor 연산은 배타적으로 참일경우에 1을 출력하므로
* x와 y의 xor 연산을 한 후 비트중 1인 것의 갯수를 찾으면 된다
* */
public class HammingDistance {
  public String decimalToBinary(int x) {
    String str = "";
    while( x > 0 ) {
      str += (x % 2);
      x /= 2;
    }
    return str;
  }
  public int hammingDistance(int x, int y) {
    // 1. xor 연산
    // 2. 2진수로 변환
    // 3. 1의 갯수 리턴
    String str = decimalToBinary(x^y);
    int cnt = 0;
    for( int i = 0 ; i < str.length() ; i++ ) {
      if( str.charAt(i) == '1' )
        cnt++;
    }
    return cnt;
  }
  public static void main(String[] args) {
    int x = 1;
    int y = 4;
    HammingDistance hd = new HammingDistance();
    System.out.println(hd.hammingDistance(x, y));
  }
}
