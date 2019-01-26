import java.util.*;

/**
 * 第四个测试点没有通过.
 */
public class Exer15 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int temp;
    List<Pair> pairList = new ArrayList<>();
    while ((temp = scanner.nextInt()) > 0) {
      Pair pair = new Pair(temp, scanner.nextInt());
      pairList.add(pair);
    }

    String result = "";
    for (int i = 0; i < pairList.size(); i++) {
      int number = pairList.get(i).number;
      int radix = pairList.get(i).radix;
      if (isPrime(number)) {
        // 转k进制数
        int a = parseInt(number, radix);
        // 逆转
        String reverse = reverse(a);
        // 转十进制数
        int b = Integer.parseInt(reverse, radix);
        // 判断是否是质数
        if (isPrime(b)) {
          result = result + "Yes" + "\n";
        } else {
          result = result + "No" + "\n";
        }
      } else {
        result = result + "No" + "\n";
      }
    }
    System.out.println(result.trim());
  }

  private static int parseInt(int decimal, int radix) {
    // 除2取余法
    if (decimal == 0) {
      return 0;
    }
    return parseInt(decimal / radix, radix) * 10 + decimal % radix;
  }

  private static boolean isPrime(int a) {
    boolean isPrime = true;
    if (a == 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(a); i++) {
      if (a % i == 0) {
        isPrime = false;
        break;
      }
    }
    return isPrime;
  }

  private static String reverse(int number) {
    if (number == 0) {
      return "";
    }
    return number % 10 + reverse(number / 10);
  }
}

class Pair {
  int number;
  int radix;

  public Pair(int number, int radix) {
    this.number = number;
    this.radix = radix;
  }
}
